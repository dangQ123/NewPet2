package edu.njust.newpet2.bottombar.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import edu.njust.newpet2.bottombar.fragment.TabFirstFragment;
import edu.njust.newpet2.bottombar.fragment.TabSecondFragment;
import edu.njust.newpet2.bottombar.fragment.TabThirdFragment;


public class TabPagerAdapter extends FragmentPagerAdapter {
    public TabPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position==0){
            return new TabFirstFragment();
        }
        else if(position==1){
            return new TabSecondFragment();
        }
        else if (position==2){
            return new TabThirdFragment();
        }
        else {
            return null;
        }
    }
    @Override
    public int getCount() {
        return 3;
    }
}
