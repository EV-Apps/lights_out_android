package com.captainhampton.android.lightsout.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.captainhampton.android.lightsout.R;
import com.captainhampton.android.lightsout.fragment.FragmentLevelSelect;
import com.captainhampton.android.lightsout.fragment.FragmentMenu;
import com.captainhampton.android.lightsout.solver.Levels;

public class ActivityLevelSelect extends AppCompatActivity implements FragmentMenu.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_select);

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (fragmentManager.findFragmentByTag(FragmentLevelSelect.TAG + "_3_3") == null) {

            String tag;
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            for (Pair<Integer, Integer> pair : Levels.levelList) {

                FragmentLevelSelect fragmentLevelSelect = FragmentLevelSelect.newInstance(pair.first, pair.second);
                tag = FragmentLevelSelect.TAG + "_" + Integer.toString(pair.first) + "_" + Integer.toString(pair.second);
                fragmentTransaction.add(R.id.level_select_linearlayout, fragmentLevelSelect, tag);
            }
            fragmentTransaction.commit();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "TODO Random level", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public void onFragmentInteraction(int i) {

    }

    @Override
    public void onStartButtonPressed() {

    }
}
