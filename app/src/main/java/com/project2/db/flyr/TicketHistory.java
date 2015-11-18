package com.project2.db.flyr;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * Created by Deepak on 11/17/2015.
 */
public class TicketHistory extends Activity {
    usersdbhelper udb = new usersdbhelper(this);
    private String username;
    private int uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cancelticket);
        username = getIntent().getStringExtra("username");
        populateListOfFlightsHistory();

    }

    private void populateListOfFlightsHistory() {

        uid=  udb.getUserId(username);
        usersdbhelper udb = new usersdbhelper(this);
        Cursor cursor = udb.getFlightHistory(uid);

        // Allow activity to manage lifetime of the cursor.
        // DEPRECATED! Runs on the UI thread, OK fcc or small/short queries.
        startManagingCursor(cursor);

        // Setup mapping from cursor to view fields:
        String[] fromFieldNames = new String[]
                {"fname", "origin", "dest","bookedDate","count"};
        int[] toViewIDs = new int[]
                {R.id.flight_name2, R.id.flight_origin2, R.id.flight_dest2, R.id.flight_date2, R.id.no_pass2};

        // Create adapter to may columns of the DB onto elemesnt in the UI.
        SimpleCursorAdapter myCursorAdapter =
                new SimpleCursorAdapter(
                        this,        // Context
                        R.layout.item_layout1,    // Row layout template
                        cursor,                    // cursor (set of DB records t o map)
                        fromFieldNames,            // DB Column names
                        toViewIDs                // View IDs to put information in
                );

        // Set the adapter for the list view
        ListView bookedList = (ListView) findViewById(R.id.listHistory);
        bookedList.setAdapter(myCursorAdapter);
        bookedList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String bid= ""+id+"";
                String userid = ""+uid+"";
                Intent i = new Intent(TicketHistory.this,ChooseOption.class);
                i.putExtra("bid",bid);
                i.putExtra("uid",userid);
                startActivity(i);
            }
        });
    }
}
