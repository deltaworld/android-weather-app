package com.example.android.sunshine.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {


            // Once the root view for the Fragment has been created, it's time to fill
            // the ListView with some dummy data.

            // Create some dummy data for the ListView, Here's a sample weekly
            // represented as "day, weather, high/low"

            String[] data = {
                    "Today - Sunny - 31/17",
                    "Tomorrow - Foggy - 21/8",
                    "Weds - Cloudy - 22/17",
                    "Thurs - Asteroids - 18/11",
                    "Fri - Heavy Rain - 21/10",
                    "Sat - HELP TRAPPED IN WEATHERSTATION - 23/18",
                    "Sun - Sunny - 20/7"
            };
            List<String> weekForecast = new ArrayList<>(Arrays.asList(data));
            // Initialise adapter

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                    getActivity(), R.layout.list_item_forecast, R.id.list_item_forecast_textview,
                    weekForecast);
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
}
