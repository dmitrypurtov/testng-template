package common.base;

import common.containers.Credentials;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestCase {
    protected static final int SLEEP_THREAD_COUNT = 60;
    protected static final int ONE_SECOND = 1000;
    protected static final int MAX_REQUEST_COUNT = 60;

    protected Credentials credentials;

    public BaseTestCase(Credentials credentials) {
        this.credentials = credentials;
    }

    @BeforeMethod(description = "Api вход")
    public void signIn() {
    }


    @AfterMethod(description = "Выход", alwaysRun = true)
    public void signOut() {
    }

    protected void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
