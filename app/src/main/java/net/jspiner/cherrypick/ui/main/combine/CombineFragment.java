package net.jspiner.cherrypick.ui.main.combine;

import net.jspiner.cherrypick.R;
import net.jspiner.cherrypick.databinding.FragmentCombineBinding;
import net.jspiner.cherrypick.ui.base.BaseFragment;

public class CombineFragment extends BaseFragment<FragmentCombineBinding, Contract.Presenter>
        implements Contract.View {

    public static CombineFragment newInstance() {
        CombineFragment fragment = new CombineFragment();
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_combine;
    }

    @Override
    protected Contract.Presenter createPresenter() {
        return new CombinePresenter(this);
    }
}
