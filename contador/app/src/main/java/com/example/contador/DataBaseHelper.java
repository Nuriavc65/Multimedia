package com.example.contador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "table.db";
    private static final int Database_version = 1;

    private static final String TABLE_NAME = "User_login";
    private static final String column_id = "_id";
    private static final String column_name = "person_name";
    private static final String column_password = "person_password";


    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME , null , Database_version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "create TABLE " + TABLE_NAME+
                        " (" + column_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        column_name + " TEXT, " +
                        column_password + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    void addUser(String user,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(column_name,user.toUpperCase());
        cv.put(column_password,password);
        long result = db.insert(TABLE_NAME,null,cv);
        if(result == -1){
            Toast.makeText(context,"El usuario ya existe",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Usuario añadido correctamente",Toast.LENGTH_SHORT).show();
        }
    }
    void updateUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(column_name, user.getUser().toUpperCase());
        db.update(TABLE_NAME, cv, column_name + " = "+user.getUser().toUpperCase(),null);
    }
    Cursor getUser (String user){
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + column_name + " = " + user.toUpperCase() + " ; ";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
