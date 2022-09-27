package com.example.apptheb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MaisActivity extends AppCompatActivity {
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mais);
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
        intent.setClass( MaisActivity.this, MainActivity.class);
        startActivity(intent);
        finish();




    }
}



