package com.example.krngrvr09.movemouse;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by krngrvr09 on 8/3/15.
 */
public class ConnectTask extends AsyncTask<String, String, String> {
    UDPClient mUDPClient;
    @Override
    protected String doInBackground(String... message) {
        //we create a UDPClient object and
        //Log.d("coordinates",message[0]);
        Log.d("ip address",message[0]);
        mUDPClient = new UDPClient(new UDPClient.OnMessageReceived() {
            @Override
            //here the messageReceived method is implemented
            public void messageReceived(String message) {
                //this method calls the onProgressUpdate
                //publishProgress(message);
                Log.d("Debug input message", "Input message: " + message);
            }
        },message[0]);
        mUDPClient.run();

        //mTCPClient.stopClient();
        return null;
    }


    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        Log.d("onProgressUpdate", values[0]);

    }
}