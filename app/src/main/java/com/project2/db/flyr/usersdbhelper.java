package com.project2.db.flyr;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by karthick on 06/10/2015.
 */
public class usersdbhelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "users.db";
    public static final String TABLE_NAME = "users";
    public static final String USERNAME = "airline.db";
    public static final String PASSWORD = "airline.db";
    SQLiteDatabase db;
    //public static final String DATABASE_NAME = "airline.db";
    public static final String TABLE_CREATE = "create table users (id integer primary key not null auto_increment, " + USERNAME +"text not null,pass text not null);";

    public usersdbhelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query  = "DROP TABLE IF EXISTS "+ TABLE_NAME;

    }
}
