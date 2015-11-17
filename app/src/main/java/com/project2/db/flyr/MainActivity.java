package com.project2.db.flyr;

/**
 * Created by Jazz on 13/11/2015.
 */

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements TabListener, DatePickerFragment.dateInterface {
    usersdbhelper udb = new usersdbhelper(this);
    List<Fragment> fragList = new ArrayList<Fragment>();
    String username;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ActionBar bar = getActionBar();
        username = getIntent().getStringExtra("username");
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
       /*String ds =  getIntent().getStringExtra("datestr");
        Button dateButton = (Button)findViewById(R.id.dateButton);
        dateButton.setText(ds);*/
        for (int i = 1; i <= 2; i++) {
            Tab tab = bar.newTab();
            if (i == 1) {
                tab.setText("Book Tickets");
                tab.setTabListener(this);
            } else {
                tab.setText("Tickets History");
                tab.setTabListener(this);
            }

            bar.addTab(tab);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        Fragment f = null;
        TabFragment tf = null;

        if (fragList.size() > tab.getPosition())
            fragList.get(tab.getPosition());

        if (f == null) {
            tf = new TabFragment();
            Bundle data = new Bundle();
            data.putInt("idx", tab.getPosition());
            tf.setArguments(data);
            fragList.add(tf);
        } else
            tf = (TabFragment) f;

        ft.replace(android.R.id.content, tf);

    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        if (fragList.size() > tab.getPosition()) {
            ft.remove(fragList.get(tab.getPosition()));
        }

    }

    public void showDatePickerDialog(View a) {

        if (a.getId() == R.id.dateButton) {

            //DatePickerFragment dpf = new DatePickerFragment();

//            DatePickerDialog dp = (DatePickerDialog) dpf.onCreateDialog(Bundle.EMPTY);
//            DatePicker dpk = dp.getDatePicker();
            DialogFragment newFragment = new DatePickerFragment();
            newFragment.show(getFragmentManager(), "datePicker");

        }
    }

    public void dateString(String s) {
        Button dateButton = (Button) findViewById(R.id.dateButton);
        dateButton.setText(s);
        //dt = s;
        /*DateFormat formatter = new SimpleDateFormat("MMMM d, yyyy");

        bookings b = new bookings();

        Date d = null;
        try {
            d = formatter.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        b.setD(d);

        udb.insertBooking(b);

*/
    }


//    public void onRadioButtonClicked(View view) {
//
//        boolean checked = ((RadioButton) view).isChecked();
//        switch (view.getId()) {
//            case R.id.rb1:
//                if (checked)
//
//                    break;
//            case R.id.rb2:
//                if (checked)
//
//                    break;
//            case R.id.rb3:
//                if (checked)
//                    // Ninjas rule
//                    break;
//            case R.id.rb4:
//                if (checked)
//                    // Ninjas rule
//                    break;
//        }
//
//    }

    public void onSearchflightclick(View a) {

        Intent i = new Intent(MainActivity.this,bookingActivity.class);
        EditText origtext = (EditText)findViewById(R.id.origin);
        String orig =origtext.getText().toString();
        EditText desttext = (EditText)findViewById(R.id.dest);
        String dest =desttext.getText().toString();
        Button datebutton = (Button)findViewById(R.id.dateButton);
        String datebtn =datebutton.getText().toString();
        int id=  udb.getUserId(username);
        String ID= Integer.toString(id);
        Spinner dropdown = (Spinner) findViewById(R.id.spinner);
        String pass = dropdown.getSelectedItem().toString();
        i.putExtra("orig",orig);
        i.putExtra("dest",dest);
        i.putExtra("date",datebtn);
        i.putExtra("pass", pass);
        i.putExtra("id",ID);
        startActivity(i);
        //shift intent to bookactivity, pass ,dt ,orig,dest,date  to it
        //startActivity(i);
    }

    public void onGenerateClick(View a) {
        Intent i = new Intent(MainActivity.this,TicketHistory.class);
        i.putExtra("username",username);
        startActivity(i);
    }




}

