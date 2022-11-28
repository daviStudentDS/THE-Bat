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

    public void gotoThemeSelect(View v){
        openTab(SelectTheme.class);
    }

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
                        openTab(ListaCriminosos.class);
                        // openTab(FilmeActivity.class);
                        return true;
                    case R.id.music:
                        openTab(MusicActivity.class);
                        return true;
                    case R.id.sinal:
                        openTab(SinalActivity.class);
                        return true;
                    case R.id.local:
                        openTab(Localizacao.class);
                        return true;
                    case R.id.mais:
                        openTab(MaisActivity.class);
                        return true;
                    default:
                        return false;
                }



            }
        });
    }

    public void openTab(Class tab){
        Intent intent = new Intent(this, tab);
        startActivity(intent);
    }
}




