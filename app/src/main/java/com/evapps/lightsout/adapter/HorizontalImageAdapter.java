package com.evapps.lightsout.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.evapps.lightsout.R;

import java.util.ArrayList;

public class HorizontalImageAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {


    Context context;
    ArrayList<ArrayList<Pair<Integer, Integer>>> stagesList;
    int layoutOfImageView = 0;
    int imageViewResourceId = 0;
    int x, y;

    public HorizontalImageAdapter(Context context, ArrayList<ArrayList<Pair<Integer, Integer>>> stages, Pair<Integer, Integer> xy) {

        this.context = context;
        stagesList = stages;
        x = xy.first;
        y = xy.second;
//        Paper.book().read(ActivityStartScreen.database);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.simple_imageview, parent, false);
        return new RecyclerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
//        final ImageView imageView = stagesList.get(position);

        holder.imageview.setImageResource(android.R.drawable.star_big_on);
    }

    @Override
    public int getItemCount() {
        return (null != stagesList ? stagesList.size() : 0);

    }
}

class RecyclerViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageview;

    public RecyclerViewHolder(View view) {
        super(view);
        this.imageview = (ImageView) view.findViewById(R.id.imageview_level);
    }

}