package com.example.waiyan.padcsimplehabitwy1.viewholders;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.waiyan.padcsimplehabitwy1.R;
import com.example.waiyan.padcsimplehabitwy1.data.vo.CurrentProgramVO;
import com.example.waiyan.padcsimplehabitwy1.delegates.CurrentDelegate;

import butterknife.BindView;

public class CurrentViewHolder extends BaseViewHolder<CurrentProgramVO> {

    @BindView(R.id.tv_current_simplehabit_title)
    TextView tvCurrentSimpleHabitTitle;

    @BindView(R.id.btn_medi_frag_series_day_one)
    Button btnMediFragSeriesDayOne;

    @BindView(R.id.tv_current_time)
    TextView tvCurrentTime;

    private CurrentDelegate currentDelegate;
    public CurrentViewHolder(View itemView, CurrentDelegate currentDelegate) {
        super(itemView);
        this.currentDelegate=currentDelegate;
    }

    @Override
    public void bind(CurrentProgramVO data) {
        tvCurrentSimpleHabitTitle.setText(data.getTitle());
        btnMediFragSeriesDayOne.setText(data.getCurrentPeriod());
        tvCurrentTime.setText(data.getAvgLength()[0]+" mins");
    }


    @Override
    public void onClick(View v) {
        currentDelegate.onTapCurrent();
    }


}
