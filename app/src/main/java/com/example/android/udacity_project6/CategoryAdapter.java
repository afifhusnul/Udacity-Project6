package com.example.android.udacity_project6;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by NUSNAFIF on 10/13/2016.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    /**
     * Context of the app
     */
    private Context mContext;

    public CategoryAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param context is the context of the app
     * @param fm      is the fragment manager that will keep each fragment's state in the adapter
     *                across swipes.
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new CityFragment();
        } else if (position == 1) {
            return new HospitalityFragment();
        } else if (position == 2) {
            return new AdventureFragment();
        } else {
            return new FoodFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_city);
        } else if (position == 1) {
            return mContext.getString(R.string.category_hostpitality);
        } else if (position == 2) {
            return mContext.getString(R.string.category_adventure);
        } else {
            return mContext.getString(R.string.category_food);
        }
    }
}
