package com.example.user.uniapp.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.user.uniapp.Fragments.AnimalsFragment;
import com.example.user.uniapp.Fragments.ColorsFragment;
import com.example.user.uniapp.Fragments.FoodFragment;
import com.example.user.uniapp.Fragments.NumbersFragment;
import com.example.user.uniapp.Fragments.RandomFragment;
import com.example.user.uniapp.R;

public class ProfessorTabAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public ProfessorTabAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new AnimalsFragment();
        }else if(position == 1){
            return new ColorsFragment();
        } else if (position == 2) {
            return new NumbersFragment();
        }else if(position==3){
            return new FoodFragment();
        }else {
            return new RandomFragment();
        }

    }


    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return mContext.getString(R.string.pets);
            case 1:
                return mContext.getString(R.string.colors);
            case 2:
                return mContext.getString(R.string.numbers);
            case 3:
                return mContext.getString(R.string.food);
            default:
                return mContext.getString(R.string.random);
        }

    }

}
