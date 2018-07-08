package net.jspiner.cherrypick.ui.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.reactivex.subjects.BehaviorSubject;

public abstract class BaseFragment<B extends ViewDataBinding, P extends BasePresenterInterface>  extends Fragment {

    protected P presenter;
    protected B binding;

    private BehaviorSubject disposeSubject = BehaviorSubject.create();

    @LayoutRes
    protected abstract int getLayoutId();

    protected abstract P createPresenter();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);

        presenter = createPresenter();
        presenter.attachView();

        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        presenter.detachView();
        disposeSubject.onComplete();
    }
}
