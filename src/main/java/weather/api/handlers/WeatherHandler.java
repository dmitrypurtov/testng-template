package weather.api.handlers;

import weather.api.containers.openweathermap.ModelOpenWeatherMap;
import weather.api.containers.openweathermap.Weather;

public class WeatherHandler {

    /**
     * Функция получения погоды по имени
     *
     * @param root - объекут где ищем погоду
     * @param name - название погоды
     */
    public static Weather getWeatherByName(ModelOpenWeatherMap root, String name) {
        return root.getWeather().stream().filter(e -> e.getMain().toLowerCase().equals(name.toLowerCase())).findAny().orElse(null);
    }
}