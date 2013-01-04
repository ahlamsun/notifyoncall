package com.quineloop.notifyoncall;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.telephony.TelephonyManager;

public class NotifyOnCall extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
	setupIncomingCallListener();
    }

    public void setIncomingNumber(String incomingCallNumber) {
	System.out.println("Inside the activity: " + incomingCallNumber);
    }

    public String getNotifyURL() {
	return "https://  /push?phone=";
    }

    private void setupIncomingCallListener() {
	IncomingCallListener incomingCallListener = new IncomingCallListener(this);
	TelephonyManager telephonyManager =
	    (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
	telephonyManager.listen(
	    incomingCallListener, IncomingCallListener.LISTEN_CALL_STATE
	);
    }
}
