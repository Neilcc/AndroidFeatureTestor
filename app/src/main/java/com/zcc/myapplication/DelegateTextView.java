package com.zcc.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.widget.TextView;

import hugo.weaving.DebugLog;

/**
 * Created by cc on 2019-08-28.
 */
public class DelegateTextView extends TextView {

    public DelegateTextView(Context context) {
        super(context);
    }

    @Override
    @DebugLog
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    @DebugLog
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @DebugLog
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    @DebugLog
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @DebugLog
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }

}
