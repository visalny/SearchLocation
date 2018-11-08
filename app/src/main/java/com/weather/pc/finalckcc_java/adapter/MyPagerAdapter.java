package com.weather.pc.finalckcc_java.adapter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.widget.TableLayout;

import com.weather.pc.finalckcc_java.entity.MyTab;

import java.util.ArrayList;
import java.util.List;

public class MyPagerAdapter extends FragmentPagerAdapter {
    private List<MyTab> tabList;
    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
        tabList=new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return tabList.get(position).getFragment();
    }

    //add tab to tablist
    public void addTab(MyTab tab){
        tabList.add(tab);
    }

    @Override
    public int getCount() {
        return tabList.size();
    }

    public void setIcon(TabLayout tabLayout) {
        for(int i=0;i<tabLayout.getTabCount();i++){
            tabLayout.getTabAt(i).setIcon(tabList.get(i).getIcon());
        }
    }
}
