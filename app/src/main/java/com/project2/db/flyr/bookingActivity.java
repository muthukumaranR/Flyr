package com.project2.db.flyr;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by karthick on 11/15/2015.
 */
public class bookingActivity extends Activity {
    private int pass;
    private String orig,dest,date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pass = Integer.parseInt(getIntent().getStringExtra("pass"));
        orig = getIntent().getStringExtra("orig");
        dest = getIntent().getStringExtra("dest");
        date = getIntent().getStringExtra("date");

    }
}
