package com.example.administrator.test_laiyifen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.tf_2);
        textView.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v){
               Intent intent=new Intent(MainActivity.this,SecondActivity.class);
               startActivity(intent);
           }
       });
    }
}
