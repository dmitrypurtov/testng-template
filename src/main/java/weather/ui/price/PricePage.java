package weather.ui.price;

import common.ui.lib.BasePageObject;
import weather.ui.price.blocks.TariffBlock;

import static com.codeborne.selenide.Selenide.open;

public class PricePage extends BasePageObject {
    private static final String PAGE_URL = "https://BASE_URL/price";
    private final String m_pageUrl;

    private static String
            TITLE = "xpath://h1";


    public PricePage(String baseUrl) {
        m_pageUrl = PAGE_URL.replace("BASE_URL", baseUrl);
    }

    public PricePage openPage() {
        open(m_pageUrl);
        return this;
    }

    public TariffBlock tariffBlock() {
        open(m_pageUrl);
        return new TariffBlock();
    }
}