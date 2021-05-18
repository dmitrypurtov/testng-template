package common.ui.lib;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.UIAssertionError;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasePageObject {
    protected final static int
            ONE_SECOND = 1000,
            CHECK_REPEAT = 5;

    protected SelenideElement getElement(String locator) {
        return getElement(locator, "Элемент не найден");
    }

    public SelenideElement getElement(String locator, String errorMessage) {
        By by = getLocatorByString(locator);
        try {
            return $(by).should(Condition.exist);
        } catch (UIAssertionError exception) {
            throw new NoSuchElementException(errorMessage);
        }
    }

    public boolean isExistElement(SelenideElement parent, String locator) {
        By by = getLocatorByString(locator);
        try {
            return parent.find(by).is(Condition.exist);
        } catch (UIAssertionError exception) {
            return false;
        }
    }

    public boolean isExistElement(String locator) {
        By by = getLocatorByString(locator);
        try {
            return $(by).is(Condition.exist);
        } catch (UIAssertionError exception) {
            return false;
        }
    }

    protected List<SelenideElement> getElementList(String locator) {
        return getElementList(locator, "Не удаётся найти список элементов");
    }

    public List<SelenideElement> getElementList(String locator, String errorMessage) {
        getElement(locator, errorMessage);
        return $$(getLocatorByString(locator));

    }

    protected SelenideElement getChildElement(SelenideElement parent, String locator) {
        return parent.find(getLocatorByString(locator));
    }

    protected List<SelenideElement> getChildElementList(SelenideElement parent, String locator) {
        return parent.findAll(getLocatorByString(locator));
    }

    protected void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private By getLocatorByString(String locatorWithType) {
        String[] explodedLocator = locatorWithType.split(Pattern.quote(":"), 2);
        String byType = explodedLocator[0];
        String locator = explodedLocator[1];

        if (byType.equals("xpath")) {
            return By.xpath(locator);
        } else if (byType.equals("id")) {
            return By.id(locator);
        } else {
            throw new IllegalArgumentException("Cannot get type of locator. Locator: " + locatorWithType);
        }
    }
}
