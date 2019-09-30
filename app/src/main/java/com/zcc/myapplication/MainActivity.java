package com.zcc.myapplication;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout dv = findViewById(R.id.dv);
        for (int i = 0; i < 100; i++) {
            TextView tv = new DelegateTextView(this);
            tv.setText("testtttt +  " + i);
            dv.addView(tv);
        }
    }
}
