package com.evapps.lightsout.fragment;

import android.app.Activity;
import android.content.Intent;
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

import com.evapps.lightsout.R;
import com.evapps.lightsout.activity.ActivityGameboard;
import com.evapps.lightsout.adapter.HorizontalImageAdapter1;
import com.evapps.lightsout.model.LightsOutOpenHelper;
import com.evapps.lightsout.model.Stage;
import com.evapps.lightsout.model.StageModel;

import java.util.ArrayList;

public class FragmentLevelSelect extends Fragment implements HorizontalImageAdapter1.OnClickListener {

    public static final String TAG = "FragmentLevelSelect";
    public static final int REQUEST_CODE = 0;


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

//    private void setAdapterWithTransformedLevelList(RecyclerView recyclerView) {
//        ArrayList<ArrayList<Pair<Integer, Integer>>> levelWithStages = Levels.transformLevelToList(x, y);
//        recyclerView.setAdapter(new HorizontalImageAdapter(getActivity(), levelWithStages, new Pair<>(x, y)));
//    }

    public void setAdapterWithDatabaseCall(RecyclerView recylerView) {
        SQLiteDatabase db = LightsOutOpenHelper.getInstance(getActivity()).getReadableDatabase();
        ArrayList<Stage> result = new ArrayList<>();

        // need to get the level id
        Cursor cursor = db.rawQuery(StageModel.FOR_LEVEL, new String[]{String.valueOf(levelId)});

        while (cursor.moveToNext()) {
            result.add(Stage.MAPPER.map(cursor));
        }


        // pass in cursor to adapter
        recylerView.setAdapter(new HorizontalImageAdapter1(getActivity(), result, new Pair<>(x, y), this));
    }

    @Override
    public void onStageClick(Stage stage) {
        Intent intent = new Intent(this.getActivity(), ActivityGameboard.class);
        intent.putExtra(ActivityGameboard.STAGE, stage.start_grid());
        intent.putExtra(ActivityGameboard.ROW, stage.num_rows());
        intent.putExtra(ActivityGameboard.COL, stage.num_cols());
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                // this will be call after finish
                // update database to show the level was complete
//                SQLiteDatabase db = LightsOutOpenHelper.getInstance(getActivity()).getReadableDatabase();
//                Cursor cursor = db.rawQuery(StageModel.FOR_LEVEL, new String[]{String.valueOf(levelId)});
//
            } else {
                // the backed out
            }
        }

    }
}
