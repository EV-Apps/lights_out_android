package com.captainhampton.android.lightsout.adapter;

import android.content.Context;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.captainhampton.android.lightsout.R;
import com.captainhampton.android.lightsout.model.Stage;

import java.util.ArrayList;

public class HorizontalImageAdapter1 extends RecyclerView.Adapter<RecyclerViewHolder> {


    Context context;
    ArrayList<Stage> stagesList;
    int layoutOfImageView = 0;
    int imageViewResourceId = 0;
    int x, y;

    public HorizontalImageAdapter1(Context context, ArrayList<Stage> result, Pair<Integer, Integer> xy) {
        this.context = context;
        stagesList = result;
        x = xy.first;
        y = xy.second;

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

class RecyclerViewHolder1 extends RecyclerView.ViewHolder {
    public ImageView imageview;

    public RecyclerViewHolder1(View view) {
        super(view);
        this.imageview = (ImageView) view.findViewById(R.id.imageview_level);
    }

}