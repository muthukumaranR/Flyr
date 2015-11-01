package com.project2.db.flyr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by muthukumaranR on 04/10/2015.
 */
public class signupActivity extends Activity {
   usersdbhelper udb = new usersdbhelper(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        // Enable Local Datastore.
               // Parse.enableLocalDatastore(this);

        //Parse.initialize(this, "OuE4pytQXvmmejPc7fbyPMmInNh1CVku7H18ZXkV", "JDnDu25hjmPgYrAXRjpSvMve0A5xpwY5zYql0ozW");

    }

    public void onButtonClick(View v) {
        if (v.getId() == R.id.Sbutton) {
            EditText un = (EditText) findViewById(R.id.username);
            String username = un.getText().toString();
            EditText pwd1 = (EditText) findViewById(R.id.password);
            String password1 = pwd1.getText().toString();
            EditText pwd2 = (EditText) findViewById(R.id.password2);
            String password2 = pwd2.getText().toString();
            String password = null ;
            if (password1.equals(password2)) {
                password = password1;
                //insert table
                users u = new users();
                u.setpassword(password);
                u.setusername(username);
                udb.insertUser(u);

                Intent i = new Intent(signupActivity.this, LandingActivity.class);
                i.putExtra("username1", username);
                i.putExtra("password", password);
                startActivity(i);
            }
            else{
                Toast.makeText(signupActivity.this, "pass dont match", Toast.LENGTH_SHORT).show();
            }


        }

    }
}

