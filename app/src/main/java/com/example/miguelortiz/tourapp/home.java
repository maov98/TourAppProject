package com.example.miguelortiz.tourapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class home extends AppCompatActivity {

    private SectionPageAdaptor mSectionPageAdaptor;
    private ViewPager mviewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mviewPager = (ViewPager) findViewById(R.id.pager);
        mviewPager.setAdapter(new SectionPageAdaptor(getSupportFragmentManager(),this));
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mviewPager);

    }
}
