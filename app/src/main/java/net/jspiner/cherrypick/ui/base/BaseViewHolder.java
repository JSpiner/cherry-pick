package net.jspiner.cherrypick.ui.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class BaseViewHolder<B extends ViewDataBinding, D> extends RecyclerView.ViewHolder {

    protected B binding;

    public BaseViewHolder(ViewGroup parent, @LayoutRes int layoutResId) {
        super(LayoutInflater.from(parent.getContext()).inflate(layoutResId, parent, false));
        this.binding = DataBindingUtil.bind(itemView);
    }

    public abstract void setData(D data);

}
