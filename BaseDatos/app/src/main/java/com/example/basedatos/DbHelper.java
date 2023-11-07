package com.example.basedatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;



public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=2;
    private static final String DATABASE_NAME="ejemplo.db";
    private static final String TABLE_PRODUCTOS="Productos";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + TABLE_PRODUCTOS +"("+
                "id INTEGER PRIMARY KEY," +
                "Nombre TEXT," +
                "Descripcion TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE Productos");
        onCreate(db);
    }
}
