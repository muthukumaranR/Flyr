package com.project2.db.flyr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by karthick on 06/10/2015.
 */
public class usersdbhelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "flyr.db";
    public static final String TABLE_NAME = "users";
    public static final String flight_TABLE_NAME = "flight";
    public static final String booking_TABLE_NAME = "bookings";//bid,date,uid,pid,f_id,,
    public static final String pass_TABLE_NAME = "passenger";//pid,bid,pname,seat,checkin;
    public static final String seats_TABLE_NAME="seats";
    //public static final String _TABLE_NAME = "passengers";
    public static final String USERNAME = "uname";
    public static final String PASSWORD = "pass" ;

    public static final String ID = "id";
    public static final String TABLE_CREATE = "create table users (id integer primary key not null , uname text not null,pass text not null);";
    public static final String flight_TABLE_CREATE ="create table flight (f_id text primary key not null, fname text not null,maxseats integer not null,origin text,dest text,fare integer,Start integer,end integer);";
    public static final String port_TABLE_CREATE =" ";
    public static final String bookings_TABLE_CREATE = "create table bookings(b_id integer not null,f_id text not null,u_id integer not null,p_id integer not null,bookedDate date not null);";
    public static final String admin_TABLE_CREATE ="create table admin (aid integer primary key not null ,pass text not null);";
    public static final String passenger_TABLE_CREATE ="create table passenger(p_id integer primary key not null ,pname text not null, b_id integer,seatno integer);";
    public static final String seats_TABLE_CREATE="create table seats(f_id text not null,fdate date, remseats integer);";

    SQLiteDatabase db;

    public usersdbhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        db.execSQL(flight_TABLE_CREATE);
        db.execSQL(bookings_TABLE_CREATE);
        db.execSQL(passenger_TABLE_CREATE);
        db.execSQL(seats_TABLE_CREATE);
        this.db = db;
    }

    public void insertUser(users u){
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        //pid,pname,bid,seats
        String qry = "select * from "+TABLE_NAME;
        Cursor cr  =  db.rawQuery(qry,null);
        int count = cr.getCount();
        cv.put(ID, count);
        cv.put(USERNAME, u.getusername());
        cv.put(PASSWORD, u.getpassword());
        db.insert(TABLE_NAME, null, cv);
        db.close();
    }

    public void insertPassenger(passenger p, bookings b){

        /*Date fdate = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fdate =  format.parse(b.getD());
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        ContentValues cv1 = new ContentValues();
        String qry = "select * from "+pass_TABLE_NAME;
        Cursor cr  =  db.rawQuery(qry,null);
        //cr.moveToFirst();
        int count = cr.getCount();
        cv.put("p_id",count);
        cv.put("pname",p.getPname());
        cv.put("b_id",p.getBid());
        cv.put("seatno", p.getSeatno());
        db.insert(pass_TABLE_NAME, null, cv);
        cv1.put("b_id", b.getBid());
        cv1.put("f_id", b.getFid());
        cv1.put("u_id", b.getUid()); //to change it to UID
        cv1.put("p_id", count);
        cv1.put("bookedDate", b.getD());
        db.insert(booking_TABLE_NAME, null, cv1);
        cr.close();
        db.close();
    }

    public int getMaxBookId()
    {
        int bid =0;
        db = this.getReadableDatabase();
        String qry ="select max(b_id) from "+booking_TABLE_NAME;
        Cursor cr  =  db.rawQuery(qry,null);
        if(cr.moveToFirst()) {
            bid = cr.getInt(0);
        }
        db.close();
        return bid;
    }

    public int getUserId(String username)
    {
        db = this.getReadableDatabase();
        String qry= "select id from "+TABLE_NAME +" where uname ='"+username+"'" ;
        Cursor cr=db.rawQuery(qry,null);
        cr.moveToFirst();
        return Integer.parseInt(cr.getString(0));
    }

    public void insertBooking(bookings b) {
        String qry = "select * from " + booking_TABLE_NAME;
        db = this.getWritableDatabase();
        String s = "'" + b.getD().toString() + "'";
        Cursor cr = db.rawQuery(qry, null);
        ContentValues cv = new ContentValues();
        cv.put("b_id", b.getBid());
        cv.put("f_id", b.getFid());
        cv.put("u_id", b.getUid());
        cv.put("p_id", b.getPid());
        cv.put("bookedDate", s);
        db.insert(booking_TABLE_NAME, null, cv);
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

    public ArrayList searchFlights(String start,String end){
    ArrayList fid= new ArrayList();
        db = this.getReadableDatabase();
        String qry = "select * from "+flight_TABLE_CREATE;
        //do search in db and store in arraylist
        return fid;
    }
    public int checkseats(int p1,String fid){
    String cQuery = "select * from flight as f,bookings as b where f.f_id = b.f_id and f_fid ='"+fid+"'";
        Cursor cr = db.rawQuery(cQuery,null);
        if(cr.moveToFirst()){

        }

    return 0;
    }
   /* public int checkseats(int p1,int p2,String fid){

    }*/

    //To insert seats in the table for the specific date
    // To do check if the booking is done for same date, if same date is given do not insert
    public void insertSeatsTable(String date)
    {
        db = this.getReadableDatabase();
        String fid;
        int maxseats;
        Date fdate = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fdate =  format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
       String s = " select count(*) from seats where fdate ='"+fdate+"'";
        int count;
        Cursor cr = db.rawQuery(s,null);
        cr.moveToFirst();
        count = cr.getInt(0);
        if(count == 0 ) {
            String query = "select f_id,maxseats from " + flight_TABLE_NAME;
            Cursor c = db.rawQuery(query, null);
            if (c.moveToFirst()) {
                do {
                    fid = c.getString(0);
                    maxseats = c.getInt(1);
                    db.execSQL("insert into " + seats_TABLE_NAME + " values ('" + fid + "','" + fdate + "'," + maxseats + ")");
                } while (c.moveToNext());
            }
        }
        cr.close();
        db.close();
    }

    public Cursor getRequiredFlight(String origin, String dest) {
        db = this.getReadableDatabase();
        String query = "select f_id as _id,fname,origin,dest,fare from "+flight_TABLE_NAME+" where origin='"+origin+"' and dest='"+dest+"'";
        Cursor c = 	db.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public Cursor getFlightHistory(int id) {
        db = this.getReadableDatabase();
        String query = "select b.b_id as _id,f.fname,f.origin,f.dest,b.bookedDate from "+flight_TABLE_NAME+" f,"+booking_TABLE_NAME+" b where f.f_id=b.f_id and b.u_id="+id;
        Cursor c = 	db.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }


    // Get a specific row (by rowId)
    public Cursor getFlightRow(String id) {
        db = this.getReadableDatabase();
        String query = "select fname,origin,dest,fare from "+flight_TABLE_NAME+" where f_id='"+id+"'";
        Cursor c = 	db.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query  = "DROP TABLE IF EXISTS "+ TABLE_NAME;
       // String query2  = "DROP TABLE IF EXISTS "+ flight_TABLE_NAME ;

    }
}
