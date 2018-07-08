package net.jspiner.cherrypick.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import net.jspiner.cherrypick.ui.main.combine.CombineFragment;
import net.jspiner.cherrypick.ui.main.recipe.RecipeFragment;
import net.jspiner.cherrypick.ui.main.search.SearchFragment;

public class MainPagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_RECIPE = 0;
    private final int PAGE_COMBINE = 1;
    private final int PAGE_SEARCH = 2;

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case PAGE_RECIPE:
                return RecipeFragment.newInstance();
            case PAGE_COMBINE:
                return CombineFragment.newInstance();
            case PAGE_SEARCH:
                return SearchFragment.newInstance();
            default:
                throw new IllegalArgumentException("존재할 수 없는 position : " + position);
        }
    }

    @Override
    public int getCount() {
        return 0;
    }
}
