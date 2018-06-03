package com.example.waiyan.padcsimplehabitwy1.viewholders;

import android.view.View;
import android.widget.TextView;

import com.example.waiyan.padcsimplehabitwy1.R;
import com.example.waiyan.padcsimplehabitwy1.data.vo.Programs;
import com.example.waiyan.padcsimplehabitwy1.data.vo.TopicsVO;

import butterknife.BindView;

public class TopicItemViewHolder extends BaseViewHolder<TopicsVO>{

    @BindView(R.id.tv_medi_frag_series_all_topics_recyc_items_upper)
    TextView tvMediFragSeriesAllTopicsRecycItemsUpper;

    @BindView(R.id.tv_medi_frag_series_all_topics_recyc_items_lower)
    TextView tvMediFragSeriesAllTopicsRecycItemsLower;


    public TopicItemViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(TopicsVO data) {
        tvMediFragSeriesAllTopicsRecycItemsUpper.setText(data.getTopicName());
        tvMediFragSeriesAllTopicsRecycItemsLower.setText(data.getTopicDesc());
    }

    @Override
    public void onClick(View v) {

    }
}
