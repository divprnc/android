package com.example.prg3;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button addBtn;
	EditText date, noteContent;
	String uri = "content://com.example.notesprovider/notes";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addBtn = (Button)findViewById(R.id.btn_add_note);
        date = (EditText)findViewById(R.id.txt_date);
        noteContent = (EditText)findViewById(R.id.txt_content);
        addBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				ContentResolver cr = getContentResolver();
				ContentValues cv = new ContentValues();
				cv.put(ProviderDatabase.C_Date, date.getText().toString());
				cv.put(ProviderDatabase.C_Note, noteContent.getText().toString());
				cr.insert(Uri.parse(uri), cv);
				Toast.makeText(getBaseContext(), "Data inserted Sucessfully", Toast.LENGTH_LONG).show();
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
