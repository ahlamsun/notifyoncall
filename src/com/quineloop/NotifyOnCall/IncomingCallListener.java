package com.quineloop.notifyoncall;

import android.telephony.TelephonyManager;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class IncomingCallListener extends android.telephony.PhoneStateListener {

    private NotifyOnCall myActivity;

    public IncomingCallListener(NotifyOnCall myActivity){
	this.myActivity = myActivity;
    }
    
    @Override
    public void onCallStateChanged(int state, String incomingCallNumber) {
	
	if( TelephonyManager.CALL_STATE_RINGING == state ) {
	    System.out.println(" -- In the listener -- " + incomingCallNumber);
	    myActivity.setIncomingNumber(incomingCallNumber);
	    try {
		this.executeHttpGet(incomingCallNumber);
	    } catch(Exception e) {
		e.printStackTrace();
	    }
	}
    }

    private void executeHttpGet(String phone_number) throws Exception {
	HttpClient client = new DefaultHttpClient();
	HttpGet request = new HttpGet();
	request.setURI(new URI(myActivity.getNotifyURL() + phone_number));
	HttpResponse response = client.execute(request);
    }
}
