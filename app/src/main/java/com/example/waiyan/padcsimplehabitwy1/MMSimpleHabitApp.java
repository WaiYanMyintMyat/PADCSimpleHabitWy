package com.example.waiyan.padcsimplehabitwy1;

import android.app.Application;

import com.example.waiyan.padcsimplehabitwy1.data.models.HabitModel;

/**
 * Created by Wai Yan on 11/4/17.
 */

public class MMSimpleHabitApp extends Application {

    public static final String LOG_TAG = "MMSimpleHabitApp";

    public static final String VIEW_TYPE = "viewType";
    public static final String CURRENT_PROGRAM = "currentProgram";

    public static final String CATEGORY = "category";
    public static final String CATEGORY_ID = "categoryId";
    public static final String CATEGORY_PROGRAM_ID = "categoryProgramId";

    @Override
    public void onCreate() {
        super.onCreate();
        HabitModel.getInstance(this).startLoadingCurrentProgram();
//        HabitModel.getInstance(this).startLoadingCategories();
//        HabitModel.getInstance(this).startLoadingTopics();
    }
}
