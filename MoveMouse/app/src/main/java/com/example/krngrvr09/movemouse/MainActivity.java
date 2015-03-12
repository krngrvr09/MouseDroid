package com.example.krngrvr09.movemouse;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class MainActivity extends ActionBarActivity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {
    Handler mHandler = UDPClient.mHandler;

    int prev_x = 0;
    int prev_y = 0;
    private GestureDetectorCompat mDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("here", "here");
        mDetector = new GestureDetectorCompat(this,this);
        mDetector.setOnDoubleTapListener(this);
        final Button keyboard = (Button) findViewById(R.id.keyboard);
        keyboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyboard.setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI);
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);

            }
        });
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Message msg = Message.obtain();
        switch (keyCode) {
            case KeyEvent.KEYCODE_A:

                msg.obj = "keycode_a";
                mHandler.sendMessage(msg);

                return true;
            case KeyEvent.KEYCODE_B:

                msg.obj = "keycode_b";
                mHandler.sendMessage(msg);

                return true;
            case KeyEvent.KEYCODE_C:

                msg.obj = "keycode_c";
                mHandler.sendMessage(msg);

                return true;

            case KeyEvent.KEYCODE_D:

                msg.obj = "keycode_d";
                mHandler.sendMessage(msg);

                return true;
            case KeyEvent.KEYCODE_E:

                msg.obj = "keycode_e";
                mHandler.sendMessage(msg);

                return true;
            case KeyEvent.KEYCODE_F:

                msg.obj = "keycode_f";
                mHandler.sendMessage(msg);

                return true;
            case KeyEvent.KEYCODE_G:

                msg.obj = "keycode_g";
                mHandler.sendMessage(msg);

                return true;
            case KeyEvent.KEYCODE_H:

                msg.obj = "keycode_h";
                mHandler.sendMessage(msg);

                return true;
            case KeyEvent.KEYCODE_I:

                msg.obj = "keycode_i";
                mHandler.sendMessage(msg);

                return true;
            case KeyEvent.KEYCODE_J:

                msg.obj = "keycode_j";
                mHandler.sendMessage(msg);

                return true;
            case KeyEvent.KEYCODE_K:

                msg.obj = "keycode_k";
                mHandler.sendMessage(msg);

                return true;
            case KeyEvent.KEYCODE_L:

                msg.obj = "keycode_l";
                mHandler.sendMessage(msg);

                return true;
            case KeyEvent.KEYCODE_M:

                msg.obj = "keycode_m";
                mHandler.sendMessage(msg);

                return true;
            case KeyEvent.KEYCODE_N:

                msg.obj = "keycode_n";
                mHandler.sendMessage(msg);

                return true;
            case KeyEvent.KEYCODE_O:

                msg.obj = "keycode_o";
                mHandler.sendMessage(msg);

                return true;
            case KeyEvent.KEYCODE_P:

                msg.obj = "keycode_p";
                mHandler.sendMessage(msg);

                return true;
            case KeyEvent.KEYCODE_Q:

                msg.obj = "keycode_q";
                mHandler.sendMessage(msg);

                return true;
            case KeyEvent.KEYCODE_R:

                msg.obj = "keycode_r";
                mHandler.sendMessage(msg);

                return true;
            case KeyEvent.KEYCODE_S:

                msg.obj = "keycode_s";
                mHandler.sendMessage(msg);

                return true;
            case KeyEvent.KEYCODE_T:

                msg.obj = "keycode_t";
                mHandler.sendMessage(msg);

                return true;
            case KeyEvent.KEYCODE_U:

                msg.obj = "keycode_u";
                mHandler.sendMessage(msg);

                return true;
            case KeyEvent.KEYCODE_V:

                msg.obj = "keycode_v";
                mHandler.sendMessage(msg);

                return true;
            case KeyEvent.KEYCODE_W:

                msg.obj = "keycode_w";
                mHandler.sendMessage(msg);

                return true;
            case KeyEvent.KEYCODE_X:

                msg.obj = "keycode_x";
                mHandler.sendMessage(msg);

                return true;
            case KeyEvent.KEYCODE_Y:

                msg.obj = "keycode_y";
                mHandler.sendMessage(msg);

                return true;
            case KeyEvent.KEYCODE_Z:

                msg.obj = "keycode_z";
                mHandler.sendMessage(msg);

                return true;
            case KeyEvent.KEYCODE_ENTER:

                msg.obj = "keycode_enter";
                mHandler.sendMessage(msg);

                return true;
            case KeyEvent.KEYCODE_BACK:

                msg.obj = "keycode_backspace";
                mHandler.sendMessage(msg);

                return true;
            default:
                return super.onKeyUp(keyCode, event);
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDetector.onTouchEvent(event);
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                Log.d("coordinates", x + " " + y);
                Message msg = Message.obtain();

                msg.obj = String.valueOf(x - prev_x) + ";" + String.valueOf(y-prev_y);
                mHandler.sendMessage(msg);

        }
        prev_x = x;
        prev_y = y;
        return false;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Log.d("gesture","single tap confirmed");
        Message msg = Message.obtain();

        msg.obj = "click";
        mHandler.sendMessage(msg);

        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.d("gesture","on double tap");

        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {

        Log.d("gesture","on double tap event");
        Message msg = Message.obtain();

        msg.obj = "double";
        mHandler.sendMessage(msg);


        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        Log.d("gesture","on down");

        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.d("gesture","on show press");


    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.d("gesture","on single tap up");

        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Message msg = Message.obtain();

        msg.obj = "right";
        mHandler.sendMessage(msg);

        Log.d("gesture","on long press");

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.d("gesture","on fling");

        return false;
    }
}
