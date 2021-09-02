package com.example.businessapp2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "User.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(email text primary key,username text,password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists user ");
    }
    public boolean insert(String email,String username,String password){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = database.insert("user", null, contentValues);
        return result != -1;
    }
    public boolean checkemail (String email){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM user WHERE email=? ",new String[]{email});
        return cursor.getCount() <= 0;
    }
    public boolean checkemailpassword (String email,String password){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM user WHERE email=? AND password=?",new String[]{email,password});
        return cursor.getCount() > 0;
    }

    public Cursor getdata(){
        String query = "SELECT username FROM user";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = null;
        if (sqLiteDatabase != null){
            cursor = sqLiteDatabase.rawQuery(query, null);
        }
        return cursor;
    }
}