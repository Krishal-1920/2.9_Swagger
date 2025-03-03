package net.engineeringdigest.journalApp.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class WeatherResponse {

    @JsonProperty("current")  // This ensures correct mapping of the API response
    private Current current;

    @Getter
    @Setter
    public static class Current {
        @JsonProperty("temperature")
        private int temperature;

        @JsonProperty("weather_descriptions")
        private List<String> weatherDescriptions;

        @JsonProperty("wind_speed")
        private int windSpeed;

        @JsonProperty("feelslike")
        private int feelsLike; // Ensure "feelslike" field is correctly mapped
    }
}
