package edu.css.unit11_weather_async;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author Abigailsova
 * @version 1.0
 * @since 1.0
 * Main Activity extends AppCompatActivity
 */

public class MainActivity extends AppCompatActivity {
    EditText etLoc;
    EditText etTemp;
    EditText etWind;
    EditText etVis;

    AsyncDownloadXML AsyncWeatherDownloader = new AsyncDownloadXML();
    /**
     * When the app is opened this method is called
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set up our edit text variables
        etLoc =  (EditText) findViewById(R.id.textLoc);
        etTemp =  (EditText) findViewById(R.id.textTemp);
        etWind =  (EditText) findViewById(R.id.textWind);
        etVis =  (EditText) findViewById(R.id.textVis);
    }
    /**
     * When get weather button is clicked method is called
     * @param v
     * @throws XmlPullParserException, URISyntaxException, IOException
     */
    public void btnClick (View v) throws XmlPullParserException, URISyntaxException, IOException {
        // Download the weather asynchronously
        AsyncWeatherDownloader.execute(this);
    }
    /**
     * Set Temp
     * Set the numeric value of the temperature in the designated spot
     * @param newTemp
     */
    public void setTemp(String newTemp) {
        etTemp.setText(newTemp);
    }
    /**
     * Set Wind
     * Set the numeric value of the wind in mph
     * @param newWind
     */
    public void setWind(String newWind) {
        etWind.setText(newWind);
    }
    /**
     * get Location from User input
     * Retrieve the user's location based on their input
     * @return String
     */
    public String getLocation() {
        return etLoc.getText().toString();
    }

    /**
     * Set Status
     * @param newStatus
     */
    public void setStatus(String newStatus) {
        Toast toast=Toast.makeText(getApplicationContext(), newStatus,Toast.LENGTH_LONG );
        toast.show();
    }

}
