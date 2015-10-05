package com.project2.db.flyr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by muthukumaranR on 04/10/2015.
 */
public class signupActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
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
            }
 //iiii

//iiiim
            Intent i = new Intent(signupActivity.this, LandingActivity.class);
            i.putExtra("username1", username);
            i.putExtra("password",password);
            startActivity(i);

        }

    }
}

