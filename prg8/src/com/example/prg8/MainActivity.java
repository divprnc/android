package com.example.prg8;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText mobnum = (EditText)findViewById(R.id.mobnum);
        findViewById(R.id.btncall).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String num = mobnum.getText().toString();
				Intent it = new Intent(Intent.ACTION_CALL);
				it.setData(Uri.parse(num));
				startActivity(it);
			}
		});
        
        findViewById(R.id.btnsave).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String num = mobnum.getText().toString();
				Intent it = new Intent(Intent.ACTION_INSERT, ContactsContract.Contacts.CONTENT_URI); 
				it.putExtra(ContactsContract.Intents.Insert.PHONE, num);
				startActivity(it);
			}
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
