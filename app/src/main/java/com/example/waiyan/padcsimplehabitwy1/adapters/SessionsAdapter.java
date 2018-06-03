package com.example.waiyan.padcsimplehabitwy1.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.example.waiyan.padcsimplehabitwy1.R;
import com.example.waiyan.padcsimplehabitwy1.data.vo.Sessions;
import com.example.waiyan.padcsimplehabitwy1.viewholders.SessionsViewHolder;

/**
 * Created by Wai Yan on 5/31/2018.
 */

public class SessionsAdapter extends BaseRecyclerAdapter<SessionsViewHolder, Sessions> {


    public SessionsAdapter(Context context) {
        super(context);

    }

    @NonNull
    @Override
    public SessionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = mLayoutInflater.inflate(R.layout.detail_session_items, parent, false);
        return new SessionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SessionsViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }


}
