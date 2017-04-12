package com.arifian.udacity.whatsitscapitalname.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arifian.udacity.whatsitscapitalname.R;
import com.arifian.udacity.whatsitscapitalname.entities.Province;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuizFragment extends Fragment {
    public static final String KEY = "province";
    Province province;

    public QuizFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Get province from argument and set it to text view
        province = (Province) getArguments().getSerializable(KEY);
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        ((TextView)view.findViewById(R.id.province_name_textview)).setText(province.getProvinceName());
        return view;
    }

}
