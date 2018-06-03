package com.example.waiyan.padcsimplehabitwy1.viewholders;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.waiyan.padcsimplehabitwy1.R;
import com.example.waiyan.padcsimplehabitwy1.adapters.CategoriesAdapter;
import com.example.waiyan.padcsimplehabitwy1.data.vo.CategoriesVO;
import com.example.waiyan.padcsimplehabitwy1.delegates.CategoriesDelegate;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class CategoriesViewHolder extends BaseViewHolder<CategoriesVO> {

    @BindView(R.id.rv_medi_frag_series_morning_meditate_recyc_items)
    RecyclerView rvMoriningMeditate;

    @BindView(R.id.tv_medi_frag_series_morning_meditate_recyc_items_title)
    TextView tvMediFragSeriesMorningMeditateRecycItemsTitle;

    private CategoriesAdapter categoriesAdapter;
    private CategoriesDelegate categoriesDelegate;

    public CategoriesViewHolder(View itemView, CategoriesDelegate categoriesDelegate) {
        super(itemView);
        this.categoriesDelegate=categoriesDelegate;
        categoriesAdapter = new CategoriesAdapter(itemView.getContext(),categoriesDelegate);
    }

    @Override
    public void bind(CategoriesVO data) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvMoriningMeditate.setLayoutManager(layoutManager);
        rvMoriningMeditate.setAdapter(categoriesAdapter);
        categoriesAdapter.setNewData(data.getPrograms());
        categoriesAdapter.setCategory(data);
        tvMediFragSeriesMorningMeditateRecycItemsTitle.setText(data.getTitle());
//        List<CategoriesVO> categoriesVOList = new ArrayList<>();
//        categoriesVOList.add(new CategoriesVO("d", "e", "dfdf"));
//        categoriesVOList.add(new CategoriesVO("d", "e", "dfdf"));
//        categoriesVOList.add(new CategoriesVO("d", "e", "dfdf"));
//        categoriesVOList.add(new CategoriesVO("d", "e", "dfdf"));
//        categoriesAdapter.setNewData(categoriesVOList);
    }


    @Override
    public void onClick(View v) {

    }


}
