package com.example.buddh.sensors;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity {
    Button b_read;
    TextView tv_text;
    private Button ambientBtn, lightBtn, pressureBtn, humidityBtn;
    private TextView ambientValue, lightValue, pressureValue, humidityValue;
    private TextView[] valueFields = new TextView[4];
    private final int AMBIENT=0;
    private final int LIGHT=1;
    private final int PRESSURE=2;
    private final int HUMIDITY=3;
    private SensorManager senseManage;
    private Sensor envSense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_read = (Button)findViewById(R.id.button);
        lightBtn = (Button)findViewById(R.id.button2);
        pressureBtn = (Button)findViewById(R.id.button3);
        humidityBtn = (Button)findViewById(R.id.button4);
        ambientBtn.setOnClickListener(this);
        lightBtn.setOnClickListener(this);
        pressureBtn.setOnClickListener(this);
        humidityBtn.setOnClickListener(this);
        ambientValue = (TextView)findViewById(R.id.textView);
        valueFields[AMBIENT]=ambientValue;
        lightValue = (TextView)findViewById(R.id.textView2);
        valueFields[LIGHT]=lightValue;
        pressureValue = (TextView)findViewById(R.id.textView3);
        valueFields[PRESSURE]=pressureValue;
        humidityValue = (TextView)findViewById(R.id.textView3);
        valueFields[HUMIDITY]=humidityValue;
        senseManage = (SensorManager) getSystemService(Context.SENSOR_SERVICE);


        Button button = (Button) findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMain3Activity();
            }
        });
    }
    public void onClick(View v)
    {
        if (v.getId()==R.id.button)
        {
            envSense = senseManage.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
//ambient temperature
            if(envSense==null)
                Toast.makeText(this.getApplicationContext(),
                        "Sorry - your device doesn't have an ambient temperature sensor!",
                        Toast.LENGTH_SHORT).show();
            else
                senseManage.registerListener(this, envSense, SensorManager.SENSOR_DELAY_NORMAL);

        }
        else if(v.getId()==R.id.button2)
        {
            envSense = senseManage.getDefaultSensor(Sensor.TYPE_LIGHT);
            if(envSense==null)
                Toast.makeText(this.getApplicationContext(),
                        "Sorry - your device doesn't have a light sensor!",
                        Toast.LENGTH_SHORT).show();
            else
                senseManage.registerListener(this, envSense, SensorManager.SENSOR_DELAY_NORMAL);
//light

        }
        else if(v.getId()==R.id.button3)
        {
            envSense = senseManage.getDefaultSensor(Sensor.TYPE_PRESSURE);
            if(envSense==null)
                Toast.makeText(this.getApplicationContext(),
                        "Sorry - your device doesn't have a pressure sensor!",
                        Toast.LENGTH_SHORT).show();
            else
                senseManage.registerListener(this, envSense, SensorManager.SENSOR_DELAY_NORMAL);
//pressure

        }
        else if(v.getId()==R.id.button4)
        {
            envSense = senseManage.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
            if(envSense==null)
                Toast.makeText(this.getApplicationContext(),
                        "Sorry - your device doesn't have a humidity sensor!",
                        Toast.LENGTH_SHORT).show();
            else
                senseManage.registerListener(this, envSense, SensorManager.SENSOR_DELAY_NORMAL);
//humidity

        }
    }
    private void goToMain3Activity() {
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }
    
}
