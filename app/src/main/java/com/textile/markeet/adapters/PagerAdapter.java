package com.textile.markeet.adapters;


import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.textile.markeet.views.fragments.ExpiryAdsFragment;
import com.textile.markeet.views.fragments.LatestAdsFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    Context mcontext;

    public PagerAdapter(Context context,   FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.mcontext = context;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                LatestAdsFragment tab1 = new LatestAdsFragment(mcontext);
                return tab1;
            case 1:
                ExpiryAdsFragment tab2 = new ExpiryAdsFragment(mcontext);
                return tab2;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}