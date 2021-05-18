package common.listeners;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;

public class SimpleTestResultLogListener extends TestListenerAdapter {
    private static String TEST_SUITE_START_TEXT = "\n\n\n***************Test suite %s started***************\n";
    private static final String UNDERLINE = "==============================================================================================";
    private static final String absolutePath;
    private static String suiteName = "";
    private static String suitePath = "";
    private static String suiteTestName = "";
    private static String suiteTestNameSuccess = "";

    public static String getSuiteTestName() {
        return suiteTestName;
    }

    public static String getSuiteName() {
        return suiteName;
    }

    static {
        absolutePath = new File("").getAbsolutePath();
    }

    @Override
    public void onStart(ITestContext tr) {
        if (!tr.getSuite().getXmlSuite().getName().equals(suiteName)) {
            suiteName = tr.getSuite().getXmlSuite().getName();
            suitePath = tr.getSuite().getXmlSuite().getFileName().replace(absolutePath, "");
            System.out.println(String.format(TEST_SUITE_START_TEXT, suiteName));
        }
        suiteTestName = tr.getName();
    }

    @Override
    public void onTestStart(ITestResult result) {
        suiteTestName = result.getName();
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        StringBuilder builder = new StringBuilder();
        ITestContext context = tr.getTestContext();
        builder
                .append(UNDERLINE).append(System.lineSeparator())
                .append("Test failed").append(System.lineSeparator())
                .append("\tName: ").append(context.getName()).append(System.lineSeparator())
                .append("\tMethod: ").append(tr.getName()).append(System.lineSeparator())
                .append("\tSuite: ").append(suitePath).append(System.lineSeparator())
                .append("\tClass:").append(tr.getInstanceName()).append(System.lineSeparator());

        String message = tr.getThrowable().getMessage();
        if (message != null)
            builder.append("\tAssert message: \n").append(message.replace("\n", "\n\t")).append(System.lineSeparator());
        builder.append(UNDERLINE).append(System.lineSeparator());
        System.out.println(builder);
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        StringBuilder builder = new StringBuilder();
        ITestContext context = tr.getTestContext();
        builder
                .append(UNDERLINE).append(System.lineSeparator())
                .append("Test skipped").append(System.lineSeparator())
                .append("\tName: ").append(context.getName()).append(System.lineSeparator())
                .append("\tMethod: ").append(tr.getName()).append(System.lineSeparator())
                .append("\tSuite: ").append(suitePath).append(System.lineSeparator())
                .append("\tClass:").append(tr.getInstanceName()).append(System.lineSeparator());

        String message = tr.getThrowable().getMessage();
        if (message != null)
            builder.append("\tAssert message: \n").append(message.replace("\n", "\n\t")).append(System.lineSeparator());

        builder.append(UNDERLINE).append(System.lineSeparator());
        System.out.println(builder);
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        StringBuilder builder = new StringBuilder();
        ITestContext context = tr.getTestContext();
        if (!suiteTestNameSuccess.equals(context.getName())) {
            builder
                    .append(System.lineSeparator())
                    .append("Test success!").append(System.lineSeparator())
                    .append("\tName: ").append(context.getName()).append(System.lineSeparator());
        }
        builder.append("\tMethod: ").append(tr.getName()).append(System.lineSeparator());
        System.out.println(builder.toString());
        suiteTestNameSuccess = context.getName();
    }
}
