package com.example.contador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    private final Context context;
    private static final String DATABASE_NAME = "table.db";
    private static final int Database_version = 1;

    private static final String TABLE_NAME = "User_login";
    private static final String column_id = "_id";
    private static final String column_name = "person_name";
    private static final String column_password = "person_password";
    private static final String column_precioAutoClick = "game_precioAutoClick";
    private static final String column_valorAutoClick = "game_valorAutoClick";
    private static final String column_precioClick = "game_precioClick";
    private static final String column_valorClick = "game_valorClick";
    private static final String column_valorLuna = "game_valorLuna";


    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, Database_version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + column_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + column_name + " TEXT, " + column_precioAutoClick + " TEXT, " + column_valorAutoClick + " INT, " + column_precioClick + " TEXT, " + column_valorClick + " INT, " + column_valorLuna + " INT, " + column_password + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }

    void addUser(String user, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(column_name, user.toUpperCase());
        cv.put(column_password, password);
        cv.put(column_precioAutoClick, "100");
        cv.put(column_valorAutoClick, 1);
        cv.put(column_precioClick, "100");
        cv.put(column_valorClick, 1);
        cv.put(column_valorLuna, 1);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "El usuario ya existe", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Usuario añadido correctamente", Toast.LENGTH_SHORT).show();
        }
    }

    void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(column_name, user.getUser().toUpperCase());
        cv.put(column_precioAutoClick, user.getPrecioAutoClick());
        cv.put(column_valorAutoClick, user.getPrecioClick());
        cv.put(column_precioClick, user.getAutoClick());
        cv.put(column_valorClick, user.getClick());
        cv.put(column_valorLuna, user.getClicker());
        db.update(TABLE_NAME, cv, column_name + " = ?", new String[]{user.getUser().toUpperCase()});
    }

    Cursor getUser(String user) {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + column_name + " = '" + user.toUpperCase() + "' ; ";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
