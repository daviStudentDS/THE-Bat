package com.example.apptheb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class addPersonagem extends AppCompatActivity {
    private DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_personagem);
    }

    public void savePersonagem(View v){
        Personagem p = new Personagem();

        TextView txtNome = findViewById(R.id.txtNome);
        TextView txtAlterEgo = findViewById(R.id.txtAlterEgo);
        TextView txtQuadinho = findViewById(R.id.txtQuadrinho);
        Switch swtHeroi = findViewById(R.id.swtHeroi);

        p.setNome(txtNome.getText().toString());
        p.setAlterEgo(txtAlterEgo.getText().toString());
        p.setPrimeiroQuadrinho(txtQuadinho.getText().toString());
        p.setHeroi(swtHeroi.isChecked());

        myDb.insertPersonagem(p);
    }
}