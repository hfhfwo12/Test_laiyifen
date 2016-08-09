package com.example.administrator.test_laiyifen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/7/22.
 */
public class ContactsFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle saveInstanceState ) {
        View constactslayout=inflater.inflate(R.layout.contacts_layout,container,false);
        return constactslayout;
    }
}
