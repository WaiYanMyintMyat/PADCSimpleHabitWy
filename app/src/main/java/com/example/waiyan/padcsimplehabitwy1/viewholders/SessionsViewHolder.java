package com.example.waiyan.padcsimplehabitwy1.viewholders;

import android.view.View;
import android.widget.TextView;

import com.example.waiyan.padcsimplehabitwy1.R;
import com.example.waiyan.padcsimplehabitwy1.data.vo.Sessions;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wai Yan on 5/31/2018.
 */

public class SessionsViewHolder extends BaseViewHolder<Sessions> {

    @BindView(R.id.tv_detail_session_item_number)
    TextView tvDetailSessionItemNumber;

    @BindView(R.id.tv_detail_session_item_title)
    TextView tvDetailSessionItemTitle;

    @BindView(R.id.tv_detail_session_item_min)
    TextView tvDetailSessionItemMin;

    public SessionsViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(Sessions data) {
        //tvDetailSessionItemNumber.setText("1");
        tvDetailSessionItemNumber.setText(data.getSessionId());
        tvDetailSessionItemTitle.setText(data.getTitle());
        String lengthTime = data.getLengthTime() / 60 + ":" + data.getLengthTime() % 60;
        tvDetailSessionItemMin.setText(lengthTime);
    }


    @Override
    public void onClick(View v) {

    }
}
