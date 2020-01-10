package com.zcc.myapplication.draw;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;

/**
 * description
 *
 * @author hejiangjie on 2019-11-01
 */
public class CornerMaker {
    private Paint mMaskPaint;

    private int mWidth, mHeight;
    private float mTopLeftRadius;
    private float mTopRightRadius;
    private float mBottomLeftRadius;
    private float mBottomRightRadius;

    public CornerMaker(int width, int height) {
        mWidth = width;
        mHeight = height;

        mMaskPaint = new Paint();
        mMaskPaint.setColor(Color.WHITE);
        mMaskPaint.setAntiAlias(true);
        mMaskPaint.setStyle(Paint.Style.FILL);
//        mMaskPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        mMaskPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public void updateSize(int width, int height) {
        mWidth = width;
        mHeight = height;
    }

    public void setCornerRadius(float topLeft, float topRight, float bottomLeft, float bottomRight) {
        this.mTopLeftRadius = topLeft;
        this.mTopRightRadius = topRight;
        this.mBottomRightRadius = bottomRight;
        this.mBottomLeftRadius = bottomLeft;
    }

    public void setCornerRadius(float radius) {
        setCornerRadius(radius, radius, radius, radius);
    }

    public boolean isNoneCornerDefine() {
        return !(mTopLeftRadius > 0 || mTopRightRadius > 0 || mBottomLeftRadius > 0 || mBottomRightRadius > 0);
    }

    public void drawCornerMask(Canvas canvas) {
        drawTopLeft(canvas);
        drawTopRight(canvas);
        drawBottomLeft(canvas);
        drawBottomRight(canvas);
    }

    private void drawTopLeft(Canvas canvas) {
        if (mTopLeftRadius > 0) {
            Path path = new Path();
            path.moveTo(0, mTopLeftRadius);
            path.lineTo(0, 0);
            path.lineTo(mTopLeftRadius, 0);
            path.arcTo(new RectF(0, 0, mTopLeftRadius * 2, mTopLeftRadius * 2),
                    -90, -90);
            path.close();
            canvas.drawPath(path, mMaskPaint);
        }
    }

    private void drawTopRight(Canvas canvas) {
        if (mTopRightRadius > 0) {
            int width = mWidth;
            Path path = new Path();
            path.moveTo(width - mTopRightRadius, 0);
            path.lineTo(width, 0);
            path.lineTo(width, mTopRightRadius);
            path.arcTo(new RectF(width - 2 * mTopRightRadius, 0, width,
                    mTopRightRadius * 2), 0, -90);
            path.close();
            canvas.drawPath(path, mMaskPaint);
        }
    }

    private void drawBottomLeft(Canvas canvas) {
        if (mBottomLeftRadius > 0) {
            int height = mHeight;
            Path path = new Path();
            path.moveTo(0, height - mBottomLeftRadius);
            path.lineTo(0, height);
            path.lineTo(mBottomLeftRadius, height);
            path.arcTo(new RectF(0, height - 2 * mBottomLeftRadius,
                    mBottomLeftRadius * 2, height), 90, 90);
            path.close();
            canvas.drawPath(path, mMaskPaint);
        }
    }

    private void drawBottomRight(Canvas canvas) {
        if (mBottomRightRadius > 0) {
            int height = mHeight;
            int width = mWidth;
            Path path = new Path();
            path.moveTo(width - mBottomRightRadius, height);
            path.lineTo(width, height);
            path.lineTo(width, height - mBottomRightRadius);
            path.arcTo(new RectF(width - 2 * mBottomRightRadius, height - 2
                    * mBottomRightRadius, width, height), 0, 90);
            path.close();
            canvas.drawPath(path, mMaskPaint);
        }
    }
}
