package projects.weather.ui;

import common.containers.Credentials;
import common.ui.lib.BaseUiTestCase;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import weather.ui.price.PricePage;

public class CheckPrice extends BaseUiTestCase {

    @Parameters({"baseUrl"})
    public CheckPrice(String baseUrl) {
        super(new Credentials(baseUrl));
    }

    @Test
    @Parameters({"price", "tariffName"})
    public void checkPrice(String price, String tariffName) {
        String actualPrice = new PricePage(credentials.baseUrl)
                .openPage()
                .tariffBlock()
                .getPriceByName(tariffName);

        Assert.assertEquals(actualPrice, price,
                "Ошибка в проверке цены");
    }
}
