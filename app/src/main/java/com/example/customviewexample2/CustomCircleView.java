package com.example.customviewexample2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CustomCircleView extends View {
    private Paint paint;
    private float radius = 100f;
    private float cx = 200f;
    private float cy = 200f;

    public CustomCircleView(Context context) {
        super(context);
        init();
    }

    public CustomCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(cx, cy, radius, paint);
    }

    public void setCircleColor(int color) {
        paint.setColor(color);
        invalidate();
    }

    public void setCircleSize(float newSize) {
        radius = newSize;
        invalidate();
    }

    public void setCirclePosition(float x, float y) {
        cx = x;
        cy = y;
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            setCircleColor(Color.RED);
            return true;
        }
        return super.onTouchEvent(event);
    }
}
