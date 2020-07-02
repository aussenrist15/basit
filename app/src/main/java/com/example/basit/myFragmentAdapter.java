package com.example.basit;

import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class myFragmentAdapter extends FragmentPagerAdapter {

    public myFragmentAdapter(@NonNull  FragmentManager fm , int bahavior) {
        super(fm, bahavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0) {
            return new NumbersFragment();
        } else if(position==1) {
            return new ColorsFragment();
        } else if(position==2){
            return new FamilyFragment();
        } else {
            return new PhrasesFragment();
        }

    }

    @Override
    public int getCount() {
        return 4;
    }
    @Override
    public Parcelable saveState() {
        // Do Nothing
        return null;
    }
}
