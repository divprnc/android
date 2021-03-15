package com.example.prg3main;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText txtSearch;
	Button btnSearch;
	TextView lblMessage;
	String uri = "content://com.example.notesprovider/notes";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSearch=(EditText)findViewById(R.id.txt_search);
        lblMessage=(TextView)findViewById(R.id.lbl_message);
        
        btnSearch=(Button)findViewById(R.id.btn_search);
        btnSearch.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String searchDate=txtSearch.getText().toString();
				 String where="note_date=?";
				 String[] projection = new String[] {"note_date", "content"};
				 Cursor cursor = getContentResolver().query(Uri.parse(uri), projection, where, new String[] {searchDate}, null);
				 if(cursor != null && cursor.moveToNext()){
					 lblMessage.setText(cursor.getString(0) + " " + cursor.getString(1) + "\n");
				 }else{
					 Toast.makeText(getBaseContext(),"No Data Available", 
							 Toast.LENGTH_LONG).show();
				 }
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
