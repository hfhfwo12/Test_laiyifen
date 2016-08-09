package com.example.administrator.test_laiyifen;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/30.
 */
public class MyList1 extends Activity {

    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private int[] mDrawableIds;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recyclerview);
        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.gridrecyclerview);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,4) );
        HomeAdapter mAdapter=new HomeAdapter();
        mRecyclerView.setAdapter(mAdapter);


    }

    protected void initData()
    {
        mDatas = new ArrayList<String>();
        for (int i = 1; i < 100; i++)
        {
            mDatas.add("食物名称" + i);
        }
        mDrawableIds = new int[99];
        for (int j=0;j<mDrawableIds.length;j++)
        {
            mDrawableIds[j]=R.drawable.ic_launcher;
        }
    }


    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>
    {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    MyList1.this).inflate(R.layout.vlist, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position)
        {
            holder.tv.setText(mDatas.get(position));
            holder.img_num.setBackgroundResource(mDrawableIds[position]);
        }

        @Override
        public int getItemCount()
        {
            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder
        {

            TextView tv;
            ImageView img_num;
            public MyViewHolder(View view)
            {
                super(view);
                tv = (TextView) view.findViewById(R.id.id_num);
                img_num=(ImageView)view.findViewById(R.id.img_num);
            }
        }
    }

}
