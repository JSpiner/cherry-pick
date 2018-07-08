package net.jspiner.cherrypick.ui.common;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.ViewGroup;

import net.jspiner.cherrypick.databinding.CardHeaderTitleBinding;
import net.jspiner.cherrypick.ui.base.BaseViewHolder;

public class HeaderTitleViewHolder extends BaseViewHolder<CardHeaderTitleBinding, Object> {

    public HeaderTitleViewHolder(String title, ViewGroup parent, int layoutResId) {
        super(parent, layoutResId);

        StaggeredGridLayoutManager.LayoutParams layoutParams =
                (StaggeredGridLayoutManager.LayoutParams) binding.getRoot().getLayoutParams();
        layoutParams.setFullSpan(true);

        binding.title.setText(title);
    }

    @Override
    public void setData(Object data) {

    }
}
