package com.example.waiyan.padcsimplehabitwy1.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.waiyan.padcsimplehabitwy1.R;
import com.example.waiyan.padcsimplehabitwy1.adapters.MeditateViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragMeditate extends Fragment {

    @BindView(R.id.tl_frag_meditate)
    TabLayout tlFragMeditate;

    @BindView(R.id.vp_frag_meditate)
    ViewPager vpFragMeditate;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag_meditate,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MeditateViewPagerAdapter myViewPagerAdapter=new MeditateViewPagerAdapter(getActivity().getSupportFragmentManager());
        vpFragMeditate.setAdapter(myViewPagerAdapter);
        tlFragMeditate.setupWithViewPager(vpFragMeditate);

        vpFragMeditate.setCurrentItem(1);
    }
}
