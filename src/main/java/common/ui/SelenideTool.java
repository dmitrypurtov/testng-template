package common.ui;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.WebDriverRunner.*;

public class SelenideTool {

    private static final int TIMEOUT = 60000;
    private static final int PAGE_LOAD_TIMEOUT = 55;
    private static final int POLLING_INTERVAL = 500;
    private static final int LOOP_TIMEOUT = 200;
    private static final int MAX_ELEMENT_MOVING_TIMEOUT = 60000;
    private static final int VIDEO_RECORD_WIDTH = 1280;
    private static final int VIDEO_RECORD_HEIGHT = 1024;

    public SelenideTool() {
        Configuration.timeout = TIMEOUT;
        Configuration.pollingInterval = POLLING_INTERVAL;
        RemoteWebDriver driver = new RemoteWebDriverHub().getRemoteWebDriver();
        driver.manage().window().setSize(new Dimension(VIDEO_RECORD_WIDTH, VIDEO_RECORD_HEIGHT));
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        setWebDriver(driver);
    }

    public static void closeDriver() {
        if (hasWebDriverStarted())
            getWebDriver().quit();
    }
}