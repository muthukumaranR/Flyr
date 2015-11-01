package com.project2.db.flyr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.database.sqlite.SQLiteOpenHelper.*;

/**
 * Created by karthick on 06/10/2015.
 */
public class usersdbhelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "users.db";
    public static final String TABLE_NAME = "users";
    public static final String USERNAME = "uname";
    public static final String PASSWORD = "pass" ;
    public static final String ID = "id";
    SQLiteDatabase db;
    //public static final String DATABASE_NAME = "airline.db";
    public static final String TABLE_CREATE = "create table users (id integer primary key not null , uname text not null,pass text not null);";
    public static final String flight_TABLE_CREATE ="create table flight(f_id primary key not null, maxseats integer not null,origin text,dest text,eco_fare,biz_fare,0);";
    public static final String port_TABLE_CREATE ="";
    public static final String booking_TABLE_CREATE ="";

    public usersdbhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    this.db = db;
    }
    public void insertUser(users u){
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();


        String qry = "select * from "+TABLE_NAME;
        Cursor cr  =  db.rawQuery(qry,null);
        int count = cr.getCount();
        cv.put(ID,count);
        cv.put(USERNAME,u.getusername());
        cv.put(PASSWORD, u.getpassword());
        db.insert(TABLE_NAME, null, cv);
        db.close();
    }

    public String userpass(String username){
        db = this.getReadableDatabase();
        String qry = "select * from "+TABLE_NAME;
        Cursor cr = db.rawQuery(qry,null);
        String a,b=null;
        if(cr.moveToFirst()){
           // cr.moveToFirst();
            do{
                a = cr.getString(1);
               if (a.equals(username)) {
                   b = cr.getString(2);
               return b;
               }
            }while(cr.moveToNext());


        }
        db.close();
    return null;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query  = "DROP TABLE IF EXISTS "+ TABLE_NAME;

    }
}
