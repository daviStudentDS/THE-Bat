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
                        OpenFilmeteste();
                        return true;
                    case R.id.music:
                        OpenMusic();
                        return true;
                    case R.id.sinal:
                        OpenSinal();
                        return true;
                    case R.id.local:
                        OpenLocalizacao();
                        return true;
                    case R.id.mais:
                        OpenMais();
                        return true;
                    default:
                        return false;
                }



            }
        });


    }
    public void OpenFilmeteste() {
        Intent intent = new Intent(this, FilmeActivity.class);
        startActivity(intent);
    }
    public void OpenMusic() {
        Intent intent = new Intent(this, MusicActivity.class);
        startActivity(intent);
    }
    public void OpenSinal() {
        Intent intent = new Intent(this, SinalActivity.class);
        startActivity(intent);
    }
    public void OpenLocalizacao() {
        Intent intent = new Intent(this, Localizacao.class);
        startActivity(intent);
    }
    public void OpenMais() {
        Intent intent = new Intent(this, MaisActivity.class);
        startActivity(intent);
    }
}




