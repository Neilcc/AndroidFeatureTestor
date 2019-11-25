package com.zcc.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
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
        LinearLayout dv = findViewById(R.id.dv);
        for (int i = 0; i < 2; i++) {
            TextView tv = new DelegateTextView(this);
            if ( i ==0) {
                tv1 = tv;
            }
            if(i ==1){
                tv2 = tv;
            }
            tv.setText("testtttt +  " + i);
            dv.addView(tv);
        }
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Log.d("zcc", "test lp change");
                tv1.getLayoutParams().width = 100;
            }
        }, 3000);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Log.d("zcc", "test lp change request tv2");
                tv2.invalidate();
            }
        }, 3000);


    }
}
