package com.example.administrator.test_laiyifen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/7/22.
 */
public class NewsFragment extends Fragment{
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View newslayout=inflater.inflate(R.layout.news_layout,container,false);
        return newslayout;
    }
}
