package com.example.apptheb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MusicActivity extends AppCompatActivity {
    MediaPlayer player;
     Button btnVoltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);


        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                TelaAnterior();

            }


        });
    }

    void TelaAnterior(){
        Intent intent= new Intent();
        intent.setClass( MusicActivity.this, MainActivity.class);
        startActivity(intent);
        finish();




    }
    public void play(View v) {
        if(player == null) {
            player = MediaPlayer.create(this, R.raw.musicaum);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                  PararAudio();
                }
            });
        }
        player.start();
    }
    public void pause(View v){
        if(player != null){
            player.pause();
        }
    }
    public void parar(View v){
        PararAudio();

    }
    private void PararAudio(){
        if(player != null){
            player.release();
            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show();

        }
    }
    @Override
    protected void onStop(){
        super.onStop();
        PararAudio();
    }
    public void GetUrlFromIntent(View view) {
        String url = "https://youtu.be/4VxdufqB9zg";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

}


