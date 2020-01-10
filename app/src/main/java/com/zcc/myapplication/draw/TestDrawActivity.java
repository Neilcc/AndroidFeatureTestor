package com.zcc.myapplication.draw;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.zcc.myapplication.DelegateTextView;
import com.zcc.myapplication.R;

public class TestDrawActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_draw);
        findViewById(R.id.test_img).setBackground(new RoundRectDrawable(300, 30, 30, 30, Color.BLUE));
        findViewById(R.id.test_rl).setBackground(new RoundRectDrawable(400, 40, 40, 40, Color.YELLOW));
        findViewById(R.id.test_imgg).setBackground(new RoundRectDrawable(300, 30, 30, 30, Color.BLUE));
        findViewById(R.id.test_rll).setBackground(new RoundRectDrawable(400, 40, 40, 40, Color.YELLOW));
        findViewById(R.id.test_imggg).setOutlineProvider(new RoundRectOutline());
        findViewById(R.id.test_imggg).setClipToOutline(true);
        findViewById(R.id.test_rlll).setOutlineProvider(new RoundRectOutline());
        findViewById(R.id.test_rlll).setClipToOutline(true);
        LinearLayout dv = findViewById(R.id.dv);
        dv.setOutlineProvider(new RoundRectOutline());
        dv.setClipToOutline(true);
        for (int i = 0; i < 10; i++) {
            TextView tv = new DelegateTextView(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            tv.setText("testtttt +  " + i);
            tv.setBackgroundColor(Color.GREEN);
            dv.addView(tv, lp);
        }
        ((RoundCornerContainer) findViewById(R.id.rdjj)).setCornerRadius(300);
    }

}
