/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee;


import ee.api.Forecast;
import ee.api.Weather;
import ee.api.WeatherForecast;
import org.junit.Assert;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class WeatherForecastServiceTest {
    private static WeatherForecast request;
    @Test
    public void getCurrentWeatherTest() throws Exception {
        WeatherForecastService service = new WeatherForecastService();
        WeatherForecast currentWeather = service.getCurrentWeather(request);
        Assert.assertNotNull(currentWeather);
    }

    @Test
    public void getForecastForThreeDays() throws Exception {
        WeatherForecastService service = new WeatherForecastService();
        Forecast forecast = service.getForecastForThreeDays(request);
        Assert.assertNotNull(forecast);
    }

    @Test
    public void getGeoCoordinates() throws Exception {
        WeatherForecastService service = new WeatherForecastService();
        Coordinates coordinates = service.getGeoCoordinates();
        Assert.assertNotNull(coordinates);
    }
    @Test
    public void testIfCurrentTemperatureIsNotCritical() throws Exception {
        WeatherForecastService getCurrentWeather = new WeatherForecastService();
        WeatherForecast response = getCurrentWeather.getCurrentWeather(request);
        assertTrue(response.getMain().getTemp() < 50 && response.getMain().getTemp() > -50);
    }

    @Test
    public void testIfWfefwtes() throws Exception {
        WeatherForecastService service = new WeatherForecastService();
        WeatherForecast response = service.getCurrentWeather(request);
        assertTrue(response.getName().toString().matches("Tallinn"));
    }
    @Test
    public void testIfWfefdwtes() throws Exception {
        WeatherForecastService service = new WeatherForecastService();
        Forecast response = service.getForecastForThreeDays(request);
        assertTrue(response.getCity().getCountry().toString().matches("EE"));
    }
}
