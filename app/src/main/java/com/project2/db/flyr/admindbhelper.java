package com.project2.db.flyr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static android.database.sqlite.SQLiteOpenHelper.*;
/**
 * Created by karthick on 11/10/2015.
 */
public class admindbhelper extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "flyr1.db";
    public static final String TABLE_NAME = "admin";
    public static final String flight_TABLE_NAME = "flights";
    public static final String AID = "aid";
    public static final String PASSWORD = "pass" ;
    SQLiteDatabase db;
    public static final String flight_TABLE_CREATE ="create table flight(f_id primary key not null, maxseats integer not null,origin text,dest text,eco_fare,biz_fare,0);";
    public static final String port_TABLE_CREATE =" ";
    public static final String booking_TABLE_CREATE ="";
    public static final String TABLE_CREATE ="create table admin (aname text primary key not null ,pass text not null);";
    public admindbhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        String admin1 = "insert into admin values ('admin','admin');";
         db.execSQL(admin1);
        //db.execSQL(flight_TABLE_CREATE);
        this.db = db;
    }
    public String passretreive(String adminId){
        db = this.getReadableDatabase();
       //String admin1
        String qry = "select * from "+TABLE_NAME;
        Cursor cr = db.rawQuery(qry,null);
        String a,b=null;
        if(cr.moveToFirst()){
            // cr.moveToFirst();
            do{
                a = cr.getString(0);
                if (a.equals(adminId)) {
                    b = cr.getString(1);
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
        //String query2  = "DROP TABLE IF EXISTS "+ flight_TABLE_NAME ;

    }
}


