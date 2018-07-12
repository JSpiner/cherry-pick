package net.jspiner.cherrypick.ui.main.recipe;

import android.app.Activity;
import android.content.Context;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import net.jspiner.cherrypick.databinding.CardRecipeBinding;
import net.jspiner.cherrypick.model.Recipe;
import net.jspiner.cherrypick.ui.base.BaseViewHolder;
import net.jspiner.cherrypick.ui.recipe.RecipeActivity;

public class RecipeViewHolder extends BaseViewHolder<CardRecipeBinding, Recipe> {

    public RecipeViewHolder(ViewGroup parent, int layoutResId) {
        super(parent, layoutResId);

        binding.root.setOnClickListener(__ -> {
            RecipeActivity.startActivity(
                    (Activity) binding.getRoot().getContext(),
                    lastData,
                    createPair(binding.image),
                    createPair(binding.title)
            );
        });
    }

    private Pair<View, String> createPair(View view) {
        return new Pair<>(view, ViewCompat.getTransitionName(view));
    }

    @Override
    public void setData(Recipe recipe) {
        super.setData(recipe);
        Context context = binding.getRoot().getContext();

        Glide.with(context)
                .load(recipe.imageUrl)
                .into(binding.image);
        binding.title.setText(recipe.title);
    }
}
