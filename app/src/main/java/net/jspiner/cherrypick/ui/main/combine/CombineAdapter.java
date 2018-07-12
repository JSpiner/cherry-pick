package net.jspiner.cherrypick.ui.main.combine;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import net.jspiner.cherrypick.R;
import net.jspiner.cherrypick.ui.base.BaseAdapter;
import net.jspiner.cherrypick.ui.common.HeaderTitleViewHolder;

public class CombineAdapter extends BaseAdapter {

    private final int VIEW_TYPE_HEADER = 1;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_HEADER:
                return new HeaderTitleViewHolder("재료를 고르면,\n레시피를 알려줄게요!", parent, R.layout.card_header_title);
            default:
                throw new IllegalArgumentException("존재할 수 없는 type : " + viewType);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return VIEW_TYPE_HEADER;
    }
}
