package com.example.prg6;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	Thread thread;
	boolean send = false;
	Button start, stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				try{
					send = true;
					thread = new Thread(run);
					thread.start();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});

        findViewById(R.id.stop).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				send = false;
			}
		});
        
        
    }

    Runnable run = new Runnable(){
    	int i = 0;
    	@Override
    	public void run() {
    		try{
    			while(send){
    				i++;
    				NotificationManager manager =  (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
    				NotificationCompat.Builder builder= new NotificationCompat.Builder(getApplicationContext());
    				builder.setContentTitle("Notification Message");
    				builder.setContentText("Hello World" + i);
    				builder.setSmallIcon(R.drawable.ic_launcher);
    				builder.setContentIntent(PendingIntent.getActivity(getApplicationContext(), 1, new Intent(getBaseContext(), MainActivity.class), 1));
    				Notification notification = builder.build();
    				manager.notify(100, notification);
                    Thread.sleep(3000);
    			
    			}
    			
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    	};
    };
}
