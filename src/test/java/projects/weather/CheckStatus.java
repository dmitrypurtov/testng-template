package projects.weather;

import common.base.BaseTestCase;
import common.containers.Credentials;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import weather.api.containers.openweathermap.ModelOpenWeatherMap;
import weather.api.helpers.WeatherHelper;

public class CheckStatus extends BaseTestCase {

    @Test
    @Parameters({"baseUrl", "city", "cod"})
    public void test(String baseUrl, String city, Integer cod) {
        ModelOpenWeatherMap modelOpenWeatherMap = new WeatherHelper(new Credentials(baseUrl)).getOpenWeatherMap(city);
        Assert.assertEquals(modelOpenWeatherMap.getCod(), cod,
                "Ошибка в проверке Cod");
    }
}
