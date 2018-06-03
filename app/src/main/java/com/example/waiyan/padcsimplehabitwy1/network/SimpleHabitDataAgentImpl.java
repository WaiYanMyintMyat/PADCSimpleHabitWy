package com.example.waiyan.padcsimplehabitwy1.network;

import android.util.Log;

import com.example.waiyan.padcsimplehabitwy1.events.RestApiEvent;
import com.example.waiyan.padcsimplehabitwy1.network.responses.CategoriesResponse;
import com.example.waiyan.padcsimplehabitwy1.network.responses.CurrentProgramResponse;
import com.example.waiyan.padcsimplehabitwy1.network.responses.TopicsResponse;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import de.greenrobot.event.EventBus;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SimpleHabitDataAgentImpl implements SimpleHabitDataAgent {

    private static SimpleHabitDataAgentImpl objInstance;
    private SimpleHabitAPI theApi;

    public static SimpleHabitDataAgentImpl getInstance(){
        if(objInstance==null){
            objInstance=new SimpleHabitDataAgentImpl();
        }
        return objInstance;
    }


    private SimpleHabitDataAgentImpl(){
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .build();

        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-5/simple-habits/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();
        theApi=retrofit.create(SimpleHabitAPI.class);

    }

    @Override
    public void getCurrentProgram(String accessToken, int pageNo) {
        Call<CurrentProgramResponse> loadData=theApi.getCurrentProgram(accessToken,pageNo);
        loadData.enqueue(new Callback<CurrentProgramResponse>() {
            @Override
            public void onResponse(Call<CurrentProgramResponse> call, Response<CurrentProgramResponse> response) {
                CurrentProgramResponse currentResponse = response.body();
                if (currentResponse != null
                        && response.isSuccessful()) {
                    EventBus.getDefault().post(new RestApiEvent.CurrentProgramEvent(currentResponse.getCurrentProgramVO()));
                } else {
                    RestApiEvent.ErrorInvokingAPIEvent errorEvent
                            = new RestApiEvent.ErrorInvokingAPIEvent("No data could be loaded for now. Pls try again later.");
                    EventBus.getDefault().post(errorEvent);
                }
            }
            @Override
            public void onFailure(Call<CurrentProgramResponse> call, Throwable t) {
                RestApiEvent.ErrorInvokingAPIEvent errorEvent = new RestApiEvent.ErrorInvokingAPIEvent(t.getMessage());
                EventBus.getDefault().post(errorEvent);
            }
        });
    }

    @Override
    public void getCategoriesPrograms(String accessToken, int pageNo) {
        Call<CategoriesResponse> loadData=theApi.getCategoriesPrograms(accessToken,pageNo);
        loadData.enqueue(new Callback<CategoriesResponse>() {
            @Override
            public void onResponse(Call<CategoriesResponse> call, Response<CategoriesResponse> response) {
                CategoriesResponse categoriesResponse=response.body();
                if (categoriesResponse != null
                        && categoriesResponse.getCategoriesPrograms().size() > 0) {
                    RestApiEvent.CategoriesDataLoadedEvent categoriesDataLoadedEvent = new RestApiEvent.CategoriesDataLoadedEvent(
                            categoriesResponse.getPage(), categoriesResponse.getCategoriesPrograms());
                    EventBus.getDefault().post(categoriesDataLoadedEvent);
                } else {
                    RestApiEvent.ErrorInvokingAPIEvent errorEvent
                            = new RestApiEvent.ErrorInvokingAPIEvent("No data could be loaded for now. Pls try again later.");
                    EventBus.getDefault().post(errorEvent);
                }
            }

            @Override
            public void onFailure(Call<CategoriesResponse> call, Throwable t) {
                RestApiEvent.ErrorInvokingAPIEvent errorEvent = new RestApiEvent.ErrorInvokingAPIEvent(t.getMessage());
                EventBus.getDefault().post(errorEvent);
            }
        });
    }

    @Override
    public void getTopicsData(String accessToken, int pageNo) {
        Call<TopicsResponse> loadData=theApi.getTopicsData(accessToken,pageNo);
        loadData.enqueue(new Callback<TopicsResponse>() {
            @Override
            public void onResponse(Call<TopicsResponse> call, Response<TopicsResponse> response) {
                TopicsResponse topicsResponse=response.body();
                if (topicsResponse != null
                        && topicsResponse.getAllTopicsItems().size() > 0) {
                    RestApiEvent.TopicsDataLoadedEvent topicsDataLoadedEvent = new RestApiEvent.TopicsDataLoadedEvent(
                            topicsResponse.getPage(), topicsResponse.getAllTopicsItems());
                    EventBus.getDefault().post(topicsDataLoadedEvent);
                } else {
                    RestApiEvent.ErrorInvokingAPIEvent errorEvent
                            = new RestApiEvent.ErrorInvokingAPIEvent("No data could be loaded for now. Pls try again later.");
                    EventBus.getDefault().post(errorEvent);
                }
            }

            @Override
            public void onFailure(Call<TopicsResponse> call, Throwable t) {
                RestApiEvent.ErrorInvokingAPIEvent errorEvent = new RestApiEvent.ErrorInvokingAPIEvent(t.getMessage());
                EventBus.getDefault().post(errorEvent);
            }
        });
    }

}
