package net.jspiner.cherrypick.ui.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import net.jspiner.cherrypick.R;
import net.jspiner.cherrypick.databinding.ActivityMainBinding;
import net.jspiner.cherrypick.ui.base.BaseActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding, Contract.Presenter>
        implements Contract.View {

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected Contract.Presenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
    }

    private void init() {
        initViews();
    }

    private void initViews() {
        initStatusBar();
        initPager();
        initBottomNavigation();
    }

    private void initStatusBar() {
        setStatusBarColor(Color.WHITE);
        setStatusBarLight();
    }

    private void initPager() {
        binding.pager.setAdapter(
                new MainPagerAdapter(getSupportFragmentManager())
        );
        binding.pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                binding.bottomNavigation
                        .getMenu()
                        .getItem(position)
                        .setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initBottomNavigation() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()) {
                        case R.id.action_one:
                            binding.pager.setCurrentItem(0);
                            break;
                        case R.id.action_two:
                            binding.pager.setCurrentItem(1);
                            break;
                        case R.id.action_three:
                            binding.pager.setCurrentItem(2);
                            break;
                    }
                    return true;
                }
        );
    }
}
