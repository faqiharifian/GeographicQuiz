package com.arifian.udacity.geographicquiz.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.arifian.udacity.geographicquiz.R;
import com.arifian.udacity.geographicquiz.entities.Province;
import com.arifian.udacity.geographicquiz.entities.Question;
import com.arifian.udacity.geographicquiz.fragment.QuizFragment;

import java.util.ArrayList;
import java.util.Random;

import static com.arifian.udacity.geographicquiz.fragment.QuizFragment.KEY_QUESTION;

/**
 * Created by faqih on 13/04/17.
 */

public class QuizFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
    ArrayList<Province> provinces;
    Question[] questions;
    Fragment[] fragments;
    Context context;

    public QuizFragmentStatePagerAdapter(Context context, ArrayList<Province> provinces, FragmentManager fm) {
        super(fm);
        this.context = context;
        this.provinces = provinces;
        questions = new Question[getCount()];
        fragments = new Fragment[getCount()];

        initiateQuestions();
    }

    // Returns the fragment for the position
    public Fragment getFragment(int position) {
        return fragments[position];
    }

    // Initiate fragment and pass province to it
    @Override
    public Fragment getItem(int position) {
        Bundle args = new Bundle();
        args.putSerializable(KEY_QUESTION, questions[position]);
        Fragment fragment = new QuizFragment();
        fragment.setArguments(args);
        fragments[position] = fragment;
        return fragment;
    }

    @Override
    public int getCount() {
        return 10;
    }

    private void initiateQuestions() {
        for(int i = 0; i < getCount(); i++){
            Random randomGenerator = new Random();

            int indexProvince = randomGenerator.nextInt(provinces.size());
            Province province = provinces.get(indexProvince);

            // Generate type of question
            int type = randomGenerator.nextInt(4);
            String[] options = new String[3];
            boolean[] answers = new boolean[3];

            // Generate true answer
            int indexTrue = randomGenerator.nextInt(3);
            answers[indexTrue] = true;
            switch(type){
                case 0:
                    options = setCheckBoxOption(options, indexTrue, province);
                    break;
                case 1:
                    options[indexTrue] = province.getProvinceName();
                    break;
                case 2:
                    options[indexTrue] = province.getCapitalName();
                    break;
            }

            // Generate remaining options
            // for type question 0 the options is 1 answer is 100% true, 1 answer is 70% true and 1 answer is 50% true
            // other type is 100% true an the rest is false
            int trueProbability = 7;
            int secondIndex = -1;
            for(int j = 0; j < options.length; j++){
                if(options[j] == null){
                    answers[j] = false;

                    // Generate unique province to remaining options
                    Province optionProvince;
                    int index;
                    if(secondIndex != -1){
                        do{
                            index = (new Random()).nextInt(provinces.size());
                        }while(index == indexProvince || index == secondIndex);
                    }else{
                        do{
                            index = (new Random()).nextInt(provinces.size());
                        }while(index == indexProvince);
                        secondIndex = index;
                    }
                    optionProvince = provinces.get(index);

                    switch(type){
                        case 0:
                            if(randomGenerator.nextInt(10) < trueProbability){
                                answers[j] = true;
                                options = setCheckBoxOption(options, j, province);
                            }else{
                                options = setCheckBoxOption(options, j, optionProvince);
                            }
                            trueProbability -= 2;
                            break;
                        case 1:
                            options[j] = optionProvince.getProvinceName();
                            break;
                        case 2:
                            options[j] = optionProvince.getCapitalName();
                            break;
                    }
                }
            }

            // answers converted to string with "," as delimeter
            String answer = "";
            if(type == 3){
                answer = province.getIslandName();
            }else {
                for (int j = 0; j < answers.length; j++) {
                    answer += answers[j] + ",";
                }
            }
            Log.e("answer", i+" - "+answer);
            questions[i] = new Question(type, answer, options, province);
        }
    }

    private String[] setCheckBoxOption(String[] options, int index, Province province){
        switch (index){
            case 0:
                options[index] = context.getString(R.string.question_1_option_1, province.getIslandName());
                break;
            case 1:
                options[index] = context.getString(R.string.question_1_option_2, province.getProvinceName());
                break;
            case 2:
                options[index] = context.getString(R.string.question_1_option_3, province.getCapitalName());
                break;
        }
        return options;
    }
}
