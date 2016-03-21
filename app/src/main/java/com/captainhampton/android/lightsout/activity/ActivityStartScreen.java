package com.captainhampton.android.lightsout.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.captainhampton.android.lightsout.LOUtils;
import com.captainhampton.android.lightsout.R;
import com.captainhampton.android.lightsout.solver.Levels;

import java.util.ArrayList;

import io.paperdb.Book;
import io.paperdb.Paper;

public class ActivityStartScreen extends AppCompatActivity {

    public static final String database = "database";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialization();
    }

    private void initialization() {

        paperInit();

        setContentView(R.layout.activity_start_screen);
        findViewById(R.id.fullscreen_content_controls).setVisibility(View.VISIBLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        LOUtils.applyFont(this, R.id.start_screen_text, LOUtils.FONT_GEAR);

        findViewById(R.id.start_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityStartScreen.this, ActivityMain.class));
            }
        });
    }

    private void paperInit() {

        Paper.init(this);
        Book book = Paper.book();

        // Levels data structures should be refactored to a list or something easier to work with
        // perhaps a database entry due to the need of meta data

        // if the list of locked levels does not exist, this is the players first time in the game
        // thus we create the list of locked levels/stages
        if (!book.exist(database)) {
            ArrayList<ArrayList<Boolean>> stages = new ArrayList<>();

            stages.add(Levels.getStagesListOfIsLocked(3,3));
            stages.add(Levels.getStagesListOfIsLocked(3,4));
            stages.add(Levels.getStagesListOfIsLocked(4,3));
            stages.add(Levels.getStagesListOfIsLocked(4,4));
            stages.add(Levels.getStagesListOfIsLocked(5,5));
            stages.add(Levels.getStagesListOfIsLocked(6,6));

            Paper.book().write(database, stages); //
        }
    }


}
