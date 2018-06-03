package com.example.waiyan.padcsimplehabitwy1.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.waiyan.padcsimplehabitwy1.R;
import com.example.waiyan.padcsimplehabitwy1.adapters.TopicsAdapter;
import com.example.waiyan.padcsimplehabitwy1.data.vo.CategoriesVO;
import com.example.waiyan.padcsimplehabitwy1.data.vo.TopicListVO;
import com.example.waiyan.padcsimplehabitwy1.data.vo.TopicsVO;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class TopicViewHolder extends BaseViewHolder<TopicListVO> {

    @BindView(R.id.rv_medi_frag_series_all_topics_recyc_items)
    RecyclerView rvTopics;

    @BindView(R.id.tv_medi_frag_series_all_topics_recyc_items_title)
    TextView tvMediFragSeriesAllTopicsRecycItemsTitle;


    private TopicsAdapter topicsAdapter;

    public TopicViewHolder(View itemView) {
        super(itemView);
        topicsAdapter=new TopicsAdapter(itemView.getContext());
    }

    @Override
    public void bind(TopicListVO data) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.VERTICAL, false);
        rvTopics.setLayoutManager(layoutManager);
        rvTopics.setAdapter(topicsAdapter);
        topicsAdapter.setNewData(data.getTopicsVOS());
        //topicsAdapter.addNewData(data);
//        List<TopicsVO> topicsVOList = new ArrayList<>();
//        topicsVOList.add(new TopicsVO("d", "e", "dfdf"));
//        topicsVOList.add(new TopicsVO("d", "e", "dfdf"));
//        topicsVOList.add(new TopicsVO("d", "e", "dfdf"));
//        topicsVOList.add(new TopicsVO("d", "e", "dfdf"));
//        topicsAdapter.setNewData(topicsVOList);
    }


    @Override
    public void onClick(View v) {
    }
}
