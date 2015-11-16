package com.project2.db.flyr;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by karthick on 11/15/2015.
 */
public class bookActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //if pass = 1
        setContentView(R.layout.passenger1);
        //if pass = 2
        setContentView(R.layout.passenger2);
    }
}
