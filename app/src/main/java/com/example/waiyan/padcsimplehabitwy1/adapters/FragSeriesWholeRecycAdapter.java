package com.example.waiyan.padcsimplehabitwy1.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.example.waiyan.padcsimplehabitwy1.R;
import com.example.waiyan.padcsimplehabitwy1.data.vo.BaseVO;
import com.example.waiyan.padcsimplehabitwy1.data.vo.CategoriesVO;
import com.example.waiyan.padcsimplehabitwy1.data.vo.CurrentProgramVO;
import com.example.waiyan.padcsimplehabitwy1.data.vo.TopicListVO;
import com.example.waiyan.padcsimplehabitwy1.data.vo.TopicsVO;
import com.example.waiyan.padcsimplehabitwy1.delegates.CategoriesDelegate;
import com.example.waiyan.padcsimplehabitwy1.delegates.CurrentDelegate;
import com.example.waiyan.padcsimplehabitwy1.viewholders.TopicViewHolder;
import com.example.waiyan.padcsimplehabitwy1.viewholders.BaseViewHolder;
import com.example.waiyan.padcsimplehabitwy1.viewholders.CategoriesViewHolder;
import com.example.waiyan.padcsimplehabitwy1.viewholders.CurrentViewHolder;

public class FragSeriesWholeRecycAdapter extends BaseRecyclerAdapter<BaseViewHolder, BaseVO> {
    private static final int CURRENT_PROGRAM = 1;
    private static final int CATEGORIES_ITEMS = 2;
    private static final int TOPICS_ITEM = 3;

    private CurrentDelegate currentDelegate;
    private CategoriesDelegate categoriesDelegate;

    public FragSeriesWholeRecycAdapter(Context context, CurrentDelegate currentDelegate, CategoriesDelegate categoriesDelegate) {
        super(context);
        this.currentDelegate=currentDelegate;
        this.categoriesDelegate=categoriesDelegate;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BaseViewHolder vh = null;
        if (viewType == CURRENT_PROGRAM) {
            View v = mLayoutInflater.inflate(R.layout.medi_frag_series_top_item, parent, false);
            vh = new CurrentViewHolder(v,currentDelegate);
        } else if (viewType == CATEGORIES_ITEMS) {
            View v = mLayoutInflater.inflate(R.layout.medi_frag_series_morningmeditate_recyc_items, parent, false);
            vh = new CategoriesViewHolder(v,categoriesDelegate);
        } else if (viewType == TOPICS_ITEM) {
            View v = mLayoutInflater.inflate(R.layout.medi_frag_series_all_topics_recyc_items, parent, false);
            vh = new TopicViewHolder(v);
        }
        return vh;
    }

    @Override
    public int getItemViewType(int position) {
        if (mData.get(position) instanceof CurrentProgramVO) {
            return CURRENT_PROGRAM;
        } else if (mData.get(position) instanceof CategoriesVO) {
            return CATEGORIES_ITEMS;
        } else if (mData.get(position) instanceof TopicListVO) {
            return TOPICS_ITEM;
        } else {
            return CATEGORIES_ITEMS;
        }

//        if (position == 0) {
//            return CURRENT_PROGRAM;
//        } else if (position == 1) {
//            return CATEGORIES_ITEMS;
//        } else if (position == 2) {
//            return TOPICS_ITEM;
//        } else {
//            return CATEGORIES_ITEMS;
//        }

    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }
}
