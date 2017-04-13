package com.arifian.udacity.whatsitscapitalname.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.arifian.udacity.whatsitscapitalname.entities.Province;
import com.arifian.udacity.whatsitscapitalname.fragment.QuizFragment;

import java.util.ArrayList;

/**
 * Created by faqih on 13/04/17.
 */

public class QuizFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
    // Sparse array to keep track of registered fragments in memory
    private SparseArray<Fragment> registeredFragments = new SparseArray<>();
    ArrayList<Province> provinces;

    public QuizFragmentStatePagerAdapter(ArrayList<Province> provinces, FragmentManager fm) {
        super(fm);
        this.provinces = provinces;
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
        args.putSerializable(QuizFragment.KEY_PROVINCE, provinces.get(position));
        args.putInt(QuizFragment.KEY_QUESTION, position % 3);
        Fragment fragment = new QuizFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public int getCount() {
        return provinces.size();
    }
}
