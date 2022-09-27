package com.example.apptheb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;


import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FilmeActivity extends AppCompatActivity {
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme);

        VideoView videoView = findViewById(R.id.trailer_view);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.trailervideo;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                TelaAnterior();

            }


        });
    }

    void TelaAnterior() {
        Intent intent = new Intent();
        intent.setClass(FilmeActivity.this, MainActivity.class);
        startActivity(intent);
        finish();


    }




    }
