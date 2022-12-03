package com.example.apptheb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "db_theBatman";
    public static final String PERSONAGENS_TABLE_NAME = "tb_personagens";
    public static final String PERSONAGENS_COLUMN_ID = "_id";
    public static final String PERSONAGENS_COLUMN_NAME = "nome";
    public static final String PERSONAGENS_COLUMN_ALTEREGO = "alterego";
    public static final String PERSONAGENS_COLUMN_QUADRINHO = "quadinho";
    public static final String PERSONAGENS_COLUMN_HEROI = "heroi";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery = String.format("create table %s ( %s integer primary key autoincrement, %s text, %s text, %s text, %s integer )",
                PERSONAGENS_TABLE_NAME,
                PERSONAGENS_COLUMN_ID,
                PERSONAGENS_COLUMN_NAME,
                PERSONAGENS_COLUMN_ALTEREGO,
                PERSONAGENS_COLUMN_QUADRINHO,
                PERSONAGENS_COLUMN_HEROI
        );

        db.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PERSONAGENS_TABLE_NAME);
        onCreate(db);
    }

    public boolean insertPersonagem(Personagem personagem){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(PERSONAGENS_COLUMN_NAME, personagem.getAlterEgo());
        contentValues.put(PERSONAGENS_COLUMN_ALTEREGO, personagem.getAlterEgo());
        contentValues.put(PERSONAGENS_COLUMN_QUADRINHO, personagem.getPrimeiroQuadrinho());
        contentValues.put(PERSONAGENS_COLUMN_HEROI, personagem.getHeroi());

        return db.insert(PERSONAGENS_TABLE_NAME, null, contentValues) > 0;
    }

    public ArrayList<Personagem> allPersonagens(){
        ArrayList<Personagem> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("SELECT * FROM " + PERSONAGENS_TABLE_NAME, null);
        res.moveToFirst();

        while(!res.isAfterLast()) {
            int i;
            Personagem p = new Personagem();

            i = res.getColumnIndex(PERSONAGENS_COLUMN_ID);
            p.setID(res.getInt(i));

            i = res.getColumnIndex(PERSONAGENS_COLUMN_NAME);
            p.setNome(res.getString(i));

            i = res.getColumnIndex(PERSONAGENS_COLUMN_ALTEREGO);
            p.setAlterEgo(res.getString(i));

            i = res.getColumnIndex(PERSONAGENS_COLUMN_QUADRINHO);
            p.setPrimeiroQuadrinho(res.getString(i));

            i = res.getColumnIndex(PERSONAGENS_COLUMN_HEROI);
            p.setHeroi(res.getInt(i) == 1);

            arrayList.add(p);
            res.moveToNext();
        }
        res.close();
        return arrayList;
    }
}
