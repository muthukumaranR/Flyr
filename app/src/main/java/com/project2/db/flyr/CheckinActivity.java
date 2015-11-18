package com.project2.db.flyr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Date;

/**
 * Created by karthick on 11/15/2015.
 */
public class CheckinActivity extends Activity{
    private int pass,bid,uid;
    private String bid_str;

    private Date d;
    usersdbhelper udb = new usersdbhelper(this);
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         //pass = Integer.parseInt(getIntent().getStringExtra("pass"));
         bid  = getIntent().getIntExtra("bid",0);
        bid_str = Integer.toString(bid);
        uid = getIntent().getIntExtra("uid",0);
         pass = getIntent().getIntExtra("no_pass",1); /*udb.getnoPass(bid);*/
        if (pass == 1) {
            setContentView(R.layout.checkin1);
        } else if (pass == 2) {
            setContentView(R.layout.checkin2);
        }
    }
        public void onclickpass1(View v) {
            EditText pass1 = (EditText)findViewById(R.id.pass1seat);
            int[] p = new int[1];
            p[0] =Integer.parseInt( pass1.getText().toString());
            int check = udb.checkseats(p[0], bid_str);
            if (check == 1){
            udb.updatepass(bid_str, p);
                Toast.makeText(CheckinActivity.this, "Checked in!", Toast.LENGTH_LONG).show();
                Intent i = new Intent(CheckinActivity.this,MainActivity.class);
                i.putExtra("username",udb.getUname(uid));
                startActivity(i);
            }
            if (check == -1){
                Toast.makeText(CheckinActivity.this, "seat already booked", Toast.LENGTH_SHORT).show();
            }
            if (check == 0){
                Toast.makeText(CheckinActivity.this, "invalid value of seat number", Toast.LENGTH_SHORT).show();
            }
        }


    public void onclickpass2(View v) {
        EditText pass1 = (EditText)findViewById(R.id.pass_seat_2_1);
        EditText pass2 = (EditText)findViewById(R.id.pass_seat_2_2);
        int[] p = new int[2];
        p[0] =Integer.parseInt( pass1.getText().toString());
        p[1] =Integer.parseInt( pass2.getText().toString());
        int check = udb.checkseats(p[0],p[1], bid_str);
        if (check == 1){
            udb.updatepass(bid_str, p);
            Toast.makeText(CheckinActivity.this, "Checked in!", Toast.LENGTH_LONG).show();
            Intent i = new Intent(CheckinActivity.this,MainActivity.class);
            i.putExtra("username",udb.getUname(uid));
            startActivity(i);
        }
        if (check == -1){
            Toast.makeText(CheckinActivity.this, "seat already booked", Toast.LENGTH_SHORT).show();
        }
        if (check == 0){
            Toast.makeText(CheckinActivity.this, "invalid value of seat number", Toast.LENGTH_SHORT).show();
        }
    }


}
