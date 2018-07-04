package net.jspiner.cherrypick.ui.splash;

import net.jspiner.cherrypick.R;
import net.jspiner.cherrypick.databinding.ActivitySplashBinding;
import net.jspiner.cherrypick.ui.base.BaseActivity;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, Contract.Presenter>
        implements Contract.View {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected Contract.Presenter createPresenter() {
        return new SplashPresenter(this);
    }
}
