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
            int index = i%5;
            switch (index) {
                case 0:
                    recipe.title = "마티니";
                    recipe.imageUrl = "https://cdn.liquor.com/wp-content/uploads/2013/03/04113537/dry-martini-7200-720-recipe.jpg";
                    break;
                case 1:
                    recipe.title = "진토닉";
                    recipe.imageUrl = "https://t1.daumcdn.net/cfile/tistory/26224E3C54F4210A0D";
                    break;
                case 2:
                    recipe.title = "갓파더";
                    recipe.imageUrl = "https://cdn.namuwikiusercontent.com/s/257d3b64afcc5de0fcf7bb4f72fd0c3f6c4012b55f823687f28cc1c24aef2ec7d346dc79eba3dc25053df2c55faaab9f0a101bb65b92c699c430faef5cc60486fee7b78ae23eb24b0e999c3caa39223f?e=1534552290&k=qZklaFsRVwfGQEHh723Zlw";
                    break;
                case 3:
                    recipe.title = "쿠바 리브레";
                    recipe.imageUrl = "https://st2.depositphotos.com/1022665/6331/i/950/depositphotos_63311287-stock-photo-cocktails-collection-cuba-libre.jpg";
                    break;
                case 4:
                    recipe.title = "러스티 네일";
                    recipe.imageUrl = "http://cfile30.uf.tistory.com/image/995DAE425A503C751E2D26";
                    break;
            }
            dataList.add(recipe);
        }
        recipeAdapter.addAll(dataList);
    }
}
