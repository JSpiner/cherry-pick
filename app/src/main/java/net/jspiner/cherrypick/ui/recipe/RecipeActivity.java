package net.jspiner.cherrypick.ui.recipe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.Gson;

import net.jspiner.cherrypick.R;
import net.jspiner.cherrypick.databinding.ActivityRecipeBinding;
import net.jspiner.cherrypick.model.Recipe;
import net.jspiner.cherrypick.ui.base.BaseActivity;
import net.jspiner.cherrypick.ui.util.IntentKey;

public class RecipeActivity extends BaseActivity<ActivityRecipeBinding, Contract.Presenter>
        implements Contract.View {

    private Recipe recipe;

    public static void startActivity(Context context, @NonNull Recipe recipe) {
        Intent intent = new Intent(context, RecipeActivity.class);
        intent.putExtra(IntentKey.INTENT_KEY_RECIPE, new Gson().toJson(recipe));
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_recipe;
    }

    @Override
    protected Contract.Presenter createPresenter() {
        return new RecipePresenter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
    }

    private void init() {
        recipe = new Gson().fromJson(
                getIntent().getStringExtra(IntentKey.INTENT_KEY_RECIPE),
                Recipe.class
        );
    }

}
