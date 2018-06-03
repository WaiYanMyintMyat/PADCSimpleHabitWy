package com.example.waiyan.padcsimplehabitwy1.network.responses;

import com.example.waiyan.padcsimplehabitwy1.data.vo.CategoriesVO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoriesResponse {

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("apiVersion")
    private String apiVersion;
    @SerializedName("page")
    private String page;
    @SerializedName("categoriesPrograms")
    private List<CategoriesVO> categoriesPrograms;

    public CategoriesResponse() {
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

    public List<CategoriesVO> getCategoriesPrograms() {
        return categoriesPrograms;
    }

    public void setCategoriesPrograms(List<CategoriesVO> categoriesPrograms) {
        this.categoriesPrograms = categoriesPrograms;
    }
}
