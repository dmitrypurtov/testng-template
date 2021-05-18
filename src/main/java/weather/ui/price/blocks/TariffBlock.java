package weather.ui.price.blocks;

import com.codeborne.selenide.SelenideElement;
import common.ui.lib.BasePageObject;

import java.util.List;

public class TariffBlock extends BasePageObject {

    private final SelenideElement root;

    private static final String
            CONTEXT_BLOCK = "xpath://section[@id='current']//table",
            TABLE_HEAD = "xpath:.//thead//th",
            TABLE_HEAD_TITLE = "xpath:.//h3",
            TABLE_HEAD_PRICE_H4 = "xpath:.//h4",
            TABLE_HEAD_PRICE_H4_PRICE = "xpath:.//b";

    public TariffBlock() {
        root = getElement(CONTEXT_BLOCK);
    }

    public String getPriceByName(String name) {
        List<SelenideElement> list = getChildElementList(root, TABLE_HEAD);
        for (SelenideElement item : list) {
            String title = getChildElement(item, TABLE_HEAD_TITLE).text();
            if (title.equals(name)) {
                SelenideElement head = getChildElement(item, TABLE_HEAD_PRICE_H4);
                if (head.text().isEmpty()) return "";
                return getChildElement(head, TABLE_HEAD_PRICE_H4_PRICE).text();
            }
        }
        return "";
    }
}