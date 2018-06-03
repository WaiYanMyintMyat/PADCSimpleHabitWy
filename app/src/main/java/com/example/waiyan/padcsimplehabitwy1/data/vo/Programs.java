package com.example.waiyan.padcsimplehabitwy1.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Programs {
    @SerializedName("program-id")
    String programId;
    @SerializedName("title")
    String title;
    @SerializedName("image")
    String image;
    @SerializedName("average-lengths")
    int[] avgLength;
    @SerializedName("description")
    String description;
    @SerializedName("sessions")
    List<Sessions> sessions;

    public Programs() {

    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int[] getAvgLength() {
        return avgLength;
    }

    public void setAvgLength(int[] avgLength) {
        this.avgLength = avgLength;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Sessions> getSessions() {
        return sessions;
    }

    public void setSessions(List<Sessions> sessions) {
        this.sessions = sessions;
    }
}
