package com.project2.db.flyr;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Deepak on 11/17/2015.
 */
public class ChooseOption extends Activity{
    private int bid,uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel);
        bid = Integer.parseInt(getIntent().getStringExtra("bid"));
        uid = Integer.parseInt(getIntent().getStringExtra("uid"));
    }

    public void onClickCancel(View v) {

        //Code for Cancel
        //Didnt Implement Because I couldnt able to retrieve the P_id for the B_id.
        //Since same B_id has many P_id
    }
    public void onClickCheckin(View v) {

        //Code For Checkin
    }
}
