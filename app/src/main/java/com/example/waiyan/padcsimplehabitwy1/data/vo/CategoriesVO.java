package com.example.waiyan.padcsimplehabitwy1.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoriesVO implements BaseVO {
    @SerializedName("category-id")
    String categoryId;
    @SerializedName("title")
    String title;
    @SerializedName("programs")
    List<Programs> programs;

    public CategoriesVO() {

    }


    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Programs> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Programs> programs) {
        this.programs = programs;
    }
}
