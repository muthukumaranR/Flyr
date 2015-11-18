package com.project2.db.flyr;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by karthick on 11/10/2015.
 */
public class AdminActivity extends Activity{
    usersdbhelper udb = new usersdbhelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);
        String aid = getIntent().getStringExtra("adminId");
       /* TextView tv = (TextView)findViewById(R.id.Aid);
        tv.setText(aid);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    public void onadminClick(View v){
        // private String fid, fname, origin, dest;
        //   private int maxseats, fare, start, end;
        flight f = new flight();

        EditText fidtext = (EditText) findViewById(R.id.fid);
        String fid = fidtext.getText().toString();
        EditText fnametext = (EditText) findViewById(R.id.fname);
        String fname = fnametext.getText().toString();
        EditText origintext = (EditText) findViewById(R.id.origin);
        String origin = origintext.getText().toString();
        EditText desttext = (EditText) findViewById(R.id.dest);
        String dest = desttext.getText().toString();
        EditText maxseatstext = (EditText) findViewById(R.id.maxseats);
        int maxseats = Integer.parseInt(maxseatstext.getText().toString());
        EditText faretext = (EditText) findViewById(R.id.fare);
        int fare = Integer.parseInt(faretext.getText().toString());
        EditText starttext = (EditText) findViewById(R.id.start);
        int start = Integer.parseInt(starttext.getText().toString());
        EditText endtext = (EditText) findViewById(R.id.end);
        int end = Integer.parseInt(endtext.getText().toString());
        f.setFid(fid);
        f.setFname(fname);
        f.setOrigin(origin);
        f.setDest(dest);
        f.setMaxseats(maxseats);
        f.setFare(fare);
        f.setStart(start);
        f.setEnd(end);
        udb.insertFlight(f);
        Toast.makeText(AdminActivity.this, "flight details added/modified", Toast.LENGTH_SHORT).show();

    }

}
