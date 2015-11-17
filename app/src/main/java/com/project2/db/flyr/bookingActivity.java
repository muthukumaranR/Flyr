package com.project2.db.flyr;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

/**
 * Created by Deepak on 11/15/2015.
 */
//check again
public class bookingActivity extends Activity {
    private String orig,dest,date,passw,uid;
    String pass = "pass";
    usersdbhelper udb = new usersdbhelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        passw =getIntent().getStringExtra("pass");
        orig = getIntent().getStringExtra("orig");
        dest = getIntent().getStringExtra("dest");
        date = getIntent().getStringExtra("date");
        uid = getIntent().getStringExtra("id");

        if(passw.equals("1")){
            setContentView(R.layout.passenger1);
        }
        else
        {
            setContentView(R.layout.passenger2);
        }
        udb.insertSeatsTable(date);
        populateListOfBookedFlights();

    }

    private void populateListOfBookedFlights(){
        usersdbhelper udb = new usersdbhelper(this);
        Cursor cursor = udb.getRequiredFlight(orig, dest);

        // Allow activity to manage lifetime of the cursor.
        // DEPRECATED! Runs on the UI thread, OK fcc or small/short queries.
        startManagingCursor(cursor);

        // Setup mapping from cursor to view fields:
        String[] fromFieldNames = new String[]
                {"fname","origin","dest","fare"};
        int[] toViewIDs = new int[]
                {R.id.flight_name,R.id.flight_origin,R.id.flight_dest,R.id.flight_fare};

        // Create adapter to may columns of the DB onto elemesnt in the UI.
        SimpleCursorAdapter myCursorAdapter =
                new SimpleCursorAdapter(
                        this,		// Context
                        R.layout.item_layout,	// Row layout template
                        cursor,					// cursor (set of DB records t o map)
                        fromFieldNames,			// DB Column names
                        toViewIDs				// View IDs to put information in
                );

        // Set the adapter for the list view
        ListView bookedList = (ListView) findViewById(R.id.listBooking);
        bookedList.setAdapter(myCursorAdapter);
        bookedList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(bookingActivity.this, bookActivity.class);
                String s = ""+id+"";
                i.putExtra("id", s);
                i.putExtra("pass",passw);
                i.putExtra("date", date);
                i.putExtra("uid",uid);
                if(passw.equals("1")) {
                    String passname1 = ((TextView) findViewById(R.id.pass_1)).getText().toString();
                    i.putExtra("pass1", passname1);
                }
                else
                {
                    String passname1 = ((TextView) findViewById(R.id.pass_2_1)).getText().toString();
                    String passname2 = ((TextView) findViewById(R.id.pass_2_2)).getText().toString();
                    i.putExtra("pass1", passname1);
                    i.putExtra("pass2", passname2);
                }
                startActivity(i);

            }
        });
    }
}
