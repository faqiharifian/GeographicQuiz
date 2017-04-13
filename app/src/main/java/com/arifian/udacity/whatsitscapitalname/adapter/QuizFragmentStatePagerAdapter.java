package com.arifian.udacity.whatsitscapitalname.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.arifian.udacity.whatsitscapitalname.entities.Province;
import com.arifian.udacity.whatsitscapitalname.entities.Question;
import com.arifian.udacity.whatsitscapitalname.fragment.QuizFragment;

import java.util.ArrayList;
import java.util.Random;

import static com.arifian.udacity.whatsitscapitalname.fragment.QuizFragment.KEY_QUESTION;

/**
 * Created by faqih on 13/04/17.
 */

public class QuizFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
    // Sparse array to keep track of registered fragments in memory
    private SparseArray<Fragment> registeredFragments = new SparseArray<>();
    ArrayList<Province> provinces;
    Question[] questions;

    public QuizFragmentStatePagerAdapter(ArrayList<Province> provinces, FragmentManager fm) {
        super(fm);
        this.provinces = provinces;
        questions = new Question[getCount()];

        initiateQuestions();
    }

    // Register the fragment when the item is instantiated
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    // Unregister when the item is inactive
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    // Returns the fragment for the position (if instantiated)
    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }

    // Initiate fragment and pass province to it
    @Override
    public Fragment getItem(int position) {
        Bundle args = new Bundle();
        args.putSerializable(KEY_QUESTION, questions[position]);
        Fragment fragment = new QuizFragment();
        fragment.setArguments(args);

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
            provinces.remove(indexProvince);

            // Generate type of question
            int type = randomGenerator.nextInt(3);
            String[] options = new String[3];
            int[] answers = new int[3];

            // Generate true answer
            int indexTrue = randomGenerator.nextInt(3);
            answers[indexTrue] = 1;
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
            for(int j = 0; j < options.length; j++){
                if(options[j] == null){
                    switch(type){
                        case 0:
                            if(randomGenerator.nextInt(10) < trueProbability){
                                answers[j] = 1;
                                options = setCheckBoxOption(options, j, province);
                            }else{
                                answers[j] = 0;
                                options = setCheckBoxOption(options, j, getRandomProvince());
                            }
                            trueProbability -= 2;
                            break;
                        case 1:
                            options[j] = getRandomProvince().getProvinceName();
                            break;
                        case 2:
                            options[j] = getRandomProvince().getCapitalName();
                            break;
                    }
                }
            }

            // answers converted to string with "," as delimeter
            String answer = "";
            for(int j = 0; j < answers.length; j++){
                answer += answers[j];
                if(j != answers.length-1){
                    answer += ",";
                }
            }
            Log.e("answer", answer);
            questions[i] = new Question(type, answer, options, province);
        }
    }

    private Province getRandomProvince(){
        int index = (new Random()).nextInt(provinces.size());
        return provinces.get(index);
    }

    private String[] setCheckBoxOption(String[] options, int index, Province province){
        switch (index){
            case 0:
                options[index] = province.getIslandName()+" island.";
                break;
            case 1:
                options[index] = "Province of "+province.getProvinceName();
                break;
            case 2:
                options[index] = "The provincial capital is "+province.getCapitalName();
                break;
        }
        return options;
    }
}
