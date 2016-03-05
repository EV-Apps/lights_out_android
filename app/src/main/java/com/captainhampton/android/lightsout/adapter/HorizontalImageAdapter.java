package com.captainhampton.android.lightsout.adapter;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.captainhampton.android.lightsout.R;

import java.util.List;

public class HorizontalImageAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {


    Context context;
    List objectsList;
    int layoutOfImageView = 0;
    int imageViewResourceId = 0;

    public HorizontalImageAdapter(Context context, List objects) {

        this.context = context;
        this.objectsList = objects;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.simple_imageview, parent, false);
        return new RecyclerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
//        final ImageView imageView = objectsList.get(position);

        holder.imageview.setImageResource(android.R.drawable.star_big_on);
    }

    @Override
    public int getItemCount() {
        return (null != objectsList ? objectsList.size() : 0);

    }
}

class RecyclerViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageview;

    public RecyclerViewHolder(View view) {
        super(view);
        this.imageview = (ImageView) view.findViewById(R.id.imageview_level);
    }

}