package com.example.waiyan.padcsimplehabitwy1.network;

public interface SimpleHabitDataAgent {
    void getCurrentProgram(String accessToken, int pageNo);
    void getCategoriesPrograms(String accessToken, int pageNo);
    void getTopicsData(String accessToken, int pageNo);
}
