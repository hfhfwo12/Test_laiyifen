package com.example.administrator.test_laiyifen;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.test_laiyifen.animator.AnimatorActivity;
import com.example.administrator.test_laiyifen.animator.CircleProgress;
import com.example.administrator.test_laiyifen.animator.EffectAni;
import com.example.administrator.test_laiyifen.animator.LayoutAnimaActivity;
import com.example.administrator.test_laiyifen.animator.Valueanimator_test;
import com.example.administrator.test_laiyifen.animator.XBallsFallActivity;
import com.example.administrator.test_laiyifen.animator.animator_ziyou;

import java.io.IOException;

public class SecondActivity extends Activity {
    private static final String TAG = "SecondActivity";

    private EditText urlPath ;
    private Button button ;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private ImageView imageView ;
    public void send(){
        String urlPathContent = urlPath.getText().toString();
        try {
            byte[] data = ImageService.getImage(urlPathContent);
            Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);  //生成位图
            Looper.prepare();
            Message msg =new Message();
            msg.what = 0;
            handler.sendMessage(msg);
            msg.obj=bitmap;
             //显示图片
        } catch (IOException e) {
            Toast.makeText(SecondActivity.this, R.string.error, Toast.LENGTH_LONG).show();  //通知用户连接超时信息
            Log.i(TAG, e.toString());
        }
    }
     Handler handler=new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                imageView.setImageBitmap((Bitmap)msg.obj);
            }
        }

    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acctivity_second);

        urlPath = (EditText)findViewById(R.id.urlpath);
        button = (Button)findViewById(R.id.button);
        imageView = (ImageView)findViewById(R.id.imageView);
        button1=(Button)findViewById(R.id.button1) ;
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4) ;
        button5=(Button)findViewById(R.id.button5) ;
        button6=(Button)findViewById(R.id.button6) ;
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SecondActivity.this,XBallsFallActivity.class);
                startActivity(intent);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SecondActivity.this,CircleProgress.class);
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SecondActivity.this,AnimatorActivity.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(SecondActivity.this,EffectAni.class);
                startActivity(intent2);
            }
        }
        );
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(SecondActivity.this,animator_ziyou.class);
                startActivity(intent3);
            }
        }
        );
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                    Intent intent1=new Intent(SecondActivity.this,LayoutAnimaActivity.class);
                    startActivity(intent1);
                }
            }
        );
       /* button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        send();
                    }
                }).start();
            }
        });*/
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
           Intent intent1=new Intent(SecondActivity.this,Valueanimator_test.class);
           startActivity(intent1);
            }
        }
        );

    }
}