package com.example.waiyan.padcsimplehabitwy1.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.waiyan.padcsimplehabitwy1.R;
import com.example.waiyan.padcsimplehabitwy1.adapters.FragSeriesWholeRecycAdapter;
import com.example.waiyan.padcsimplehabitwy1.data.vo.BaseVO;
import com.example.waiyan.padcsimplehabitwy1.data.vo.CategoriesVO;
import com.example.waiyan.padcsimplehabitwy1.data.vo.CurrentProgramVO;
import com.example.waiyan.padcsimplehabitwy1.data.vo.TopicsVO;
import com.example.waiyan.padcsimplehabitwy1.delegates.CategoriesDelegate;
import com.example.waiyan.padcsimplehabitwy1.delegates.CurrentDelegate;
import com.example.waiyan.padcsimplehabitwy1.events.RestApiEvent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

public class MediFragSeries extends Fragment {

    @BindView(R.id.rv_whole_frag_series)
    RecyclerView rvWholeFragSeries;
    private FragSeriesWholeRecycAdapter fragSeriesWholeRecycAdapter;

    private CurrentDelegate currentDelegate;
    private CategoriesDelegate categoriesDelegate;

    @Override
    public void onStart() {
        super.onStart();
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if(EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.medi_frag_series, container, false);
        ButterKnife.bind(this, view);
        currentDelegate= (CurrentDelegate) getContext();
        categoriesDelegate= (CategoriesDelegate) getContext();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rvWholeFragSeries.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        fragSeriesWholeRecycAdapter = new FragSeriesWholeRecycAdapter(getActivity(),currentDelegate,categoriesDelegate);
        rvWholeFragSeries.setAdapter(fragSeriesWholeRecycAdapter);
//        List<BaseVO> baseVOList = new ArrayList<>();
//        baseVOList.add(new CurrentProgramVO("a", "b", "c"));
//        baseVOList.add(new CategoriesVO("d", "e", "dfdf"));
//        baseVOList.add(new TopicsVO("a", "g", "t"));
//        fragSeriesWholeRecycAdapter.appendNewData(baseVOList);



        //scroll to top
        rvWholeFragSeries.getLayoutManager().smoothScrollToPosition(rvWholeFragSeries, null, 0);
    }

    @Subscribe(threadMode = ThreadMode.MainThread)
    public void getBaseVoList(RestApiEvent.BaseDataLoadedEvent event){
        fragSeriesWholeRecycAdapter.setNewData(event.getBaseDataList());
    }
}
