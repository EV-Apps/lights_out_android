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

public class HorizontalImageAdapter1 extends RecyclerView.Adapter<HorizontalImageAdapter1.RecyclerViewHolder1> {


    private final OnClickListener onClickListener;
    Context context;
    ArrayList<Stage> stagesList;
    int x, y;

    public HorizontalImageAdapter1(Context context, ArrayList<Stage> result, Pair<Integer, Integer> xy, OnClickListener onClickListener) {
        this.context = context;
        stagesList = result;
        this.onClickListener = onClickListener;
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
        holder.bind(stagesList.get(position));
    }

    @Override
    public int getItemCount() {
        return (null != stagesList ? stagesList.size() : 0);

    }

    public interface OnClickListener {
        void onStageClick(Stage stage);
    }

    class RecyclerViewHolder1 extends RecyclerView.ViewHolder {

        public ImageView imageview;
        public Stage stage;
        boolean isLocked = false;

        public RecyclerViewHolder1(View view) {
            super(view);
            imageview = (ImageView) view.findViewById(R.id.imageview_level);
        }

        public void bind(final Stage stage) {
            this.stage = stage;
            isLocked = stage.is_locked();

            if (isLocked) {
                imageview.setImageResource(android.R.drawable.ic_lock_lock);
            } else {
                imageview.setImageResource(android.R.drawable.star_big_on);
            }

            imageview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onStageClick(stage);
                }
            });
        }
    }
}


