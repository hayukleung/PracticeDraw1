package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    private Paint mPaint;
    private RectF mRectF;

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形

        int l = getWidth() / 6;
        int r = getWidth() / 6 * 5;
        int t = getHeight() / 6;
        int b = getHeight() / 6 * 5;

        if (null == mPaint) {
            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        }

        mPaint.setColor(Color.BLACK);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawArc(l, t, r, b, 180, 60, false, mPaint);
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawArc(l, t, r, b, 250, 110, true, mPaint);
            canvas.drawArc(l, t, r, b, 10, 160, false, mPaint);
        } else {
            if (null == mRectF) {
                mRectF = new RectF();
            }
            mRectF.set(l, t, r, b);
            mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawArc(mRectF, 180, 60, false, mPaint);
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawArc(mRectF, 250, 110, true, mPaint);
            canvas.drawArc(mRectF, 10, 160, false, mPaint);
        }
    }
}
