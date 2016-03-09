package com.captainhampton.android.lightsout.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.captainhampton.android.lightsout.R;
import com.captainhampton.android.lightsout.adapter.HorizontalImageAdapter;
import com.captainhampton.android.lightsout.solver.Solver;
import com.captainhampton.android.lightsout.solver.Levels;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentLevelSelect extends Fragment {
    private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 5;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private int x;
    private int y;
    private Solver solver;

    public FragmentLevelSelect() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        solver = new Solver(NUM_ROWS, NUM_COLS);
        if (getArguments() != null) {

            x = getArguments().getInt(ARG_PARAM1);
            y = getArguments().getInt(ARG_PARAM2);

        }
    }
    public static FragmentRandom newInstance(String param1, String param2) {
        FragmentRandom fragment = new FragmentRandom();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
