package com.example.pagerbug;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int arg0) {
        return PageFragment.newInstance(arg0);
    }

    @Override
    public int getCount() {
        return 3;
    }
}