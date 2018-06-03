package com.example.waiyan.padcsimplehabitwy1.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;

import com.example.waiyan.padcsimplehabitwy1.MMSimpleHabitApp;
import com.example.waiyan.padcsimplehabitwy1.R;
import com.example.waiyan.padcsimplehabitwy1.adapters.SessionsAdapter;
import com.example.waiyan.padcsimplehabitwy1.data.models.HabitModel;
import com.example.waiyan.padcsimplehabitwy1.data.vo.CategoriesVO;
import com.example.waiyan.padcsimplehabitwy1.data.vo.CurrentProgramVO;
import com.example.waiyan.padcsimplehabitwy1.data.vo.Programs;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity {

    @BindView(R.id.rv_sessions)
    RecyclerView rvSessions;

    @BindView(R.id.toolbar_detail)
    Toolbar toolbarDetail;

    @BindView(R.id.collapsingtbl_detail)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.tv_detail_description)
    TextView tvDetailDescription;

    private SessionsAdapter sessionsAdapter;

    public static Intent newIntentCurrent(Context context) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(MMSimpleHabitApp.VIEW_TYPE,MMSimpleHabitApp.CURRENT_PROGRAM);
        return intent;
    }

    public static Intent newIntentCategories(Context context, String categoryId, String categoryProgramId) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(MMSimpleHabitApp.VIEW_TYPE, MMSimpleHabitApp.CATEGORY);
        intent.putExtra(MMSimpleHabitApp.CATEGORY_ID, categoryId);
        intent.putExtra(MMSimpleHabitApp.CATEGORY_PROGRAM_ID, categoryProgramId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this,this);

        setSupportActionBar(toolbarDetail);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        sessionsAdapter=new SessionsAdapter(DetailActivity.this);
        rvSessions.setLayoutManager(new LinearLayoutManager(DetailActivity.this, LinearLayoutManager.VERTICAL, false));
        rvSessions.setAdapter(sessionsAdapter);

        if (getIntent().getStringExtra(MMSimpleHabitApp.VIEW_TYPE).equals(MMSimpleHabitApp.CURRENT_PROGRAM)) {
            CurrentProgramVO currentProgram = HabitModel.getInstance(DetailActivity.this).getCurrentProgram();
            sessionsAdapter.setNewData(currentProgram.getSessions());
            collapsingToolbarLayout.setTitle(currentProgram.getTitle());
            tvDetailDescription.setText(currentProgram.getDescription());
        }else if(getIntent().getStringExtra(MMSimpleHabitApp.VIEW_TYPE).equals(MMSimpleHabitApp.CATEGORY)){
            String categoryId = getIntent().getStringExtra(MMSimpleHabitApp.CATEGORY_ID);
            String categoryProgramId = getIntent().getStringExtra(MMSimpleHabitApp.CATEGORY_PROGRAM_ID);

            Programs programs=HabitModel.getInstance(DetailActivity.this).getProgram(categoryId,categoryProgramId);
            sessionsAdapter.setNewData(programs.getSessions());
            collapsingToolbarLayout.setTitle(programs.getTitle());
            tvDetailDescription.setText(programs.getDescription());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
