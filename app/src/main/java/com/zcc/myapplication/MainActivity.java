package com.zcc.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView tv1 = null;
    TextView tv2 = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LinearLayout dv = findViewById(R.id.dv);
        for (int i = 0; i < 2; i++) {
            TextView tv = new DelegateTextView(this);
            if (i == 0) {
                tv1 = tv;
                tv.setText("testtttt +  " + i);
            }
            if (i == 1) {
                tv2 = tv;
            }
            dv.addView(tv);
        }
        dv.postDelayed(new Runnable(){

            @Override
            public void run() {
                dv.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                    @Override
                    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                        tv2.setText("2222222");
                    }
                });
            }
        },1000);

//        new Handler().postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//                Log.d("zcc", "test lp change");
//                tv1.getLayoutParams().width = 100;
//            }
//        }, 6000);
//        new Handler().postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//                Log.d("zcc", "test lp change request tv2");
//                tv2.invalidate();
//            }
//        }, 16000);
//        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
//            @Override
//            public boolean queueIdle() {
//                Log.d("zcc", "run idle");
//                return true;
//            }
//        });

    }
}
