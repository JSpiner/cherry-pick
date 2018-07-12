package net.jspiner.cherrypick.ui.main.combine;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import net.jspiner.cherrypick.R;
import net.jspiner.cherrypick.databinding.FragmentCombineBinding;
import net.jspiner.cherrypick.ui.base.BaseFragment;

import java.util.ArrayList;

public class CombineFragment extends BaseFragment<FragmentCombineBinding, Contract.Presenter>
        implements Contract.View {

    private CombineAdapter combineAdapter;

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init();
    }

    private void init() {
        initViews();
    }

    private void initViews() {
        initRecyclerView();
    }

    private void initRecyclerView() {
        combineAdapter = new CombineAdapter();
        binding.recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext())
        );
        binding.recyclerView.setAdapter(combineAdapter);

        addDummyData();
    }

    private void addDummyData() {
        ArrayList<Object> dummyData = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            dummyData.add(new Object());
        }
        combineAdapter.addAll(dummyData);
    }
}
