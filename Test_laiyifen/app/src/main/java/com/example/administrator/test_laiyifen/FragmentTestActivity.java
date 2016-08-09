package com.example.administrator.test_laiyifen;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;



/**
 * Created by Administrator on 2016/7/22.
 */
public class FragmentTestActivity extends FragmentActivity implements View.OnClickListener {
    private MessageFragment messageFragment;
    private ContactsFragment contactsFragment;
    private NewsFragment newsFragment;
    private SettingFragemnt settingFragemnt;
    private  View messagelayout;
    private  View contactslayout;
    private View  newslayout;
    private View settinglayout;
    private ImageView messageImage;
    private ImageView contactsImage;
    private ImageView newsImage;
    private ImageView settingImage;
    private TextView messageText;
    private TextView contactsText;
    private TextView newsText;
    private TextView settingText;
    private FragmentManager fragmentManager;
    @Override
    protected void  onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fragment_main);
        fragmentManager=getSupportFragmentManager();
        setTabSelection(0);
        initViews();
    }
    private void initViews(){
        messagelayout=findViewById(R.id.message_layout);
        contactslayout=findViewById(R.id.contacts_layout);
        newslayout=findViewById(R.id.news_layout);
        settinglayout=findViewById(R.id.setting_layout);
        messageImage=(ImageView) findViewById(R.id.message_image);
        contactsImage=(ImageView)findViewById(R.id.contacts_image);
        newsImage=(ImageView)findViewById(R.id.news_image);
        settingImage=(ImageView)findViewById(R.id.setting_image);
        messageText=(TextView)findViewById(R.id.message_text);
        contactsText=(TextView)findViewById(R.id.contacts_text);
        newsText=(TextView)findViewById( R.id.news_text);
        settingText=(TextView)findViewById(R.id.setting_text);
        messagelayout.setOnClickListener(this);
        contactslayout.setOnClickListener(this);
        newslayout.setOnClickListener(this);
        settinglayout.setOnClickListener(this);
    }
    @Override
    public  void onClick(View v){
        switch (v.getId()){
            case R.id.message_layout:
                setTabSelection(0);
                break;
            case R.id.contacts_layout:
                setTabSelection(1);
                break;
            case R.id.news_layout:
                setTabSelection(2);
                break;
            case R.id.setting_layout:
                setTabSelection(3);
                break;
            default:
                break;
        }
    }
    private void setTabSelection(int index){
        clearSelection();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index){
            case 0:
                messageImage.setImageResource(R.drawable.ic_launcher);
                messageText.setTextColor(Color.BLACK);
                if(messageFragment==null){
                    messageFragment=new MessageFragment();
                    transaction.add(R.id.content,messageFragment);
                }else{
                    transaction.show(messageFragment);
                }
                break;
            case 1:

                contactsImage.setImageResource(R.drawable.ic_launcher);
                contactsText.setTextColor(Color.BLACK);
                if (contactsFragment == null) {

                    contactsFragment = new ContactsFragment();
                    transaction.add(R.id.content, contactsFragment);
                } else {

                    transaction.show(contactsFragment);
                }
                break;
            case 2:

                newsImage.setImageResource(R.drawable.ic_launcher);
                newsText.setTextColor(Color.BLACK);
                if (newsFragment == null) {

                    newsFragment = new NewsFragment();
                    transaction.add(R.id.content, newsFragment);
                } else {

                    transaction.show(newsFragment);
                }
                break;
            case 3:
                settingImage.setImageResource(R.drawable.ic_launcher);
                settingText.setTextColor(Color.BLACK);
                if (settingFragemnt == null) {

                    settingFragemnt = new SettingFragemnt();
                    transaction.add(R.id.content, settingFragemnt);
                } else {

                    transaction.show(settingFragemnt);
                }
                break;
        }
        transaction.commit();

    }
    private void clearSelection(){
        messageImage.setImageResource(R.drawable.menu_top_right);
        messageText.setTextColor(Color.parseColor("#fff"));
        contactsImage.setImageResource(R.drawable.menu_top_right);
        contactsText.setTextColor(Color.parseColor("#fff"));
        newsImage.setImageResource(R.drawable.menu_top_right);
        newsText.setTextColor(Color.parseColor("#fff"));
        settingImage.setImageResource(R.drawable.menu_top_right);
        settingText.setTextColor(Color.parseColor("#fff"));
    }
    private void hideFragments(FragmentTransaction transaction){
        if(messageFragment!=null){
            transaction.hide(messageFragment);
        }
        if (contactsFragment!=null){
            transaction.hide(contactsFragment);
        }
        if (newsFragment!=null){
            transaction.hide(newsFragment);
        }
        if (settingFragemnt!=null){
            transaction.hide(settingFragemnt);
        }
    }
}
