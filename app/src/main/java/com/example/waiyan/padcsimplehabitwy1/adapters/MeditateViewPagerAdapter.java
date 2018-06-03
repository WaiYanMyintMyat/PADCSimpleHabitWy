package com.example.waiyan.padcsimplehabitwy1.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.waiyan.padcsimplehabitwy1.fragments.MediFragOnTheGo;
import com.example.waiyan.padcsimplehabitwy1.fragments.MediFragSeries;
import com.example.waiyan.padcsimplehabitwy1.fragments.MediFragTeachers;


public class MeditateViewPagerAdapter extends FragmentStatePagerAdapter{
    public MeditateViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new MediFragOnTheGo();
            case 1: return new MediFragSeries();
            case 2: return new MediFragTeachers();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "On The Go";
            case 1: return "Series";
            case 2: return "Teachers";
        }
        return null;
    }
}
