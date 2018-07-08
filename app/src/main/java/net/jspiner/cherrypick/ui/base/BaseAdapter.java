package net.jspiner.cherrypick.ui.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

public abstract class BaseAdapter<D> extends RecyclerView.Adapter<BaseViewHolder> {

    private ArrayList<D> dataList;

    public BaseAdapter() {
        super();
        dataList = new ArrayList<>();
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.setData(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addAll(ArrayList<D> itemList) {
        int prevSize = dataList.size();
        dataList.addAll(itemList);
        notifyItemRangeInserted(prevSize, itemList.size());
    }
}
