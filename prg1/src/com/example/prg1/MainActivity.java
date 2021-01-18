package com.example.prg1;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText eid = (EditText)findViewById(R.id.eid);
        final EditText ename = (EditText)findViewById(R.id.ename);
        final EditText eage = (EditText)findViewById(R.id.eage);
        final EditText eaddr = (EditText)findViewById(R.id.eaddr);
        final Button save = (Button)findViewById(R.id.save);
        final EditText getid = (EditText)findViewById(R.id.getid);
        final Button show = (Button)findViewById(R.id.show);
        final TextView showData = (TextView)findViewById(R.id.showData);
        try{
        	
        	final SQLiteDatabase db = openOrCreateDatabase("Employee", MODE_PRIVATE, null);
        	db.execSQL("create table if not exists user(id int, name VARCHAR,age int, address VARCHAR)");
        	Toast.makeText(getApplicationContext(), "Database and Table Created", Toast.LENGTH_LONG).show();
        	
        	save.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					String sid = eid.getText().toString();
					int id = Integer.parseInt(sid);
					String name = ename.getText().toString();
					String sage = eage.getText().toString();
					int age = Integer.parseInt(sage);
					String addr = eaddr.getText().toString();
					// insert into user value(1, 'Fali', 22, 'Nepal');
					db.execSQL("insert into user values(" + id + ",'" + name + "'," + age + ",'" + addr + "')");
		        	Toast.makeText(getApplicationContext(), "Data inserted", Toast.LENGTH_LONG).show();
		        	
		        	
				}
			});
        	
        	
        	show.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					String query = "select * from user";
					Log.i("Query",  query);
		        	Cursor c = db.rawQuery(query, null);
		        	c.moveToFirst();
		        	int nameIndex = c.getColumnIndex("name");
		        	while(c.moveToNext()){
		        		Log.i("msg", c.getString(nameIndex));
			        	showData.append(c.getString(nameIndex) + "\n");
		        	}
					
				}
			});
        	
        	
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        
        
        
        
        
        
        
    }

    
    
}
