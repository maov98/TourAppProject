package com.example.miguelortiz.tourapp;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class SectionPageAdaptor extends FragmentPagerAdapter {

    private List<Fragment> mFragmentList = new ArrayList<>();
    private List<String> mFragmentTitleList = new ArrayList<>();
    private Context context;
    private String ltab1;
    private String ltab2;
    private String ltab3;
    private String ltab4;

    public SectionPageAdaptor(FragmentManager fragmentPagerAdapter, Context lContext){

        super(fragmentPagerAdapter);
        context = lContext;
        ltab1 = context.getString(R.string.tab1);
        ltab2 = context.getString(R.string.tab2);
        ltab3 = context.getString(R.string.tab3);
        ltab4 = context.getString(R.string.tab4);
    }

    public void addFragment(Fragment fragment, String title){


        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }



    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new PlacesFragment();

            case 1:
                return new RestaurantFragment();

            case 2:
                return new HotelsFragment();

            case 3:
                return new EventFragment();

            default:

                return null;
        }
    }

    @Override
    public int getCount() {

        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position){

        switch (position) {
            case 0:
                return ltab1;

            case 1:
                return ltab2;

            case 2:
                return ltab3;

            case 3:
                return ltab4;
        }

        return null;

    }

}
