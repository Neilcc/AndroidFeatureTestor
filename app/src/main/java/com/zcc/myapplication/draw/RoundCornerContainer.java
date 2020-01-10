package com.zcc.myapplication.draw;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;


/**
 * 圆角容器
 *
 * @author hejiangjie on 2019-11-01
 */
public class RoundCornerContainer extends FrameLayout {

    private Paint mLayoutPaint;

    private CornerMaker mCornerMaker;

    public RoundCornerContainer(Context context) {
        this(context, null);
    }

    public RoundCornerContainer(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundCornerContainer(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        float topLeftRadius = 0f, topRightRadius = 0f, bottomLeftRadius = 0f, bottomRightRadius = 0f;
//        if (attrs != null) {
//            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.RoundCornerContainer);
//            float radius = ta.getDimension(R.styleable.RoundCornerContainer_rcc_radius, 0);
//            topLeftRadius = ta.getDimension(R.styleable.RoundCornerContainer_rcc_topLeftRadius, radius);
//            topRightRadius = ta.getDimension(R.styleable.RoundCornerContainer_rcc_topRightRadius, radius);
//            bottomLeftRadius = ta.getDimension(R.styleable.RoundCornerContainer_rcc_bottomLeftRadius, radius);
//            bottomRightRadius = ta.getDimension(R.styleable.RoundCornerContainer_rcc_bottomRightRadius, radius);
//            ta.recycle();
//        }

        mCornerMaker = new CornerMaker(0, 0);
        mCornerMaker.setCornerRadius(topLeftRadius, topRightRadius, bottomRightRadius, bottomLeftRadius);

        mLayoutPaint = new Paint();
        mLayoutPaint.setAntiAlias(true);
        mLayoutPaint.setXfermode(null);
    }

    public void setCornerRadius(float radius) {
        if (mCornerMaker != null) {
            mCornerMaker.setCornerRadius(radius);
        }
    }

    public void setCornerRadius(float topLeft, float topRight, float bottomLeft, float bottomRight) {
        if (mCornerMaker != null) {
            mCornerMaker.setCornerRadius(topLeft, topRight, bottomRight, bottomLeft);
        }
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        if (mCornerMaker == null || mCornerMaker.isNoneCornerDefine()) {
            super.dispatchDraw(canvas);
        } else {
            canvas.saveLayer(new RectF(0, 0, canvas.getWidth(), canvas.getHeight()), mLayoutPaint, Canvas.ALL_SAVE_FLAG);
            super.dispatchDraw(canvas);
            drawMask(canvas);
            canvas.restore();
        }
    }

    private void drawMask(Canvas canvas) {
        if (mCornerMaker != null) {
            mCornerMaker.updateSize(getWidth(), getHeight());
            mCornerMaker.drawCornerMask(canvas);
        }
    }
}
