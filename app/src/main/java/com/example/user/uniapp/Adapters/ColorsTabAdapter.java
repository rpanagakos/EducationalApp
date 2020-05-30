package com.example.user.uniapp.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.user.uniapp.Fragments.ColorsQuizFragment;
import com.example.user.uniapp.Fragments.ColorsTheoryFragment;
import com.example.user.uniapp.R;

public class ColorsTabAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public ColorsTabAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new ColorsTheoryFragment();
        }else{
            return new ColorsQuizFragment();
        }

    }


    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return mContext.getString(R.string.theory);
            default:
                return mContext.getString(R.string.quiz);
        }

    }
}
