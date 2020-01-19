package com.example.myloginapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Student.db";
    private static final String TABLE_NAME = "student_details";
    private static final String ID = "_id";
    private static final String EMAIL = "Email";
    private static final String NAME = "Name";
    private static final String PHONE_NUMBER = "Phone_Number";
    private static final String PASSWORD = "password";
    private static final int VERSION_NUMBER = 2 ;
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(25), "+EMAIL+" VARCHAR(50), "+PHONE_NUMBER+" VARCHAR(15));";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;
    private Context context;
    public MyDatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            Toast.makeText(context,"OnCReate is called",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.execSQL(CREATE_TABLE);
        } catch ( Exception e) {
            Toast.makeText(context,"Exception : "+e,Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        try {
            Toast.makeText(context,"OnUpGrade is Called",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);
        }  catch (Exception e) {
            Toast.makeText(context,"Exception: "+e,Toast.LENGTH_SHORT).show();
        }
    }

    public long insertdata(String name, String email , String phoneno,String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(EMAIL,email);
        contentValues.put(PHONE_NUMBER,phoneno);
        contentValues.put(PASSWORD,password);
        long rowid = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowid ;
    }
