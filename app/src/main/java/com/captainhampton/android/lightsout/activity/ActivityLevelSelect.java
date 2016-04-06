package com.captainhampton.android.lightsout.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.captainhampton.android.lightsout.R;
import com.captainhampton.android.lightsout.fragment.FragmentLevelSelect;
import com.captainhampton.android.lightsout.fragment.FragmentMenu;
import com.captainhampton.android.lightsout.model.Level;
import com.captainhampton.android.lightsout.model.LevelModel;
import com.captainhampton.android.lightsout.model.LightsOutOpenHelper;

import java.util.ArrayList;

public class ActivityLevelSelect extends AppCompatActivity implements FragmentMenu.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_select);

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (fragmentManager.findFragmentByTag(FragmentLevelSelect.TAG + "_3_3") == null) {

            String tag;
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


            SQLiteDatabase db = LightsOutOpenHelper.getInstance(this).getReadableDatabase();
            ArrayList<Level> levelsList = new ArrayList<>();

            // need to get the level id
            Cursor cursor = db.rawQuery(LevelModel.SELECT_ALL, new String[0]);

            while (cursor.moveToNext()) {
                levelsList.add(Level.MAPPER.map(cursor));
            }
            // should pass in the db, and keep the calls to a minimum
            for (Level l : levelsList) {

                FragmentLevelSelect fragmentLevelSelect = FragmentLevelSelect.newInstance(l.num_rows(), l.num_cols(), l._id());
                tag = FragmentLevelSelect.TAG + "_" + Integer.toString(l.num_rows()) + "_" + Integer.toString(l.num_cols());
                fragmentTransaction.add(R.id.level_select_linearlayout, fragmentLevelSelect, tag);
            }
            fragmentTransaction.commit();
        }

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "TODO Random level", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

    }


    @Override
    public void onFragmentInteraction(int i) {

    }

    @Override
    public void onStartButtonPressed() {

    }
}
