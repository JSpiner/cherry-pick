package net.jspiner.cherrypick.ui.main.recipe;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import net.jspiner.cherrypick.R;
import net.jspiner.cherrypick.ui.base.BaseAdapter;
import net.jspiner.cherrypick.ui.common.HeaderTitleViewHolder;

public class RecipeAdapter extends BaseAdapter {

    private final int VIEW_TYPE_HEADER = 1;
    private final int VIEW_TYPE_ITEM = 2;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_HEADER:
                return new HeaderTitleViewHolder("원하는 레시피를 찾아보세요!", parent, R.layout.card_header_title);
            case VIEW_TYPE_ITEM:
                return new RecipeViewHolder(parent, R.layout.card_recipe);
            default:
                throw new IllegalArgumentException("존재할 수 없는 type : " + viewType);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_HEADER;
        } else {
            return VIEW_TYPE_ITEM;
        }
    }
}
