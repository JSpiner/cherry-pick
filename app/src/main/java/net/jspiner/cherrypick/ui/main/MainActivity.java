package net.jspiner.cherrypick.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;

import net.jspiner.cherrypick.R;
import net.jspiner.cherrypick.databinding.ActivityMainBinding;
import net.jspiner.cherrypick.ui.base.BaseActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding, Contract.Presenter>
        implements Contract.View {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected Contract.Presenter createPresenter() {
        return null;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
