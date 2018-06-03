package com.example.waiyan.padcsimplehabitwy1.data.vo;

import com.google.gson.annotations.SerializedName;

public class TopicsVO implements BaseVO {
    @SerializedName("topic-name")
    String topicName;
    @SerializedName("topic-desc")
    String topicDesc;
    @SerializedName("icon")
    String image;
    @SerializedName("background")
    String backgroundImg;

    public TopicsVO(String topicName, String topicDesc, String image, String backgroundImg) {
        this.topicName = topicName;
        this.topicDesc = topicDesc;
        this.image = image;
        this.backgroundImg = backgroundImg;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBackgroundImg() {
        return backgroundImg;
    }

    public void setBackgroundImg(String backgroundImg) {
        this.backgroundImg = backgroundImg;
    }
}
