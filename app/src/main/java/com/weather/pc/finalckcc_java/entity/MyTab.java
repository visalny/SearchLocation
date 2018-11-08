package com.weather.pc.finalckcc_java.entity;

import android.support.v4.app.Fragment;

public class MyTab {
    private int icon;
    private Fragment fragment;

    public MyTab(int icon, Fragment fragment) {
        this.icon = icon;
        this.fragment = fragment;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
