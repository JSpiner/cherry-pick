package net.jspiner.cherrypick.ui.recipe;

import net.jspiner.cherrypick.R;
import net.jspiner.cherrypick.databinding.ActivityRecipeBinding;
import net.jspiner.cherrypick.ui.base.BaseActivity;

public class RecipeActivity extends BaseActivity<ActivityRecipeBinding, Contract.Presenter>
        implements Contract.View {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_recipe;
    }

    @Override
    protected Contract.Presenter createPresenter() {
        return new RecipePresenter(this);
    }

}
