package weather.api.dictionary;

import com.google.gson.annotations.SerializedName;

/**
 * Справочниу погоды
 */
public class WeatherDictionary {
    public enum Temperature {
        /**
         * Градусы
         */
        @SerializedName("0")
        DEGREES,
        /**
         * Цельсия
         */
        @SerializedName("0")
        CELSIUS
    }
}
