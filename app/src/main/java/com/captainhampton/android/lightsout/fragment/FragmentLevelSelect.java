package com.captainhampton.android.lightsout.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.captainhampton.android.lightsout.R;
import com.captainhampton.android.lightsout.adapter.HorizontalImageAdapter;
import com.captainhampton.android.lightsout.solver.Levels;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentLevelSelect extends Fragment {

    public FragmentLevelSelect() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_level_select, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_recyclerview_levels);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<ArrayList<Pair<Integer, Integer>>> stages = Levels.transformLevelToList(3, 3);

        recyclerView.setAdapter(new HorizontalImageAdapter(getActivity(), stages));

        return rootView;
    }
}
