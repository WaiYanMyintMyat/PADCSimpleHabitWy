package com.example.waiyan.padcsimplehabitwy1.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.waiyan.padcsimplehabitwy1.R;
import com.example.waiyan.padcsimplehabitwy1.data.vo.CategoriesVO;
import com.example.waiyan.padcsimplehabitwy1.data.vo.Programs;
import com.example.waiyan.padcsimplehabitwy1.delegates.CategoriesDelegate;

import butterknife.BindView;

public class CategoriesItemViewHolder extends BaseViewHolder<Programs>{

    @BindView(R.id.tv_medi_frag_series_morningmeditate_itemsone_subtitle)
    TextView tvMediFragSeriesMorningMeditateItemOneSubtitle;

    @BindView(R.id.tv_medi_frag_series_morningmeditate_itemsone_min)
    TextView tvMediFragSeriesMorningMeditateItemsOneMin;

    private CategoriesDelegate categoriesDelegate;
    private Programs programs;
    private CategoriesVO categoriesVO;

    public CategoriesItemViewHolder(View itemView, CategoriesDelegate categoriesDelegate) {
        super(itemView);
        this.categoriesDelegate=categoriesDelegate;
    }

    @Override
    public void bind(Programs data) {
        programs=data;
        tvMediFragSeriesMorningMeditateItemOneSubtitle.setText(data.getTitle());
        tvMediFragSeriesMorningMeditateItemsOneMin.setText(String.valueOf(data.getAvgLength()[0])+" mins");
    }

    public void setCategoryToCategoryItemViewHoler(CategoriesVO categoriesVO){
        this.categoriesVO=categoriesVO;
    }

    @Override
    public void onClick(View v) {
        categoriesDelegate.onTapCategories(categoriesVO.getCategoryId(),programs.getProgramId());
    }
}
