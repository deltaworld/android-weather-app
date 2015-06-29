package com.example.android.sunshine.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDataParser {

    /**
     * Given a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex
     * (Note: 0-indexed, so 0 would refer to the first day).
     */
    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
            throws JSONException {

        // Parse JSON String to JSON object
        JSONObject jsonWeather = new JSONObject(weatherJsonStr);

        // Get array with name=list to a JSONArray
        JSONArray jsonArray = jsonWeather.getJSONArray("list");

        //JSONObject of dayIndex
        JSONObject currentDay = jsonArray.getJSONObject(dayIndex);
        JSONObject temp = currentDay.getJSONObject("temp");


        System.out.println(temp.names().toString());
        System.out.println(temp.toString());

        return temp.getDouble("max");
    }

}
