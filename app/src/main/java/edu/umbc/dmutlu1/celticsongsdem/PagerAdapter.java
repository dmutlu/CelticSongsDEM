package edu.umbc.dmutlu1.celticsongsdem;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter
{
       private int mNumOfTabs;


        public PagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return SongFragment.newInstance(R.raw.jig, R.drawable.jig);
                case 1:
                    return SongFragment.newInstance(R.raw.bagpipes, R.drawable.bagpipes);
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
}