package com.example.waiyan.padcsimplehabitwy1.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;


/**
 * Created by Wai Yan on 6/13/17.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener {

    protected boolean mDetechedFromWindow;

    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(this);


        itemView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View v) {
                mDetechedFromWindow = false;
            }

            @Override
            public void onViewDetachedFromWindow(View v) {
                mDetechedFromWindow = true;
            }
        });
    }

    public abstract void bind(T data);
}
