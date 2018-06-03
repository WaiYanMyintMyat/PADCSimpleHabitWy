package com.example.waiyan.padcsimplehabitwy1.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.example.waiyan.padcsimplehabitwy1.R;
import com.example.waiyan.padcsimplehabitwy1.data.vo.CategoriesVO;
import com.example.waiyan.padcsimplehabitwy1.data.vo.Programs;
import com.example.waiyan.padcsimplehabitwy1.delegates.CategoriesDelegate;
import com.example.waiyan.padcsimplehabitwy1.viewholders.CategoriesItemViewHolder;
import com.example.waiyan.padcsimplehabitwy1.viewholders.CategoriesViewHolder;

public class CategoriesAdapter extends BaseRecyclerAdapter<CategoriesItemViewHolder,Programs> {

    private CategoriesDelegate categoriesDelegate;
    private CategoriesVO categoriesVO;

    public CategoriesAdapter(Context context, CategoriesDelegate categoriesDelegate) {
        super(context);
        this.categoriesDelegate=categoriesDelegate;
    }

    @NonNull
    @Override
    public CategoriesItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mLayoutInflater.inflate(R.layout.medi_frag_series_morningmeditate_itemsone,parent,false);
        return new CategoriesItemViewHolder(view,categoriesDelegate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesItemViewHolder holder, int position) {
        holder.bind(mData.get(position));
        holder.setCategoryToCategoryItemViewHoler(categoriesVO);
    }

    public void setCategory(CategoriesVO categoriesVO) {
        this.categoriesVO = categoriesVO;
    }
}
