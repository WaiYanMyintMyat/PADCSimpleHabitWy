package com.example.waiyan.padcsimplehabitwy1.network.responses;

import com.example.waiyan.padcsimplehabitwy1.data.vo.CurrentProgramVO;
import com.google.gson.annotations.SerializedName;

public class CurrentProgramResponse {
    @SerializedName("code")
    int code;
    @SerializedName("message")
    String message;
    @SerializedName("apiVersion")
    String apiVersion;

    @SerializedName("currentProgram")
    CurrentProgramVO currentProgramVO;

    public CurrentProgramResponse() {

    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
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

    public CurrentProgramVO getCurrentProgramVO() {
        return currentProgramVO;
    }

    public void setCurrentProgramVO(CurrentProgramVO currentProgramVO) {
        this.currentProgramVO = currentProgramVO;
    }
}
