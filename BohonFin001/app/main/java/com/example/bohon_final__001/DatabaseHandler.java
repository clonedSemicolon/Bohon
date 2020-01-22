package com.example.bohon_final__001;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;


public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "User.db";
    private static final String TABLE_NAME = "user";

    private static final  int VERSION_NUMBER = 400 ;
    private Context context;
    public DatabaseHandler(@Nullable Context context ) {
        super(context,DATABASE_NAME , null , VERSION_NUMBER);
        this.context = context ;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +TABLE_NAME +"(email VARCHAR(25) PRIMARY KEY , password VARCHAR(20),phone VARCHAR(20),name VARCHAR(20) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insert(String email,String name,String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("name",name);
        contentValues.put("phone",phone);
        long ins = db.insert("user",null,contentValues);
        if ( ins == -1) return false ;
        else return true ;
    }
    public boolean chkemail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email=?",new String[]{email});
        if (cursor.getCount() > 0) return false ;
        else return true ;
    }

}