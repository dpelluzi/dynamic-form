package com.dpelluzi.dynamicform.view;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dpelluzi.dynamicform.R;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private static final int NUM_SECTION = 2;
    private static final int SECTION_FUND = 0;
    private static final int SECTION_FORM = 1;

    private String mTitleForm;
    private String mTitleFund;

    public SectionsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mTitleForm = context.getString(R.string.title_contact);
        mTitleFund = context.getString(R.string.title_investment);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == SECTION_FORM) {
            return FormFragment.newInstance();
        }

        return new Fragment(); // TODO replace with correct fragment
    }

    @Override
    public int getCount() {
        return NUM_SECTION;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        final String title;
        switch (position) {
            case SECTION_FUND:
                title =  mTitleFund;
                break;
            case SECTION_FORM:
                title = mTitleForm;
                break;
            default:
                title = null;
        }
        return title;
    }
}
