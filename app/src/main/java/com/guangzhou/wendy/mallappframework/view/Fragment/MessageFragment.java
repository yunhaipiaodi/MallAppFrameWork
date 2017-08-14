package com.guangzhou.wendy.mallappframework.view.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guangzhou.wendy.mallappframework.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {


    public MessageFragment() {
        // Required empty public constructor
    }

    public static MessageFragment newInstance(){
        return new MessageFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

}
