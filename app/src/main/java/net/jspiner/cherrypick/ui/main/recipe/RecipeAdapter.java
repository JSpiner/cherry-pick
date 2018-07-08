package net.jspiner.cherrypick.ui.main.recipe;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import net.jspiner.cherrypick.R;
import net.jspiner.cherrypick.ui.base.BaseAdapter;

public class RecipeAdapter extends BaseAdapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecipeViewHolder(parent, R.layout.card_recipe);
    }

}
