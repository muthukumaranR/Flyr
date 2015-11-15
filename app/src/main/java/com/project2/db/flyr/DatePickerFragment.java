package com.project2.db.flyr;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by Jazz on 14/11/2015.
 */

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {
    View v;
    dateInterface iDate;

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker v, int selectedYear, int selectedMonth, int selectedDay) {
        int year = selectedYear;
        int month = selectedMonth;
        int day = selectedDay;

        String bookingdate = String.valueOf(year) + "-" + String.valueOf(month + 1 + "-" + String.valueOf(day));
        iDate.dateString(bookingdate);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            iDate = (dateInterface) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement datestring");
        }
    }


    // Container Activity must implement this interface
    public interface dateInterface {
        void dateString(String str);
    }
}
