package com.project2.db.flyr;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Deepak on 11/17/2015.
 */
public class ChooseOption extends Activity{
    usersdbhelper udb = new usersdbhelper(this);
    private int bid, uid, nopass, fid;
    private String fname,origin,dest,bookedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel);
        bid = Integer.parseInt(getIntent().getStringExtra("bid"));
        uid = Integer.parseInt(getIntent().getStringExtra("uid"));

        Cursor cursor = udb.getBookingRow(uid,bid);
        fname = cursor.getString(1);
        origin = cursor.getString(2);
        dest = cursor.getString(3);
        bookedDate = cursor.getString(4);
        nopass=Integer.parseInt(cursor.getString(5));

        setContentView(R.layout.activity_cancel);
        String pass = ""+nopass+"";

        TextView fname_tv = (TextView)findViewById(R.id.flight_name3);
        TextView origin_tv = (TextView)findViewById(R.id.flight_origin3);
        TextView dest_tv = (TextView)findViewById(R.id.flight_dest3);
        TextView boookedDate_tv = (TextView)findViewById(R.id.flight_date3);
        TextView nopass_tv = (TextView)findViewById(R.id.nopass3);
        fname_tv.setText(fname);
        origin_tv.setText(origin);
        dest_tv.setText(dest);
        boookedDate_tv.setText(bookedDate);
        nopass_tv.setText(pass);

    }

    public void onClickCancel(View v) {
        fid = udb.getFlightId(bid);
        udb.bookCancelTicket(fid,bookedDate,nopass,bid,"cancel");
        Toast.makeText(getApplicationContext(),
                "Ticket Cancelled Successfully", Toast.LENGTH_LONG).show();
        Intent i =new Intent(ChooseOption.this, MainActivity.class);
        i.putExtra("username", udb.getUname(uid));
        startActivity(i);
    }

    public void onClickCheckin(View v) {
        Intent i = new Intent(ChooseOption.this,CheckinActivity.class);
        i.putExtra("bid",bid);
        i.putExtra("no_pass",nopass);
        i.putExtra("uid",uid);
        i.putExtra("username", udb.getUname(uid));
        startActivity(i);
    }
}
