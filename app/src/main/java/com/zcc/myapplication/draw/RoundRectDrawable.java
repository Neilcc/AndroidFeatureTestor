package com.zcc.myapplication.draw;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;

/**
 * Created by 薛贤俊 on 2019/3/11.
 */
public class RoundRectDrawable extends Drawable {

    protected Path mPath = new Path();
    private RectF mRect = new RectF();
    private Rect outlineR = new Rect();
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mBorderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float mTopLeftRadius;
    private float mTopRightRadius;
    private float mBottomLeftRadius;
    private float mBottomRightRadius;
    private int mBorderWidth;

    private int mBorderColor;

    public RoundRectDrawable(float topLeft, float topRight, float bottomLeft, float bottomRight) {
        this(topLeft, topRight, bottomLeft, bottomRight, Color.WHITE);
    }

    public RoundRectDrawable(float topLeft, float topRight, float bottomLeft,
                             float bottomRight, int color) {
        this.mTopLeftRadius = topLeft;
        this.mTopRightRadius = topRight;
        this.mBottomLeftRadius = bottomLeft;
        this.mBottomRightRadius = bottomRight;
        setColor(color);
    }

    public void setColor(int color) {
        mPaint.setColor(color);
    }

    public void setBorderWidth(int width) {
        mBorderWidth = width;
        mBorderPaint.setStrokeWidth(mBorderWidth);
        mBorderPaint.setStyle(Paint.Style.STROKE);
    }

    public void setBorderColor(int color) {
        mBorderPaint.setColor(color);
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        mRect.set(bounds);
        outlineR.set(bounds);
        updatePath();
    }

    private void updatePath() {
        mPath.reset();
        mPath.addRoundRect(mRect, new float[]{
                mTopLeftRadius, mTopLeftRadius,
                mTopRightRadius, mTopRightRadius,
                mBottomRightRadius, mBottomRightRadius,
                mBottomLeftRadius, mBottomLeftRadius
        }, Path.Direction.CW);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawPath(mPath, mPaint);
        if (mBorderWidth > 0) {
            canvas.drawPath(mPath, mBorderPaint);
        }
    }

    @Override
    public void getOutline(@NonNull Outline outline) {
        outline.setRoundRect(outlineR,mTopLeftRadius);
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.OPAQUE;
    }
}
