package net.jspiner.cherrypick.ui.main.recipe;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import net.jspiner.cherrypick.R;
import net.jspiner.cherrypick.databinding.FragmentRecipeBinding;
import net.jspiner.cherrypick.model.Recipe;
import net.jspiner.cherrypick.ui.base.BaseFragment;

import java.util.ArrayList;

public class RecipeFragment extends BaseFragment<FragmentRecipeBinding, Contract.Presenter>
        implements Contract.View {

    private RecipeAdapter recipeAdapter;

    public static RecipeFragment newInstance() {
        RecipeFragment fragment = new RecipeFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recipe;
    }

    @Override
    protected Contract.Presenter createPresenter() {
        return new RecipePresenter(this);
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
        recipeAdapter = new RecipeAdapter();
        binding.recyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        );
        binding.recyclerView.setAdapter(recipeAdapter);

        addDummyData();
    }

    private void addDummyData() {
        ArrayList<Recipe> dataList = new ArrayList<>();
        for(int i=0;i<100;i++){
            Recipe recipe = new Recipe();
            dataList.add(recipe);
        }
        recipeAdapter.addAll(dataList);
    }
}
