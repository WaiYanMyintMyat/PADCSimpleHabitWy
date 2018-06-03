package com.example.waiyan.padcsimplehabitwy1.network;

import com.example.waiyan.padcsimplehabitwy1.network.responses.CategoriesResponse;
import com.example.waiyan.padcsimplehabitwy1.network.responses.CurrentProgramResponse;
import com.example.waiyan.padcsimplehabitwy1.network.responses.TopicsResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SimpleHabitAPI {

    @FormUrlEncoded
    @POST("getCurrentProgram.php")
    Call<CurrentProgramResponse> getCurrentProgram(@Field("access_token") String access_token, @Field("page") int page);

    @FormUrlEncoded
    @POST("getCategoriesPrograms.php")
    Call<CategoriesResponse> getCategoriesPrograms(@Field("access_token") String access_token, @Field("page") int page);

    @FormUrlEncoded
    @POST("getTopics.php")
    Call<TopicsResponse> getTopicsData(@Field("access_token") String access_token, @Field("page") int page);

}
