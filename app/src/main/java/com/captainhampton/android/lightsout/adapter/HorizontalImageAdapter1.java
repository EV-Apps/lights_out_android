package com.captainhampton.android.lightsout.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.captainhampton.android.lightsout.R;
import com.captainhampton.android.lightsout.model.Stage;

import java.util.ArrayList;

public class HorizontalImageAdapter1 extends RecyclerView.Adapter<RecyclerViewHolder1> {


    Context context;
    ArrayList<Stage> stagesList;
    int x, y;

    public HorizontalImageAdapter1(Context context, ArrayList<Stage> result, Pair<Integer, Integer> xy) {
        this.context = context;
        stagesList = result;
        x = xy.first;
        y = xy.second;

    }

    @Override
    public RecyclerViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.simple_imageview, parent, false);
        return new RecyclerViewHolder1(view);

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder1 holder, int position) {
        boolean isLocked = stagesList.get(position).is_locked();

        if (isLocked) {
            holder.imageview.setImageResource(android.R.drawable.ic_lock_lock);
        } else {
            holder.imageview.setImageResource(android.R.drawable.star_big_on);
        }
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