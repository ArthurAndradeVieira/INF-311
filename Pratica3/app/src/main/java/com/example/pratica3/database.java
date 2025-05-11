package com.example.pratica3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database extends SQLiteOpenHelper {

    public static final String DB_NAME = "localizacao.db";
    public static final int DB_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Location (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "descricao TEXT," +
                "latitude REAL," +
                "longitude REAL)");

        db.execSQL("CREATE TABLE Logs (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "msg TEXT," +
                "timestamp TEXT," +
                "id_location INTEGER," +
                "FOREIGN KEY(id_location) REFERENCES Location(id))");

        db.execSQL("INSERT INTO Location (descricao, latitude, longitude) VALUES " +
                "('DPI UFV', -20.764872, -42.868450)," +
                "('Ipatinga', -19.514523, -42.561509)," +
                "('Viçosa', -20.751433, -42.881804)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Logs");
        db.execSQL("DROP TABLE IF EXISTS Location");
        onCreate(db);
    }
}