package com.example.contador;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "table.db";
    private static final int Database_version = 1;

    private static final String TABLE_NAME = "my_table";
    private static final String column_id = "_id";
    private static final String column_name = "person_name";
    private static final String column_password = "person_password";


    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME , null , Database_version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table" + TABLE_NAME+
                        " (" + column_id + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        column_name + "TEXT," +
                        column_password + "TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists" + TABLE_NAME);
    }
}
