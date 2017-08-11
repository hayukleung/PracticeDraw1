package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    private Paint mPaint;
    private Path mPath;
    private RectF mRectF;

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形

        if (null == mPaint) {
            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        }

        if (null == mPath) {
            mPath = new Path();
        }

        if (null == mRectF) {
            mRectF = new RectF();
        }

        int radius = getWidth() / 10;
        int l = getWidth() / 2 - 2 * radius;
        int r = getWidth() / 2 + 2 * radius;
        int t = getHeight() / 2 - radius;
        int b = getHeight() / 2 + 2 * radius;

        mPath.reset();
        mPath.moveTo(l, getHeight() / 2);
        mRectF.set(l, t, l + 2 * radius, t + 2 * radius);
        mPath.arcTo(mRectF, 135, 225);
        mRectF.set(r - 2 * radius, t, r, t + 2 * radius);
        mPath.arcTo(mRectF, 180, 225);
        mPath.lineTo(getWidth() / 2, b);
        mPath.lineTo((int)(l + (1 - (Math.pow(2, 0.5) / 2)) * radius), (int) (getHeight() / 2 + (Math.pow(2, 0.5) / 2) * radius));
        mPath.close();

        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);

        canvas.drawPath(mPath, mPaint);
    }
}
