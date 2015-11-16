package com.project2.db.flyr;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by karthick on 11/15/2015.
 */
public class CheckinActivity extends Activity{
    private int pass;
    private String fid;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         pass = Integer.parseInt(getIntent().getStringExtra("pass"));
         fid  = getIntent().getStringExtra("fid");
        if (pass == 1) {
            setContentView(R.layout.checkin1);
        } else if (pass == 2) {
            setContentView(R.layout.checkin2);
        }
    }
        public void onclickpass1(View v) {
            usersdbhelper udb = new usersdbhelper(this);
            EditText pass1 = (EditText)findViewById(R.id.pass1seat);
            int p1 =Integer.parseInt( pass1.getText().toString());
            int check = udb.checkseats(p1,fid);
            if (check == 1){

            }
            if (check == -1){

            }if (check == -2){

            }
            if (check == 0){
                Toast.makeText(CheckinActivity.this, "invalid value of seat number", Toast.LENGTH_SHORT).show();
            }
        }


}
