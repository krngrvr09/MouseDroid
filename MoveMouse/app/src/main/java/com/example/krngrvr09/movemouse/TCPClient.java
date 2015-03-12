package com.example.krngrvr09.movemouse;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Description
 *
 * @author Catalin Prata
 *         Date: 2/12/13
 */
public class TCPClient {

    public static final String SERVER_IP = "192.168.54.217"; //your computer IP address
    public static final int SERVER_PORT = 64000;
    // message to send to the server
    private String mServerMessage;
    // sends message received notifications
    private OnMessageReceived mMessageListener = null;
    // while this is true, the server will continue running
    private boolean mRun = false;
    // used to send messages
    private PrintWriter mBufferOut;
    // used to read messages from the server
    private BufferedReader mBufferIn;

    public static Handler mHandler;

    /**
     * Constructor of the class. OnMessagedReceived listens for the messages received from server
     */
    public TCPClient(OnMessageReceived listener) {
        mMessageListener = listener;
    }

    /**
     * Sends the message entered by client to the server
     *
     * @param message text entered by client
     */
    public void sendMessage(String message) {
        if (mBufferOut != null && !mBufferOut.checkError()) {
            mBufferOut.println(message);
            mBufferOut.flush();
        }
    }

    /**
     * Close the connection and release the members
     */
    public void stopClient() {
        Log.d("Debug", "stopClient");

        // send mesage that we are closing the connection
        //sendMessage(Constants.CLOSED_CONNECTION + "Kazy");

        mRun = false;

        if (mBufferOut != null) {
            mBufferOut.flush();
            mBufferOut.close();
        }

        mMessageListener = null;
        mBufferIn = null;
        mBufferOut = null;
        mServerMessage = null;
    }

    public void run() {

        mRun = true;
        Looper.prepare();
        mHandler = new Handler() {
            public void handleMessage(Message msg) {
                // Act on the message
                Log.d("message is ", String.valueOf(msg.obj));
                try {
                    //here you must put your computer's IP address.
                    InetAddress serverAddr = InetAddress.getByName(SERVER_IP);

                    Log.d("TCP Client", "C: Connecting...");

                    //create a socket to make the connection with the server
                    Socket socket = new Socket(serverAddr, SERVER_PORT);

                    DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());

                    // Send first message
                        dOut.writeByte(1);
                        dOut.writeUTF(String.valueOf(msg.obj));
                        dOut.flush(); // Send off the data

                    dOut.writeByte(-1);
                    dOut.flush();

                    dOut.close();
                    socket.close();
                } catch (Exception e) {

                    Log.d("TCP", "C: Error", e);

                }

            }
        };
        Looper.loop();



    }

    //Declare the interface. The method messageReceived(String message) will must be implemented in the MyActivity
    //class at on asynckTask doInBackground
    public interface OnMessageReceived {
        public void messageReceived(String message);
    }

}