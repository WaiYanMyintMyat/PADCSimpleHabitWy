package com.example.waiyan.padcsimplehabitwy1.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.example.waiyan.padcsimplehabitwy1.R;
import com.example.waiyan.padcsimplehabitwy1.data.vo.TopicsVO;
import com.example.waiyan.padcsimplehabitwy1.viewholders.TopicItemViewHolder;

public class TopicsAdapter extends BaseRecyclerAdapter<TopicItemViewHolder,TopicsVO> {
    public TopicsAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public TopicItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mLayoutInflater.inflate(R.layout.medi_frag_series_all_topics_itemsone,parent,false);
        return new TopicItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicItemViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }
}
