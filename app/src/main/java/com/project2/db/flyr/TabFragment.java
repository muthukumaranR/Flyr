package com.project2.db.flyr;

/**
 * Created by Jazz on 13/11/2015.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TabFragment extends Fragment {

    View v;
    private int index;

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
            v = inflater.inflate(R.layout.cancelticket, null);
            Button b = (Button) v.findViewById(R.id.button);
            return v;
        }
    }


}




