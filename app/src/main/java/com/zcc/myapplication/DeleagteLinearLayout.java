package com.zcc.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import hugo.weaving.DebugLog;

/**
 * Created by cc on 2019-08-28.
 */
public class DeleagteLinearLayout extends LinearLayout {
    public DeleagteLinearLayout(Context context) {
        super(context);
    }

    public DeleagteLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DeleagteLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
