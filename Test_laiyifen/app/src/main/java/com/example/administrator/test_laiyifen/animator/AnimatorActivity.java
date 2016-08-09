package com.example.administrator.test_laiyifen.animator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.administrator.test_laiyifen.R;

/**
 * Created by Administrator on 2016/7/25.
 */
public class AnimatorActivity extends Activity {
    private TextView  text_test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.animator_test);
        text_test=(TextView)findViewById(R.id.id_text);
    }
            public void alphaRun(View v){
                ObjectAnimator animator = ObjectAnimator.ofFloat(text_test, "alpha", 1f, 0f, 1f);
                animator.setDuration(5000);
                animator.start();
            }
            public void rotation(View v){
                ObjectAnimator animator = ObjectAnimator.ofFloat(text_test, "rotation", 0f, 360f);
                animator.setDuration(5000);
                animator.start();
            }
            public void translation(View v){
                float curTranslationX = text_test.getTranslationX();
                ObjectAnimator animator = ObjectAnimator.ofFloat(text_test, "translationX", curTranslationX, -500f, curTranslationX);
                animator.setDuration(5000);
                animator.start();
            }
           public void scale(View v){
                ObjectAnimator animator = ObjectAnimator.ofFloat(text_test, "scaleY", 1f, 3f, 1f);
                animator.setDuration(5000);
                animator.start();
               /* animator.addListener(new AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                // 动画开始时调用
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                // 动画重复时调用
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                // 动画结束时调用

            }
            @Override
            public void onAnimationCancel(Animator animation) {
                // 动画取消时调用
            }
        });
        anim.start();

        anim.addListener(new AnimatorListenerAdapter() {  });
        */
           }
           public void animator(View v){
               ObjectAnimator moveIn = ObjectAnimator.ofFloat(text_test, "translationX", -500f, 0f);
               ObjectAnimator rotate = ObjectAnimator.ofFloat(text_test, "rotation", 0f, 360f);
               ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(text_test, "alpha", 1f, 0f, 1f);
               AnimatorSet animSet = new AnimatorSet();
               animSet.play(rotate).with(fadeInOut).after(moveIn);
               animSet.setDuration(5000);
               animSet.start();
              /* Animator animator = AnimatorInflater.loadAnimator(this, R.animator.animator_test);
               animator.setTarget(text_test);
               animator.start();*/

               /*  PropertyValuesHolder
         int left = view.getLeft();
        // 获取view右边位置
        int right = view.getRight();
        // 将view左边增加10像素
        PropertyValuesHolder pvhLeft = PropertyValuesHolder.ofInt("left", left,
                left + 10);
        // 将view右边减少10像素
        PropertyValuesHolder pvhRight = PropertyValuesHolder.ofInt("right",
                right, right - 10);
        // 在X轴缩放从原始比例1f,缩小到最小0f,再放大到原始比例1f
        PropertyValuesHolder pvhScaleX = PropertyValuesHolder.ofFloat("scaleX",
                1f, 0f, 1f);
        // 在Y轴缩放从原始比例1f,缩小到最小0f,再放大到原始比例1f
        PropertyValuesHolder pvhScaleY = PropertyValuesHolder.ofFloat("scaleY",
                1f, 0f, 1f);
        // 将PropertyValuesHolder交付给ObjectAnimator进行构建
        ObjectAnimator customAnim = ObjectAnimator.ofPropertyValuesHolder(view,
                pvhLeft, pvhRight, pvhScaleX, pvhScaleY);
        // 设置执行时间(1000ms)
        customAnim.setDuration(1000);
        // 开始动画
        customAnim.start();*/

               /*Keyframe
        // 设置在动画开始时,旋转角度为0度
        Keyframe kf0 = Keyframe.ofFloat(0f, 0f);
        // 设置在动画执行50%时,旋转角度为360度
        Keyframe kf1 = Keyframe.ofFloat(.5f, 360f);
        // 设置在动画结束时,旋转角度为0度
        Keyframe kf2 = Keyframe.ofFloat(1f, 0f);
        // 使用PropertyValuesHolder进行属性名称和值集合的封装
        PropertyValuesHolder pvhRotation = PropertyValuesHolder.ofKeyframe(
                "rotation", kf0, kf1, kf2);
        // 通过ObjectAnimator进行执行
        ObjectAnimator.ofPropertyValuesHolder(view, pvhRotation)
        // 设置执行时间(1000ms)
                .setDuration(1000)
                // 开始动画
                .start();
                */

           }



}
