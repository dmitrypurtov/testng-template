package common.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class RemoteWebDriverHub {

    private final String browserName;
    private final String platformName;
    private final String browserVersion;

    public RemoteWebDriverHub() {
        this.browserName = System.getProperty("browserName") != null ? System.getProperty("browserName").toLowerCase() : "chrome";
        this.platformName = System.getProperty("platformName");
        this.browserVersion = System.getProperty("browserVersion");
    }

    public RemoteWebDriver getRemoteWebDriver() {
        RemoteWebDriver driver = null;
        System.out.println("\nRemoteWebDriver settings:\n" +
                "\tBrowser name:" + browserName + "\n" +
                "\tPlatform name:" + ((platformName != null) ? platformName : "selenoid") + "\n");
        switch (browserName) {
            case "chrome":
                driver = getChromeRemoteWebDriver();
                break;
            case "firefox":
                driver = getSeleniumFirefoxRemoteWebDriver();
                break;
            default:
                Assert.fail("Ошибка при передаче имени браузера " + browserName);
                break;
        }
        Assert.assertNotNull(driver, "Ошибка при создании RemoteWebDriver для " + browserName);
        System.out.println("SessionID: " + driver.getSessionId());
        return driver;
    }

    private RemoteWebDriver getChromeRemoteWebDriver() {
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private RemoteWebDriver getSeleniumFirefoxRemoteWebDriver() {
        WebDriverManager.firefoxdriver().setup();
        RemoteWebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
}