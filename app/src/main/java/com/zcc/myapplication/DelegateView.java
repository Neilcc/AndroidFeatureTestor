package com.zcc.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.os.Process;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ScrollView;

import hugo.weaving.DebugLog;

/**
 * Created by cc on 2019-08-27.
 */
public class DelegateView extends ScrollView {
    public DelegateView(Context context) {
        super(context);
    }

    public DelegateView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DelegateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
        Log.d("delegate", "thread id :" + Looper.getMainLooper().getThread().getId() + "");
        Log.d("delegate", "process id :" + Process.myPid() + "");

        super.onLayout(changed, l, t, r, b);
    }

    @DebugLog
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }

    @DebugLog
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }
}
