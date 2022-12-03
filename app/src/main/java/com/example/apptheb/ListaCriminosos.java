package com.example.apptheb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

public class ListaCriminosos extends AppCompatActivity {

  // EditText inputText;
  DatabaseHelper myDb;
  TextView response;
  Button externalButton, internalButton;

  private String filename = "listaPersonagens.json";
  private String filepath = "personagens";
  File myExternalFile;
  String myData = "";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_lista_criminosos);
    myDb = new DatabaseHelper(this);

    // inputText = (EditText) findViewById(R.id.myInputText);
    response = (TextView) findViewById(R.id.response);

    externalButton = (Button) findViewById(R.id.saveExternalStorage);
    externalButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        try {
          FileOutputStream fos = new FileOutputStream(myExternalFile);

          ArrayList<Personagem> personagens = myDb.allPersonagens();
          if (personagens.size() == 0) {
            Toast.makeText(ListaCriminosos.this, "Nenhum Personagem cadastrado", Toast.LENGTH_SHORT).show();
            return;
          }

          JSONArray jLista = new JSONArray();

          for (Personagem p : personagens) {
            jLista.put(p.getJsonObject());
          }

          fos.write(jLista.toString().getBytes());
          fos.close();
          String res = (filename + "Arquivo exportado para divulgação");
          response.setText(res);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });

    internalButton = (Button) findViewById(R.id.getExternalStorage);
    internalButton.setOnClickListener(new OnClickListener() {

      @Override
      public void onClick(View v) {
        try {
          File f = getFileStreamPath("backup_personagens");
          FileOutputStream fos = new FileOutputStream(f);
          ArrayList<Personagem> personagens = myDb.allPersonagens();

          if (personagens.size() == 0) {
            Toast.makeText(ListaCriminosos.this, "Nenhum Personagem cadastrado", Toast.LENGTH_SHORT).show();
            return;
          }

          JSONArray jLista = new JSONArray();

          for (Personagem p : personagens) {
            jLista.put(p.getJsonObject());
          }

          fos.write(jLista.toString().getBytes());
          fos.close();
          String res = (filename + "Salvo internamente");
          response.setText(res);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

    });

    if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
      externalButton.setEnabled(false);
    } else {
      myExternalFile = new File(getExternalFilesDir(filepath), filename);
    }

  }

  private static boolean isExternalStorageReadOnly() {
    String extStorageState = Environment.getExternalStorageState();
    if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
      return true;
    }
    return false;
  }

  private static boolean isExternalStorageAvailable() {
    String extStorageState = Environment.getExternalStorageState();
    if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
      return true;
    }
    return false;
  }

}
