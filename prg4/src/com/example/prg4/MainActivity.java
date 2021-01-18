package com.example.prg4;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
    TextView txtCounter;
    int i = 0;Thread mythread;
    boolean running = false;
    Button btnstart, btnstop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnstart= (Button)findViewById(R.id.btnStart);
        btnstop = (Button)findViewById(R.id.btnStop);
        txtCounter = (TextView)findViewById(R.id.counter);
        btnstart.setOnClickListener(this);
        btnstop.setOnClickListener(this);
      
        
    }
    Runnable runnable =new Runnable() {
        @Override
        public void run() {
            try{
                while(i <= 1234567 && running){
					Log.i("btnstart", "Thread Started");
                    Thread.sleep(1000);
                    i++;
                    hand.sendEmptyMessage(i);
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    };
    Handler hand = new Handler() {
    	@Override
    	public void handleMessage(android.os.Message msg) {
    		txtCounter.setText(""+msg.what);
    	};
    };

    @Override
		public void onClick(View arg0) {
			if(arg0.equals(btnstart)){
				try{
					running = true;
					mythread = new Thread(runnable);
					mythread.start();
				}catch(Exception e){
					e.printStackTrace();
				}
			}else if(arg0.equals(btnstop)){
				try{
 					running = false;
 				}catch(Exception e){
 					e.printStackTrace();
 				}
			}
		}

}
