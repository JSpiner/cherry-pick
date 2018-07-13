package net.jspiner.cherrypick.ui.main.combine;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import net.jspiner.cherrypick.R;
import net.jspiner.cherrypick.ui.base.BaseAdapter;
import net.jspiner.cherrypick.ui.base.BaseViewHolder;

public class MaterialAdapter extends BaseAdapter<Object> {
    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MaterialViewHolder(
                parent,
                R.layout.card_material
        );
    }
}
