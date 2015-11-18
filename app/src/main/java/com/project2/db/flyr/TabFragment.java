package com.project2.db.flyr;

/**
 * Created by Jazz on 13/11/2015.
 */

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TabFragment extends Fragment {

    View v;
    private int index;
    user u;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle data = getArguments();
        index = data.getInt("idx");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (index == 0) {
            v = inflater.inflate(R.layout.ticketbooking, null);
            Button dateButton = (Button) v.findViewById(R.id.dateButton);
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy ");
            dateButton.setText(dateFormat.format(date));
            return v;
        } else {
            v = inflater.inflate(R.layout.dummy_history, null);
            //u.getuser();
            return v;
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            u = (user) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement datestring");
        }
    }

    public interface user
    {
        void getuser();
    }



}




