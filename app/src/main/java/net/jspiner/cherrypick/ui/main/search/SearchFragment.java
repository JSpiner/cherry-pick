package net.jspiner.cherrypick.ui.main.search;

import net.jspiner.cherrypick.R;
import net.jspiner.cherrypick.databinding.FragmentSearchBinding;
import net.jspiner.cherrypick.ui.base.BaseFragment;

public class SearchFragment extends BaseFragment<FragmentSearchBinding, Contract.Presenter>
        implements Contract.View {

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_search;
    }

    @Override
    protected Contract.Presenter createPresenter() {
        return new SearchPresenter(this);
    }
}
