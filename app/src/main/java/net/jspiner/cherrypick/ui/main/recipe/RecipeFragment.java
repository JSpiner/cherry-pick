package net.jspiner.cherrypick.ui.main.recipe;

import net.jspiner.cherrypick.R;
import net.jspiner.cherrypick.databinding.FragmentRecipeBinding;
import net.jspiner.cherrypick.ui.base.BaseFragment;

public class RecipeFragment extends BaseFragment<FragmentRecipeBinding, Contract.Presenter>
        implements Contract.View {

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
}
