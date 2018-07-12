package net.jspiner.cherrypick.ui.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import io.reactivex.subjects.BehaviorSubject;

public abstract class BaseActivity<B extends ViewDataBinding, P extends BasePresenterInterface> extends AppCompatActivity {

    protected P presenter;
    protected B binding;

    private BehaviorSubject disposeSubject = BehaviorSubject.create();

    @LayoutRes
    protected abstract int getLayoutId();

    protected abstract P createPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());

        presenter = createPresenter();
        presenter.attachView();
    }

    @Override
    public void setContentView(int layoutResID) {
        View view = LayoutInflater.from(this).inflate(layoutResID, null);
        binding = DataBindingUtil.bind(view);
        super.setContentView(view);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
        disposeSubject.onComplete();
    }

    protected void setStatusBarColor(@ColorInt int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }
    }

    protected void setStatusBarLight() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = binding.getRoot().getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            binding.getRoot().setSystemUiVisibility(flags);
            getWindow().setStatusBarColor(Color.WHITE);
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

}
