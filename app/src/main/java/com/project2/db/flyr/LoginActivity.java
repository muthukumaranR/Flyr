package com.project2.db.flyr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends Activity {
    int flag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
    public void onButtonClick(View v){
        if(v.getId() == R.id.Lbutton){
            EditText un = (EditText)findViewById(R.id.username);
            String username =un.getText().toString();
            Intent i = new Intent(LoginActivity.this,LandingActivity.class);
            i.putExtra("username",username);
            startActivity(i);

        }
        if(v.getId() == R.id.Sbutton){
            Intent i = new Intent(LoginActivity.this,signupActivity.class);
            startActivity(i);
        }

    }
    public void ontvclick(View v) {
        if ((v.getId() == R.id.username)&& flag == 0){
            flag = 1;
        EditText un = (EditText) findViewById(R.id.username);
        un.setText("");
    }

    }
}