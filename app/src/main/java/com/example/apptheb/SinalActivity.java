package com.example.apptheb;



import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


public class SinalActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private Sensor gyroscopeSensor;
    private SensorEventListener gyroscopeEventListener;
    MediaPlayer player;
    private boolean isAtv = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinal);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        Log.v("musica", "Abrido");

        if (gyroscopeSensor == null) {
            Toast.makeText(this, "The device has no Gyroscope !", Toast.LENGTH_SHORT).show();
            finish();
        }

        gyroscopeEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if(sensorEvent.values[2] > 0.5f) {
                  getWindow().getDecorView().setBackgroundColor(Color.BLUE);


                } else if (sensorEvent.values[2] < -0.5f) {
                    getWindow().getDecorView().setBackgroundColor(Color.RED);

                }

                if(!isAtv){
                    play();
                }
                isAtv = true;



            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(gyroscopeEventListener, gyroscopeSensor, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(gyroscopeEventListener);
    }


    public void play() {

        // MediaPlayer player = null;
        if (player == null) {
            Log.v("musica", "Rodado");
            player = MediaPlayer.create(this, R.raw.musicaum);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    pararAudio();
                }
            });
        }

    }
    private void pararAudio(){
        if(player != null){
            player.release();
            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show();

        }
    }
}



