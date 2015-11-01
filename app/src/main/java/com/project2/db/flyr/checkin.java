package com.project2.db.flyr;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;

/**
 * Created by karthick on 06/10/2015.
 */
public class checkin extends Activity{
    int maxseats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    CheckBox[] cb = new CheckBox[maxseats];
}
