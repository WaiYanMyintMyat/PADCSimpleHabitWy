package com.example.waiyan.padcsimplehabitwy1.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.waiyan.padcsimplehabitwy1.MMSimpleHabitApp;
import com.example.waiyan.padcsimplehabitwy1.R;
import com.example.waiyan.padcsimplehabitwy1.delegates.CategoriesDelegate;
import com.example.waiyan.padcsimplehabitwy1.delegates.CurrentDelegate;
import com.example.waiyan.padcsimplehabitwy1.fragments.FragMe;
import com.example.waiyan.padcsimplehabitwy1.fragments.FragMeditate;
import com.example.waiyan.padcsimplehabitwy1.fragments.FragMore;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements CurrentDelegate,CategoriesDelegate {
    @BindView(R.id.toolbar_main)
    Toolbar toolbarMain;

    @BindView(R.id.fl_main)
    FrameLayout flMain;

    @BindView(R.id.bnv_main)
    BottomNavigationView bnvMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this,this);

        setSupportActionBar(toolbarMain);
        toolbarMain.setTitle("Meditate");
        loadFragment(new FragMeditate());
        bnvMain.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_bnv_meditate:
                        toolbarMain.setTitle("Meditate");
                        loadFragment(new FragMeditate());
                        break;
                    case R.id.menu_bnv_me:
                        toolbarMain.setTitle("Me");
                        loadFragment(new FragMe());
                        break;
                    case R.id.menu_bnv_more:
                        toolbarMain.setTitle("More");
                        loadFragment(new FragMore());
                        break;
                }
                return true;
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_main, fragment);
        //transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menu_toolbar_search){
            Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTapCurrent() {
        //Static Factory Pattern
        Intent intent=DetailActivity.newIntentCurrent(MainActivity.this);
        startActivity(intent);
    }

    @Override
    public void onTapCategories(String categoryId, String categoriesProgramId) {
        Intent intent=DetailActivity.newIntentCategories(MainActivity.this,categoryId,categoriesProgramId);
        startActivity(intent);
    }
}
