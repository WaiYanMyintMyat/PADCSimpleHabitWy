package com.example.waiyan.padcsimplehabitwy1.network.responses;

import com.example.waiyan.padcsimplehabitwy1.data.vo.TopicsVO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TopicsResponse {

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("apiVersion")
    private String apiVersion;
    @SerializedName("page")
    private String page;
    @SerializedName("topics")
    private List<TopicsVO> allTopicsItems;

    public TopicsResponse() {

    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<TopicsVO> getAllTopicsItems() {
        return allTopicsItems;
    }

    public void setAllTopicsItems(List<TopicsVO> allTopicsItems) {
        this.allTopicsItems = allTopicsItems;
    }
}
