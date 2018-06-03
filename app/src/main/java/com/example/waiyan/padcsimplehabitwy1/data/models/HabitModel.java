package com.example.waiyan.padcsimplehabitwy1.data.models;

import android.content.Context;
import android.support.annotation.Nullable;

import com.example.waiyan.padcsimplehabitwy1.data.vo.BaseVO;
import com.example.waiyan.padcsimplehabitwy1.data.vo.CategoriesVO;
import com.example.waiyan.padcsimplehabitwy1.data.vo.CurrentProgramVO;
import com.example.waiyan.padcsimplehabitwy1.data.vo.Programs;
import com.example.waiyan.padcsimplehabitwy1.data.vo.TopicListVO;
import com.example.waiyan.padcsimplehabitwy1.events.RestApiEvent;
import com.example.waiyan.padcsimplehabitwy1.network.SimpleHabitDataAgentImpl;
import com.example.waiyan.padcsimplehabitwy1.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * Created by Wai Yan on 12/3/17.
 */

public class HabitModel {

    private static HabitModel objInstance;
    Context context;
    SimpleHabitDataAgentImpl simpleHabitDataAgentImpl;

    private int mmNewsPageIndex = 1;
    List<BaseVO> baseVOList=new ArrayList<>();

    private HabitModel(Context context) {

        this.context=context;
        simpleHabitDataAgentImpl= SimpleHabitDataAgentImpl.getInstance();

        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
    }

    public static HabitModel getInstance(Context context){
        if(objInstance==null){
            objInstance=new HabitModel(context);
        }
        return objInstance;
    }

    public void startLoadingCurrentProgram(){
        simpleHabitDataAgentImpl.getCurrentProgram(AppConstants.ACCESS_TOKEN,mmNewsPageIndex);
    }

    public void startLoadingCategories(){
        simpleHabitDataAgentImpl.getCategoriesPrograms(AppConstants.ACCESS_TOKEN,mmNewsPageIndex);
    }

    public void startLoadingTopics(){
        simpleHabitDataAgentImpl.getTopicsData(AppConstants.ACCESS_TOKEN,mmNewsPageIndex);
    }

    @Subscribe(threadMode = ThreadMode.BackgroundThread)
    public void onCurrentDataLoaded(RestApiEvent.CurrentProgramEvent event){
        baseVOList.add(event.getCurrentItem());
        startLoadingCategories();
    }

    @Subscribe(threadMode = ThreadMode.BackgroundThread)
    public void onCategoriesDataLoaded(RestApiEvent.CategoriesDataLoadedEvent event){
        baseVOList.addAll(event.getLoadCategories());
        startLoadingTopics();
    }

    @Subscribe(threadMode = ThreadMode.BackgroundThread)
    public void onTopicsDataLoaded(RestApiEvent.TopicsDataLoadedEvent event){
        //6 topic -> 1 topicListVO  -> baseVOList
        TopicListVO topicListVO = new TopicListVO();
        topicListVO.setTopicsVOS(event.getLoadTopics());
        baseVOList.add(topicListVO);
        EventBus.getDefault().post(new RestApiEvent.BaseDataLoadedEvent(baseVOList));
    }

    public @Nullable CurrentProgramVO getCurrentProgram() {
        for (BaseVO obj : baseVOList) {
            if (obj instanceof CurrentProgramVO)
                return (CurrentProgramVO) obj;
        }
        return null;
    }

    public @Nullable Programs getProgram(String categoryId, String categoryProgramId) {
        for (int i = 0; i < baseVOList.size(); i++) {
            if (baseVOList.get(i) instanceof CategoriesVO) {
                if (((CategoriesVO) baseVOList.get(i)).getCategoryId().equals(categoryId)) {
                    for (int j = 0; j < ((CategoriesVO) baseVOList.get(i)).getPrograms().size(); j++) {
                        if (((CategoriesVO) baseVOList.get(i)).getPrograms().get(j).getProgramId().equals(categoryProgramId)) {
                            return ((CategoriesVO) baseVOList.get(i)).getPrograms().get(j);
                        }
                    }
                }
            }
        }
        return null;
    }


}
