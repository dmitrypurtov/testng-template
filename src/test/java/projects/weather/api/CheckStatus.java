package projects.weather.api;

import common.base.BaseTestCase;
import common.containers.Credentials;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import weather.api.containers.openweathermap.ModelOpenWeatherMap;
import weather.api.helpers.WeatherHelper;

public class CheckStatus extends BaseTestCase {

    @Parameters({"baseUrl"})
    public CheckStatus(String baseUrl) {
        super(new Credentials(baseUrl));
    }

    @Test
    @Parameters({"city", "cod"})
    public void checkCod(String city, Integer cod) {
        ModelOpenWeatherMap modelOpenWeatherMap = new WeatherHelper(credentials).getOpenWeatherMap(city);
        Assert.assertEquals(modelOpenWeatherMap.getCod(), cod,
                "Ошибка в проверке Cod");
    }
}
