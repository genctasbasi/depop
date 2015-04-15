package com.escmobile.depopchallenge.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.escmobile.depopchallenge.R;

/**
 * Created by genctasbasi on 15/04/15.
 */
public class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView itemImage;

    public ViewHolder(View itemView) {
        super(itemView);
        itemImage = (ImageView)itemView.findViewById(R.id.image);
    }

}
