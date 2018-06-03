package com.example.waiyan.padcsimplehabitwy1.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TopicListVO implements BaseVO {

    private List<TopicsVO> topicsVOS;

    public List<TopicsVO> getTopicsVOS() {
        return topicsVOS;
    }

    public void setTopicsVOS(List<TopicsVO> topicsVOS) {
        this.topicsVOS = topicsVOS;
    }
}
