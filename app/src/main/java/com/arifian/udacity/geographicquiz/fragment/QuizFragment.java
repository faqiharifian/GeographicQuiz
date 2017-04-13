package com.arifian.udacity.geographicquiz.fragment;


import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.arifian.udacity.geographicquiz.R;
import com.arifian.udacity.geographicquiz.entities.Province;
import com.arifian.udacity.geographicquiz.entities.Question;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuizFragment extends Fragment {
    public static final String KEY_QUESTION = "question";
    Province province;
    Question question;

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
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        question = (Question) getArguments().getSerializable(KEY_QUESTION);
        province = question.getProvince();
        String[] options = question.getOptions();
        Drawable drawable;
        if(Build.VERSION.SDK_INT >= 21){
            drawable = getActivity().getDrawable(province.getImage());
        }else{
            drawable = getActivity().getResources().getDrawable(province.getImage());
        }
        String question = "";
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.options_framelayout);
        switch (this.question.getType()){
            case 0:{
                question = getActivity().getString(R.string.question_1);
                View answerView = inflater.inflate(R.layout.answer_checkbox, frameLayout, true);
                ((CheckBox) answerView.findViewById(R.id.island_checkbox)).setText(options[0]);
                ((CheckBox) answerView.findViewById(R.id.province_checkbox)).setText(options[1]);
                ((CheckBox) answerView.findViewById(R.id.capital_checkbox)).setText(options[2]);
                break;
            }
            case 1: {
                question = getActivity().getString(R.string.question_2);
                View answerView = inflater.inflate(R.layout.answer_radio, frameLayout, true);
                ((RadioButton) answerView.findViewById(R.id.a_radiobutton)).setText(options[0]);
                ((RadioButton) answerView.findViewById(R.id.b_radiobutton)).setText(options[1]);
                ((RadioButton) answerView.findViewById(R.id.c_radiobutton)).setText(options[2]);
                break;
            }
            case 2: {
                question = getActivity().getString(R.string.question_3);
                View answerView = inflater.inflate(R.layout.answer_radio, frameLayout, true);
                ((RadioButton) answerView.findViewById(R.id.a_radiobutton)).setText(options[0]);
                ((RadioButton) answerView.findViewById(R.id.b_radiobutton)).setText(options[1]);
                ((RadioButton) answerView.findViewById(R.id.c_radiobutton)).setText(options[2]);
                break;
            }
        }
        ((TextView)view.findViewById(R.id.question_textview)).setText(question);
        ((ImageView) view.findViewById(R.id.province_imageview)).setImageDrawable(drawable);
        return view;
    }

    public Question getQuestion(){
        return question;
    }
}
