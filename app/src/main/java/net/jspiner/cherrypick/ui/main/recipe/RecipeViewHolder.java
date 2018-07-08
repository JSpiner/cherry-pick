package net.jspiner.cherrypick.ui.main.recipe;

import android.content.Context;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import net.jspiner.cherrypick.databinding.CardRecipeBinding;
import net.jspiner.cherrypick.model.Recipe;
import net.jspiner.cherrypick.ui.base.BaseViewHolder;

public class RecipeViewHolder extends BaseViewHolder<CardRecipeBinding, Recipe> {

    public RecipeViewHolder(ViewGroup parent, int layoutResId) {
        super(parent, layoutResId);
    }

    @Override
    public void setData(Recipe recipe) {
        Context context = binding.getRoot().getContext();

        Glide.with(context)
                .load(recipe.imageUrl)
                .into(binding.image);
        binding.title.setText(recipe.title);
    }
}
