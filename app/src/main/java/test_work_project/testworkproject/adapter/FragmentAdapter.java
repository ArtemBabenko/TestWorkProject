package test_work_project.testworkproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import test_work_project.testworkproject.fragment.ChatFragment;
import test_work_project.testworkproject.fragment.LiveChatFragment;

public class FragmentAdapter extends FragmentPagerAdapter {

    private String[] tabs;

    public FragmentAdapter(FragmentManager fm, String[] tabs) {
        super(fm);

        this.tabs = tabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return ChatFragment.getInstance();
            case 1:
                return LiveChatFragment.getInstance();
        }

        return null;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

}
