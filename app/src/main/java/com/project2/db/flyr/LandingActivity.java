package com.project2.db.flyr;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by muthukumaran on 04/10/2015.
 */
public class LandingActivity extends Activity {
    int no_uniq;//unique bookings of the user,to inflate and populate the lists

    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        String username = getIntent().getStringExtra("username");
        TextView tv = (TextView)findViewById(R.id.textView);
        tv.setText(username);
        String username1 = getIntent().getStringExtra("username1");
        TextView tv2 = (TextView)findViewById(R.id.textView2);
        tv2.setText(username1);
        String password = getIntent().getStringExtra("password");
        TextView tv3 = (TextView)findViewById(R.id.textView3);
        tv3.setText(password);


    }

}
