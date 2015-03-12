package com.example.krngrvr09.movemouse;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by krngrvr09 on 11/3/15.
 */
public class UDPClient {
    public static String SERVER_IP = ""; //your computer IP address
    public static final int SERVER_PORT = 10000;

    public static Handler mHandler;
    private OnMessageReceived mMessageListener = null;

    public UDPClient(OnMessageReceived listener, String ip_address) {

        mMessageListener = listener;
        SERVER_IP = ip_address;
    }


    public void run(){
        Looper.prepare();
        mHandler = new Handler() {
            public void handleMessage(Message msg) {
                // Act on the message
                Log.d("message is ", String.valueOf(msg.obj));
                DatagramSocket socket = null;
                try {
                    socket = new DatagramSocket();
                } catch (SocketException e) {
                    e.printStackTrace();
                }

                try {
                    //here you must put your computer's IP address.
                    InetAddress serverAddr = InetAddress.getByName(SERVER_IP);

                    Log.d("UDP Client", "C: Connecting to "+SERVER_IP);

                    //create a socket to make the connection with the server
                    String Message = String.valueOf(msg);
                    DatagramPacket dp;
                    dp = new DatagramPacket(Message.getBytes(), Message.length(), serverAddr, SERVER_PORT);
                    socket.setBroadcast(true);
                    socket.send(dp);

                    // Send first message

                } catch (Exception e) {

                    Log.d("UDP", "C: Error", e);

                }
                finally {
                    if(socket!=null){
                        socket.close();
                    }

                }

            }
        };
        Looper.loop();
    }
    public interface OnMessageReceived {
        public void messageReceived(String message);
    }

}
