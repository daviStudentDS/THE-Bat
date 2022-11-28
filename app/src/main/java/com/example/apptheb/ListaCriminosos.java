package com.example.apptheb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ListaCriminosos extends AppCompatActivity {
    private boolean mExternalStorageAvaible = false;
    private boolean mExternalStorageWriteable = false;

    public void gerarRelatorio(View v){

        String state = Environment.getExternalStorageState();


        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE
        ) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
        else {
            if(Environment.MEDIA_MOUNTED.equals(state)){
                mExternalStorageAvaible = mExternalStorageWriteable = true;

                try{
                    File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                    if(!dir.exists()){
                        boolean success = dir.mkdirs();

                        Toast.makeText(this, success ? "s1" : "f1", Toast.LENGTH_SHORT).show();
                    }
                    File subDir = new File(dir, "/personagens/");
                    if(!subDir.exists()){
                        boolean success = subDir.mkdirs();

                        // Toast.makeText(this, success ? "s2" : "f2", Toast.LENGTH_SHORT).show();
                    }
                    File arquivo = new File(dir, "teste.obj");

                    FileWriter fileWriter = new FileWriter(arquivo);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write("salve");
                    bufferedWriter.close();
                    Toast.makeText(this, arquivo.getAbsolutePath(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                /*
                try{
                    Personagem objeto = new Personagem("Muié do curinga", "Harley queen", "Batman bem antigo");
                    FileOutputStream fos = new FileOutputStream(arquivo);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(objeto);
                    oos.close();
                    fos.close();
                }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                 */
            }

            if((Environment.MEDIA_MOUNTED_READ_ONLY.equals(state))){
                mExternalStorageAvaible = true;
                mExternalStorageWriteable = false;
            }

            else{
                mExternalStorageAvaible = mExternalStorageWriteable = false;
            }
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_criminosos);


    }


}