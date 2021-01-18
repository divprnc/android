package com.example.prg5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SmsListener extends BroadcastReceiver{
	@Override
	public void onReceive(Context context, Intent intent) {
		
	Object[] objmessages=(Object[])intent.getExtras().get("pdus");
	
	for(int i=0; i<objmessages.length;i++)
	{
		SmsMessage m =SmsMessage.createFromPdu((byte[])objmessages[i]);
		Bundle b1=new Bundle();
		b1.putString("number", m.getOriginatingAddress()); 
		b1.putString("content", m.getMessageBody());
		Intent it=new Intent(context, MainActivity.class);
		it.putExtra("data", b1);
		it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(it);
		break;
	}
	
}

}
