package ee;

import com.fasterxml.jackson.databind.ObjectMapper;
import ee.api.Forecast;
import ee.api.WeatherForecast;
import java.net.URL;

public class WeatherForecastService {

    public static final String API_KEY = "02de4f9608f50b67b16dbb2370997657";

    public static final String URL_CURRENT = "http://api.openweathermap.org/data/2.5/weather?q=Tallinn,ee&units=metric";

    public static final String URL_FORECAST = "http://api.openweathermap.org/data/2.5/forecast?q=Tallinn,ee&units=metric";

    private static final ObjectMapper mapper = new ObjectMapper();

    public WeatherForecast getCurrentWeather(WeatherForecast request) throws Exception {
        String url = appendApiKey(URL_CURRENT);
        WeatherForecast weatherForecast = mapper.readValue(new URL(url), WeatherForecast.class);
        return weatherForecast;
    }

    public Forecast getForecastForThreeDays(WeatherForecast request) throws Exception {
        String url = appendApiKey(URL_FORECAST);
        Forecast forecast = mapper.readValue(new URL(url), Forecast.class);
        return forecast;

    }

    public Coordinates getGeoCoordinates() throws Exception {
        String url = appendApiKey(URL_CURRENT);
        WeatherForecast weatherForecast = mapper.readValue(new URL(url), WeatherForecast.class);
        Coordinates coordinates = new Coordinates();
        coordinates.lat = weatherForecast.getCoord().getLat();
        coordinates.lon = weatherForecast.getCoord().getLon();
        return coordinates;


    }

    private String appendApiKey(String url) {
        return url + "&appid=" + API_KEY;
    }

}
