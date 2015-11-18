package com.project2.db.flyr;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Deepak on 11/16/2015.
 */
public class bookActivity extends Activity {
    public int bookId = 0;
    usersdbhelper udb = new usersdbhelper(this);
    String passname1, passname2;
    private int fare;
    private String passw;
    private String id1,fname,origin,dest,fares,date,uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id1 = getIntent().getStringExtra("id");
        passw = getIntent().getStringExtra("pass");
        date = getIntent().getStringExtra("date");
        uid = getIntent().getStringExtra("uid");
        if(passw.equals("1")) {
            passname1 =  getIntent().getStringExtra("pass1");
        }
        else
        {
            passname1 =  getIntent().getStringExtra("pass1");
            passname2 = getIntent().getStringExtra("pass2");
        }
        Cursor cursor = udb.getFlightRow(id1);
        fname = cursor.getString(0);
        origin = cursor.getString(1);
        dest = cursor.getString(2);
        fare = cursor.getInt(3);
        fares = "" + fare + "";
        setContentView(R.layout.activity_booking);

        TextView fname_tv = (TextView) findViewById(R.id.textView18);
        TextView origin_tv = (TextView) findViewById(R.id.textView19);
        TextView dest_tv = (TextView) findViewById(R.id.textView20);
        TextView fare_tv = (TextView) findViewById(R.id.textView21);
        TextView seats_tv = (TextView) findViewById(R.id.availseats);
        TextView date_tv= (TextView) findViewById(R.id.bookingdate);
        fname_tv.setText(fname);
        origin_tv.setText(origin);
        dest_tv.setText(dest);
        fare_tv.setText(fares);
        int seats = udb.getSeats(id1,date);
        String no_seats = ""+seats+"";
        seats_tv.setText(no_seats);
        date_tv.setText(date);
    }

    public void onBookingButtonClick(View v) {
        //To do: Want to take date
        if(passw.equals("1"))
        {
            int bid=udb.getMaxBookId();
            passenger p = new passenger();
            bookings b =new bookings();
            p.setPname(passname1);
            p.setSeatno(0);
            p.setBid(bid + 1);
            b.setFid(id1);
            b.setD(date);
            b.setBid(bid + 1);
            b.setUid(Integer.parseInt(uid));
            udb.insertPassenger(p, b);
            int fid= udb.getFlightId(bid+1);
            String fids=""+fid+"";
            if(!udb.seatsAvailable(fids,b.getD(),1)) {
                udb.bookCancelTicket(fid, b.getD(), 1, 0, "book");
                Toast.makeText(getApplicationContext(),
                        "Ticket Booked Successfully", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),
                        "Seats not avaliable", Toast.LENGTH_LONG).show();
            }
        }
        else {
            int bid=udb.getMaxBookId();
            passenger p = new passenger();
            bookings b =new bookings();
            p.setSeatno(0);
            p.setBid(bid + 1);
            p.setPname(passname1);
            b.setFid(id1);
            b.setD(date);
            b.setBid(bid + 1);
            b.setUid(Integer.parseInt(uid));
            udb.insertPassenger(p, b);

            passenger p2 = new passenger();
            p2.setBid(bid+1);
            p2.setPname(passname2);
            b.setFid(id1);
            b.setD(date);
            b.setBid(bid + 1);
            b.setUid(Integer.parseInt(uid));
            udb.insertPassenger(p2, b);
            int fid= udb.getFlightId(bid+1);
            String fids=""+fid+"";
            if(!udb.seatsAvailable(fids,b.getD(),2)) {
                udb.bookCancelTicket(fid, b.getD(), 2, 0, "book");
                Toast.makeText(getApplicationContext(),
                        "Ticket Booked Successfully", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),
                        "Seats not avaliable", Toast.LENGTH_LONG).show();
            }
        }
        Intent i = new Intent(bookActivity.this,MainActivity.class);
        i.putExtra("username", udb.getUname(Integer.parseInt(uid)));
        startActivity(i);


        }
}
