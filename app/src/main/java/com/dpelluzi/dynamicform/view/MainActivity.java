package com.dpelluzi.dynamicform.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.dpelluzi.dynamicform.R;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.title_investment), true);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.title_contact));
        tabLayout.addOnTabSelectedListener(this);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, InvestmentFragment.newInstance(), "Content")
                .commit();
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        Fragment fragment;
        if (tab.getPosition() == 0) {
            fragment = InvestmentFragment.newInstance();
        } else {
            fragment = FormFragment.newInstance();
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment, "Content")
                .commit();
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
    }

}
