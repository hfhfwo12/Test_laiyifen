package com.example.administrator.test_laiyifen.animator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.test_laiyifen.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/7/26.
 */

public class EffectAni extends AppCompatActivity implements View.OnClickListener {
    // ImageView组件id数组
    private int[] mRes = new int[]{R.id.iv_a, R.id.iv_b, R.id.iv_c, R.id.iv_d, R.id.iv_e};
    // ImageView对象集合
    private ArrayList<ImageView> mImViews = new ArrayList<>();
    private boolean flag = true;// 启动动画、关闭动画的标记位
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_effect);
        // for循环创建ImageView对象，并添加到集合中
        for (int i = 0; i < mRes.length; i++) {
            ImageView iv_a = (ImageView) findViewById(mRes[i]);
            iv_a.setOnClickListener(this);
            mImViews.add(iv_a);
        }
    }

    // 按钮点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_a:
                if (flag) {
                    startAnim();
                } else {
                    closeAnim();
                }
                break;
            default:
                Toast.makeText(EffectAni.this, "" + v.getId(), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    // 关闭动画
    private void closeAnim() {
        // 创建ObjectAnimator属性对象，参数分别是动画要设置的View对象、动画属性、属性值
        ObjectAnimator animator0 = ObjectAnimator.ofFloat(mImViews.get(0),
                "alpha",
                0.5F,
                1F);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mImViews.get(1),
                "translationY",
                200F,
                0);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mImViews.get(2),
                "translationX",
                200F,
                0);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mImViews.get(3),
                "translationY",
                -200F,
                0);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(mImViews.get(4),
                "translationX",
                -200F,
                0);
        AnimatorSet aniSet = new AnimatorSet();
        aniSet.setDuration(4000);
        aniSet.setInterpolator(new BounceInterpolator());// 弹跳效果的插值器
        aniSet.playTogether(animator0,
                animator1,
                animator2,
                animator3,
                animator4);// 同时启动5个动画
        aniSet.start();

        // 重置标记位
        flag = true;
    }

    // 启动动画
    private void startAnim() {
        // 创建ObjectAnimator属性对象，参数分别是动画要设置的View对象、动画属性、属性值
        ObjectAnimator animator0 = ObjectAnimator.ofFloat(
                mImViews.get(0), "alpha", 1f, 0.5f);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(
                mImViews.get(1),
                "translationY",
                200f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(
                mImViews.get(2),
                "translationX",
                200f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(
                mImViews.get(3),
                "translationY",
                -200f);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(
                mImViews.get(4),
                "translationX",
                -200f);
        AnimatorSet aniSet = new AnimatorSet();
        aniSet.setDuration(4000);
        aniSet.setInterpolator(new BounceInterpolator());// 弹跳效果的插值器
        aniSet.playTogether(animator0,
                animator1,
                animator2,
                animator3,
                animator4);// 同时启动5个动画
        aniSet.start();

        // 重置标记位
        flag = false;
    }
}