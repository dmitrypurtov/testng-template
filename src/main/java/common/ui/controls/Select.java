package common.ui.controls;

import com.codeborne.selenide.SelenideElement;
import common.ui.lib.BasePageObject;

import java.util.ArrayList;
import java.util.List;

public class Select extends BasePageObject {
    private final static String
            OPTIONS = "xpath:./option";

    private final SelenideElement m_root;

    public Select(SelenideElement root) {
        m_root = root;
    }

    public void selectOptionByContainsOption(String value) {
        List<SelenideElement> options = getChildElementList(m_root, OPTIONS);
        for (SelenideElement item : options) {
            if (item.text().replace(" ", "").toLowerCase().contains(value.replace(" ", "").toLowerCase())) {
                selectOption(item.text());
                return;
            }
        }
        throw new IllegalArgumentException("Cannot set option \"" + value + "\" of locator");
    }

    public void selectOption(String value) {
        m_root.selectOption(value);
    }

    public void selectOptionByValue(String value) {
        m_root.selectOptionByValue(value);
    }

    public String getValue() {
        return m_root.getValue();
    }


    public List<String> getTextOptions() {
        List<SelenideElement> optionElements = getChildElementList(m_root, OPTIONS);
        List<String> options = new ArrayList<>();
        for (SelenideElement item : optionElements) {
            options.add(item.text());
        }
        return options;
    }
}
