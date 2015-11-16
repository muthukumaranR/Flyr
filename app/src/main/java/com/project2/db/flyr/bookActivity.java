package com.project2.db.flyr;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Deepak on 11/16/2015.
 */
public class bookActivity extends Activity {
    private int fare;
    private String id1,fname,origin,dest,fares;
    usersdbhelper udb = new usersdbhelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        id1 = getIntent().getStringExtra("id");
        Cursor cursor = udb.getFlightRow(id1);
        fname = cursor.getString(0);
        origin = cursor.getString(1);
        dest = cursor.getString(2);
        fare = cursor.getInt(3);
        fares = ""+fare+"";
        setContentView(R.layout.activity_booking);

        TextView fname_tv = (TextView)findViewById(R.id.textView18);
        TextView origin_tv = (TextView)findViewById(R.id.textView19);
        TextView dest_tv = (TextView)findViewById(R.id.textView20);
        TextView fare_tv = (TextView)findViewById(R.id.textView21);
        fname_tv.setText(fname);
        origin_tv.setText(origin);
        dest_tv.setText(dest);
        fare_tv.setText(fares);
    }
}
