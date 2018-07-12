package net.jspiner.cherrypick.ui.recipe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import net.jspiner.cherrypick.R;
import net.jspiner.cherrypick.databinding.ActivityRecipeBinding;
import net.jspiner.cherrypick.model.Recipe;
import net.jspiner.cherrypick.ui.base.BaseActivity;
import net.jspiner.cherrypick.ui.util.IntentKey;

public class RecipeActivity extends BaseActivity<ActivityRecipeBinding, Contract.Presenter>
        implements Contract.View {

    private Recipe recipe;

    public static void startActivity(Activity activity, @NonNull Recipe recipe, ImageView imageView) {
        Intent intent = new Intent(activity, RecipeActivity.class);
        intent.putExtra(IntentKey.INTENT_KEY_RECIPE, new Gson().toJson(recipe));

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                activity,
                imageView,
                ViewCompat.getTransitionName(imageView)
        );
        activity.startActivity(intent, options.toBundle());
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
        setStatusBarTranslucent();

        init();
    }

    private void init() {
        recipe = new Gson().fromJson(
                getIntent().getStringExtra(IntentKey.INTENT_KEY_RECIPE),
                Recipe.class
        );

        Glide.with(getBaseContext())
                .load(recipe.imageUrl)
                .into(binding.recipe);
    }

}
