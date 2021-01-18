package com.example.prg2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        findViewById(R.id.btncreate).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				ViewGroup vg = (ViewGroup)findViewById(R.id.dialog);
				View dialogBox = LayoutInflater.from(arg0.getContext()).inflate(R.layout.dialog_box, vg ,false);
				builder.setView(dialogBox);
				builder.setNegativeButton("Cancel", null);
				final AlertDialog alert = builder.create();
				alert.show();
				final EditText fname = (EditText)dialogBox.findViewById(R.id.hello);
				final Button btncreate = (Button)dialogBox.findViewById(R.id.create);
				btncreate.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						try{
						String filename = fname.getText().toString();
						File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + filename + ".txt");
						file.createNewFile();
						if(file.exists()){
//							OutputStream os = new FileOutputStream(file);
//							String data = "My name is Prince Kumar";
//							byte[] finalData = data.getBytes();
//							os.write(finalData);
//							os.close();
//							alert.dismiss();
//							Toast.makeText(getApplicationContext(), "File Created", Toast.LENGTH_SHORT).show();
							FileInputStream fs = new  FileInputStream(file);
							InputStreamReader is = new InputStreamReader(fs);
							BufferedReader buffer = new BufferedReader(is);
							String fdata = buffer.readLine();
							String finalReadingData = "";
							while(fdata != null){
								finalReadingData += fdata;
								fdata = buffer.readLine();
							}
							buffer.close();
							Toast.makeText(getApplicationContext(), "File readed", Toast.LENGTH_SHORT).show();
							fname.setText(finalReadingData);
							alert.dismiss();

						}
						
						
						
						}
						catch(Exception e){
							e.printStackTrace();
						}
						
					}
				});
			}
		});
        
        
    }


   
    
}
