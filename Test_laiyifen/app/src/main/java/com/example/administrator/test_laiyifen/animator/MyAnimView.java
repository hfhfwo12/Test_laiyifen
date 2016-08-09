package com.example.administrator.test_laiyifen.animator;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by Administrator on 2016/7/25.
 */public class MyAnimView extends View {

    private static final float RADIUS = 50F;

    private Paint mPaint;
    private Point mPointF;

    public MyAnimView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    //初始化画笔和坐标
    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);

        mPointF = new Point(RADIUS, RADIUS);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawCircle(canvas);
    }

    //绘制小球
    private void drawCircle(Canvas canvas) {
        float x = mPointF.getX();
        float y = mPointF.getY();
        canvas.drawCircle(x, y, RADIUS, mPaint);
    }

    private void startAnimation() {
        Point startPoint = new Point(RADIUS, RADIUS);
        Point endPoint = new Point(getWidth() - RADIUS, getHeight() - RADIUS);
        ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            //坐标改变 进行图像重绘
            public void onAnimationUpdate(ValueAnimator animation) {
                mPointF = (Point) animation.getAnimatedValue();
                invalidate();
            }
        });
        //背景色渐变动画
        ObjectAnimator anim2 = ObjectAnimator.ofObject(mPaint, "color", new ArgbEvaluator(), Color.BLUE, Color.RED);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(anim).with(anim2);
        animSet.setDuration(5000);
        animSet.start();

    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        startAnimation();
    }

}