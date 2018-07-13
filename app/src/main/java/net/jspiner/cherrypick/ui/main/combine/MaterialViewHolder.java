package net.jspiner.cherrypick.ui.main.combine;

import android.view.ViewGroup;

import net.jspiner.cherrypick.databinding.CardMaterialBinding;
import net.jspiner.cherrypick.ui.base.BaseViewHolder;

public class MaterialViewHolder extends BaseViewHolder<CardMaterialBinding, Object> {

    public MaterialViewHolder(ViewGroup parent, int layoutResId) {
        super(parent, layoutResId);

        binding.getRoot().setOnClickListener(__ -> {

        });
    }

}
