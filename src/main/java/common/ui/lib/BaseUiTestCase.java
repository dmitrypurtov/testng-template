package common.ui.lib;

import common.base.BaseTestCase;
import common.containers.Credentials;
import common.ui.SelenideTool;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseUiTestCase extends BaseTestCase {

    public BaseUiTestCase(Credentials credentials) {
        super(credentials);
    }

    @BeforeMethod(description = "UI вход в Extranet")
    public void authorization() {
        new SelenideTool();
        //TODO authorization from API and insert cookies in driver
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown() {
        try {
            SelenideTool.closeDriver();
        } catch (WebDriverException exception) {
            //TODO logs
        }
    }
}