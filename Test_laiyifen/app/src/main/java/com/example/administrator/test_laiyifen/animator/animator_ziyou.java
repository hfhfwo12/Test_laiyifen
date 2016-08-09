package com.example.administrator.test_laiyifen.animator;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.example.administrator.test_laiyifen.R;

/**
 * Created by Administrator on 2016/7/26.
 */
public class animator_ziyou  extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animator_ziyou);
        imageView=(ImageView)findViewById(R.id.id_ball);

    }
    public void verticalRun( View view) {
        ValueAnimator animator = ValueAnimator.ofFloat(0, 600f);
        animator.setTarget(imageView);
        animator.setDuration(1000).start();

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                imageView.setTranslationY((Float) animation.getAnimatedValue());
            }
        });
    }
    public void paowuxian(View view)
    {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(3000);
        valueAnimator.setObjectValues(new PointF(0, 0));
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setEvaluator(new TypeEvaluator<PointF>()
        {
            @Override
            public PointF evaluate(float fraction, PointF startValue, PointF endValue)
            {
                PointF point = new PointF();
                point.x = 200 * fraction * 3;
                point.y = 0.5f * 200 * (fraction * 3) * (fraction * 3);
                return point;
            }
        });

        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                PointF point = (PointF) animation.getAnimatedValue();
                imageView.setX(point.x);
                imageView.setY(point.y);
            }
        });
    }
}
