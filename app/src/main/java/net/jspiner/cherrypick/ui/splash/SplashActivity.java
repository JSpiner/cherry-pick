package net.jspiner.cherrypick.ui.splash;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;

import net.jspiner.cherrypick.R;
import net.jspiner.cherrypick.databinding.ActivitySplashBinding;
import net.jspiner.cherrypick.ui.base.BaseActivity;
import net.jspiner.cherrypick.ui.main.MainActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setStatusBarColor(Color.BLACK);
        Completable.timer(1000 * 2, TimeUnit.MILLISECONDS)
                .subscribe(() -> {
                    MainActivity.startActivity(this);
                    finish();
                });
    }
}
