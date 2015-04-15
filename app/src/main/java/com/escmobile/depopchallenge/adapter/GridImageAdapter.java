package com.escmobile.depopchallenge.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.escmobile.depopchallenge.R;
import com.escmobile.depopchallenge.model.data.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by genctasbasi on 15/04/15.
 */
public class GridImageAdapter extends BaseAdapter {

    private Context context;
    private List<Item> items;

    public GridImageAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView = convertView == null ? new ImageView(context) : (ImageView) convertView;

        Picasso
                .with(context)
                .load(items.get(position).getImageUrl())
                .placeholder(R.drawable.loading)
                .into(imageView);

        return imageView;
    }
}
