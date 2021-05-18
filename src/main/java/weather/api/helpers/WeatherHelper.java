package weather.api.helpers;

import common.base.BaseAuth;
import common.containers.Credentials;
import weather.api.containers.openweathermap.ModelOpenWeatherMap;

public class WeatherHelper extends BaseAuth {
    private final static String
            REQUEST_GET_OPEN_WEATHER = "http://BASE_URL/data/2.5/weather?q=CITY&units=metric&appid=APP_ID";

    public WeatherHelper(Credentials credentials) {
        super(credentials);
    }

    /**
     * Функция получения погоды по городу
     *
     * @param city - город латиницей
     */
    public ModelOpenWeatherMap getOpenWeatherMap(String city) {
        String url = REQUEST_GET_OPEN_WEATHER
                .replace("BASE_URL", credentials.baseUrl)
                .replace("APP_ID", credentials.keys.get("APP_ID"))
                .replace("CITY", city);
        return sendGetRequest(url, ModelOpenWeatherMap.class);
    }
}
