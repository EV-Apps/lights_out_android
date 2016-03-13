package com.captainhampton.android.lightsout.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.captainhampton.android.lightsout.R;
import com.captainhampton.android.lightsout.fragment.FragmentMenu;
import com.captainhampton.android.lightsout.solver.Levels;

public class ActivityLevelSelect extends AppCompatActivity implements FragmentMenu.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_select);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (fragmentManager.findFragmentByTag(FragmentMenu.TAG) == null) {


        }



        // TODO FIX THIS STATIC SIZE OF 6 FOR THE LOVE OF GOD
      //  for (int i = 0; i < 6; i++) {

         //   Fragment menu = FragmentMenu.newInstance("a", "b");
           // fragmentTransaction.add(R.id.menu_screen, menu, FragmentMenu.TAG).commit();
       // }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
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
