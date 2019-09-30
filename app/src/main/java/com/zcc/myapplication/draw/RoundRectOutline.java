package com.zcc.myapplication.draw;

import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;

import androidx.annotation.RequiresApi;

/**
 * Created by cc on 2019-09-17.
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class RoundRectOutline extends ViewOutlineProvider {

    public Rect rect = new Rect(0, 0, 600, 600);


    @Override
    public void getOutline(View view, Outline outline) {
        outline.setRoundRect(rect, 50);
    }
}
