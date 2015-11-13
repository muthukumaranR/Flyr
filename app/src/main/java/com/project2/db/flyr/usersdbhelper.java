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
    public static final String DATABASE_NAME = "flyr.db";
    public static final String TABLE_NAME = "users";
    public static final String flight_TABLE_NAME = "flight";
    public static final String booking_TABLE_NAME = "bookings";//bid,date,uid,pid,f_id,,
    public static final String pass_TABLE_NAME = "passengers";//pid,bid,pname,seat,checkin;
    //public static final String _TABLE_NAME = "passengers";
    public static final String USERNAME = "uname";
    public static final String PASSWORD = "pass" ;

    public static final String ID = "id";
    SQLiteDatabase db;
    public static final String TABLE_CREATE = "create table users (id integer primary key not null , uname text not null,pass text not null);";
    public static final String flight_TABLE_CREATE ="create table flight (f_id primary key not null, fname text not null,maxseats integer not null,origin text,dest text,fare integer,Start integer,end integer);";
    public static final String port_TABLE_CREATE =" ";
    public static final String booking_TABLE_CREATE ="";
    public static final String admin_TABLE_CREATE ="create table admin (aid integer primary key not null ,pass text not null);";

    public usersdbhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        db.execSQL(flight_TABLE_CREATE);
       // db.execSQL(flight_TABLE_CREATE);
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
    public void insertFlight(flight f){
        db = this.getWritableDatabase();
        String qry = "select * from "+flight_TABLE_NAME;
        Cursor cr = db.rawQuery(qry,null);
        ContentValues cv = new ContentValues();

        cv.put("f_id",f.getFid());
        cv.put("fname",f.getFname());
        cv.put("origin",f.getOrigin());
        cv.put("dest", f.getDest());
        cv.put("maxseats", f.getMaxseats());
        cv.put("fare", f.getFare());
        cv.put("start",f.getStart());
        cv.put("end", f.getEnd());
        String a = f.getFid(),b;
        int update=0;
        if(cr.getCount() != 0 ) {
            cr.moveToFirst();
            do {
                b = cr.getString(0);
                if (a.equals(b)) {
                    String where = "f_id = '"+b+"'";
                    //update public int update (String table, ContentValues values, String whereClause, String[] whereArgs)
                   db.update(flight_TABLE_NAME, cv, where, null);

                    update = 1;
                }

            } while (cr.moveToNext());
        }
        //cr.close();
            if(cr.getCount()==0 || update != 1){
                db.insert(flight_TABLE_NAME, null, cv);

            }
        cr.close();
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
       // String query2  = "DROP TABLE IF EXISTS "+ flight_TABLE_NAME ;

    }
}
