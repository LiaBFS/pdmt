package com.example.bleblebleblublubl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sm;
    TextView textView;

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tvSensor);
        listView = findViewById(R.id.listView);

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        sm.registerListener(this , sensor, SensorManager.SENSOR_DELAY_NORMAL);

        List<Sensor> sensorList = sm.getSensorList(Sensor.TYPE_ALL); //lista de sensores
        ArrayList<String> listNameSensor = new ArrayList<>();
        for (Sensor s: sensorList){
            listNameSensor.add(s.getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listNameSensor);
        listView.setAdapter(adapter);

        //
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //


    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        event.sensor.getName();

        textView.setText((Float.toString(event.values[0])));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}