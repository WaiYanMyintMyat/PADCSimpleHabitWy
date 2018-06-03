package com.example.waiyan.padcsimplehabitwy1.events;

import com.example.waiyan.padcsimplehabitwy1.data.vo.BaseVO;
import com.example.waiyan.padcsimplehabitwy1.data.vo.CategoriesVO;
import com.example.waiyan.padcsimplehabitwy1.data.vo.CurrentProgramVO;
import com.example.waiyan.padcsimplehabitwy1.data.vo.TopicsVO;

import java.util.List;

public class RestApiEvent {
    public static class EmptyResponseEvent {

    }

    public static class ErrorInvokingAPIEvent {
        private String errorMsg;

        public ErrorInvokingAPIEvent(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public String getErrorMsg() {
            return errorMsg;
        }
    }

    public static class CurrentProgramEvent{
        CurrentProgramVO currentProgramVO;

        public CurrentProgramEvent(CurrentProgramVO currentProgramVO) {
            this.currentProgramVO = currentProgramVO;
        }

        public CurrentProgramVO getCurrentItem() {
            return currentProgramVO;
        }

        public void setCurrentItem(CurrentProgramVO currentProgramVO) {
            this.currentProgramVO = currentProgramVO;
        }
    }

    public static class CategoriesDataLoadedEvent {
        private String loadedPageIndex;
        private List<CategoriesVO> loadCategoriesData;

        public CategoriesDataLoadedEvent(String loadedPageIndex, List<CategoriesVO> loadCategoriesData) {
            this.loadedPageIndex = loadedPageIndex;
            this.loadCategoriesData = loadCategoriesData;
        }

        public String getLoadedPageIndex() {
            return loadedPageIndex;
        }

        public List<CategoriesVO> getLoadCategories() {
            return loadCategoriesData;
        }
    }

    public static class TopicsDataLoadedEvent {
        private String loadedPageIndex;
        private List<TopicsVO> loadTopicsData;

        public TopicsDataLoadedEvent(String loadedPageIndex, List<TopicsVO> loadTopicsData) {
            this.loadedPageIndex = loadedPageIndex;
            this.loadTopicsData = loadTopicsData;
        }

        public String getLoadedPageIndex() {
            return loadedPageIndex;
        }

        public List<TopicsVO> getLoadTopics() {
            return loadTopicsData;
        }
    }


    public static class BaseDataLoadedEvent {
        private List<BaseVO> baseDataList;

        public BaseDataLoadedEvent(List<BaseVO> baseDataList) {
            this.baseDataList = baseDataList;
        }

        public List<BaseVO> getBaseDataList() {
            return baseDataList;
        }
    }

}
