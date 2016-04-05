package com.captainhampton.android.lightsout.fragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.captainhampton.android.lightsout.R;
import com.captainhampton.android.lightsout.adapter.HorizontalImageAdapter;
import com.captainhampton.android.lightsout.adapter.HorizontalImageAdapter1;
import com.captainhampton.android.lightsout.model.LightsOutOpenHelper;
import com.captainhampton.android.lightsout.model.Stage;
import com.captainhampton.android.lightsout.model.StageModel;
import com.captainhampton.android.lightsout.solver.Levels;

import java.util.ArrayList;

public class FragmentLevelSelect extends Fragment {

    public static final String TAG = "FragmentLevelSelect";


    private static final String X = "param1";
    private static final String Y = "param2";
    private static final String LEVEL_ID = "levelId";
    private int x, y;
    private long levelId;


    public FragmentLevelSelect() {
    }

    public static FragmentLevelSelect newInstance(int inX, int inY, long levelId) {
        FragmentLevelSelect fragment = new FragmentLevelSelect();
        Bundle args = new Bundle();
        args.putInt(X, inX);
        args.putInt(Y, inY);
        args.putLong(LEVEL_ID, levelId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            x = getArguments().getInt(X);
            y = getArguments().getInt(Y);
            levelId = getArguments().getLong(LEVEL_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_level_select, container, false);
        TextView title = (TextView) rootView.findViewById(R.id.level_title);

        String stringTitle = getString(R.string.title_level) + " " + Integer.toString(x) + " x " + Integer.toString(y);
        title.setText(stringTitle);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_recyclerview_levels);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

//        setAdapterWithTransformedLevelList(recyclerView);
        // or the new way
        setAdapterWithDatabaseCall(recyclerView);

        return rootView;
    }

    private void setAdapterWithTransformedLevelList(RecyclerView recyclerView) {
        ArrayList<ArrayList<Pair<Integer, Integer>>> levelWithStages = Levels.transformLevelToList(x, y);
        recyclerView.setAdapter(new HorizontalImageAdapter(getActivity(), levelWithStages, new Pair<>(x, y)));
    }

    public void setAdapterWithDatabaseCall(RecyclerView recylerView) {
        SQLiteDatabase db = LightsOutOpenHelper.getInstance(getActivity()).getReadableDatabase();
        ArrayList<Stage> result = new ArrayList<>();

        // need to get the level id
        Cursor cursor = db.rawQuery(StageModel.FOR_LEVEL, new String[]{String.valueOf(levelId)});

        while (cursor.moveToNext()) {
            result.add(Stage.MAPPER.map(cursor));
        }
        recylerView.setAdapter(new HorizontalImageAdapter1(getActivity(), result, new Pair<>(x, y)));
    }
}
