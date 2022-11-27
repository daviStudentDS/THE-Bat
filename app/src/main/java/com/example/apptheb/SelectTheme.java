package com.example.apptheb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class SelectTheme extends AppCompatActivity {

    public static final String PREFERENCES_NAME = "com.example.android.apptheb";
    private boolean ligado = false;
    public void switchTheme(View v){
        Switch swt_theme = findViewById(R.id.swt_theme);

        boolean isOn = swt_theme.isChecked();

        SharedPreferences settings = getSharedPreferences(PREFERENCES_NAME, 0);

        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("theme", isOn);
        editor.commit();
        updateTheme(null);

    }

    public void updateTheme(View v){
        Switch swtTheme = findViewById(R.id.swt_theme);
        ImageView img = findViewById(R.id.imgTheme);
        SharedPreferences settings = getSharedPreferences(PREFERENCES_NAME, 0);

        ligado = settings.getBoolean("theme", false);
        img.setImageResource(ligado ? R.drawable.batman_logo_outline : R.drawable.night_wing_logo_outline);
        swtTheme.setChecked(ligado);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_theme);
        updateTheme(null);
    }
}