package com.example.prg5;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView num = (TextView)findViewById(R.id.tnumber);
        final TextView content = (TextView)findViewById(R.id.tcontent);
        Bundle b = getIntent().getBundleExtra("data");
        if(b!= null){
        	String number = b.getString("number");
        	String cont = b.getString("content");
        	num.setText(number);
        	content.setText(cont);
        }
        else{
        	Toast.makeText(getApplicationContext(), "Fuck Off", Toast.LENGTH_LONG).show();
        }
    }



    
}
