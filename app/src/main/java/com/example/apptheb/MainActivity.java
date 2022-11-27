package com.example.apptheb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.nav_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.filme_menu:
                        OpenTab(FilmeActivity.class);
                        return true;
                    case R.id.music:
                        OpenTab(MusicActivity.class);
                        return true;
                    case R.id.sinal:
                        OpenTab(SinalActivity.class);
                        return true;
                    case R.id.local:
                        OpenTab(Localizacao.class);
                        return true;
                    case R.id.mais:
                        OpenTab(MaisActivity.class);
                        return true;
                    default:
                        return false;
                }



            }
        });
    }

    public void OpenTab(Class tab){
        Intent intent = new Intent(this, tab);
        startActivity(intent);
    }
}




