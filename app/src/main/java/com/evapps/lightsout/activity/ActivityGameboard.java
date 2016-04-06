package com.evapps.lightsout.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.evapps.lightsout.R;
import com.evapps.lightsout.fragment.FragmentLevelSelect;
import com.evapps.lightsout.model.StartGrid;
import com.evapps.lightsout.solver.Solver;

import java.io.IOException;

public class ActivityGameboard extends AppCompatActivity implements View.OnClickListener {

    public static final String STAGE = "stage";
    public static final String ROW = "row";
    public static final String COL = "col";

    public static final String TAG = "ActivityGameboard";
    public Button bHome, bHint, bReset;
    public TextView tvNumMoves, tvLevelTime;
    private int NUM_ROWS = 3;
    private int NUM_COLS = 3;
    private String stage;
    private Button[][] lights;

    private boolean[][] light_states;
    private int level_num = 0;
    private int num_moves;
    private long level_time; // System.nanoTime()
    private Solver solver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random);
        Intent intent = getIntent();
        if (intent != null) {
            stage = intent.getStringExtra(STAGE);
            NUM_ROWS = intent.getIntExtra(ROW, 3);
            NUM_COLS = intent.getIntExtra(COL, 3);
        }
        lights = new Button[NUM_ROWS][NUM_COLS];
        light_states = new boolean[NUM_ROWS][NUM_COLS];

        setupVariables();
        solver = new Solver(NUM_ROWS, NUM_COLS, this);
    }

    private void setLevel(int lvl) {
        level_num = lvl;
    }

    private void resetTimer() {
        level_time = 0;
        tvLevelTime.setText(String.format("%d", level_time));
    }

    private void resetNumMoves() {
        num_moves = 0;
        tvNumMoves.setText(String.format("%d", num_moves));
    }

    private void activateButton(int x, int y) {
        light_states[x][y] = Boolean.TRUE;
        lights[x][y].setBackgroundColor(Color.RED);
    }

    private void deactivateButton(int x, int y) {
        light_states[x][y] = Boolean.FALSE;
        lights[x][y].setBackgroundColor(Color.WHITE);
    }

    private void flipLight(int x, int y) {
        if (isLightActive(x, y))
            deactivateButton(x, y);
        else
            activateButton(x, y);
    }

    public boolean isLightOutOfBounds(int x, int y) {
        return (x >= NUM_ROWS || x < 0 || y >= NUM_COLS || y < 0);
    }

    private boolean isLightActive(int x, int y) {
        return (light_states[x][y] == Boolean.TRUE);
    }

    private void pressedLights(int x, int y) {
        int top = x - 1;
        int bot = x + 1;
        int left = y - 1;
        int right = y + 1;

        flipLight(x, y);

        if (!isLightOutOfBounds(top, y))
            flipLight(top, y);


        if (!isLightOutOfBounds(bot, y))
            flipLight(bot, y);


        if (!isLightOutOfBounds(x, left))
            flipLight(x, left);


        if (!isLightOutOfBounds(x, right))
            flipLight(x, right);

    }

    private void clearBoard() {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                deactivateButton(i, j);
            }
        }
        resetTimer();
        resetNumMoves();
    }

    private void setupBoard() {

        clearBoard();
        clearSolution();


        // changed to // use the passed in startgrid to initialize
        StartGrid startGrid = null;
        try {
            startGrid = StartGrid.deserializeJsonStringToStartGrid(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (startGrid != null) {
            for (Pair<Integer, Integer> pair : startGrid.startGrid) {
                int x = pair.first;
                int y = pair.second;
                activateButton(x, y);
            }
        }
    }

    private boolean checkVictory() {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                if (isLightActive(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void setupVariables() {

        TableLayout table = (TableLayout) findViewById(R.id.tbRandom);

        bHome = (Button) findViewById(R.id.bHome);
        bHome.setOnClickListener(this);

        bReset = (Button) findViewById(R.id.bReset);
        bReset.setOnClickListener(this);

        bHint = (Button) findViewById(R.id.bHint);
        bHint.setOnClickListener(this);

        tvNumMoves = (TextView) findViewById(R.id.tvNumMoves);
        tvLevelTime = (TextView) findViewById(R.id.tvLevelTime);

        for (int i = 0; i < NUM_ROWS; i++) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    1.0f
            ));
            table.addView(tableRow);
            for (int j = 0; j < NUM_COLS; j++) {

                final int x = i;
                final int y = j;
                Button button = new Button(this);
                button.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT,
                        1.0f
                ));

                button.setText("" + x + "," + y);
                // make text not clip on small buttons
                button.setPadding(0, 0, 0, 0);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Button button = lights[x][y];

                        if (button.isPressed()) {
                            pressedLights(x, y);
                            clearSolution();
                            num_moves++;
                            tvNumMoves.setText(String.format("%d", num_moves));
                            tvLevelTime.setText(String.format("%d", level_time));
                        }

                        if (checkVictory()) {
                            finishActivity(FragmentLevelSelect.REQUEST_CODE); // will go back to the last stage
                            // go back to activity and check the stage as completed
                            // TODO : victory dance
//                            level_num++; // cant increment levels anymore since the level data is received from the database and onclick
//                            // TODO: find out how to increment
//                            if (level_num <= Levels.getLevels(NUM_ROWS, NUM_COLS).length) {
//                                setLevel(level_num);
//                                setupBoard();
//                            } else {
//                                // TODO
//                            }
                        }

                    }
                });

                tableRow.addView(button);
                lights[x][y] = button;

            }
        }

        setupBoard();

    }

    private void clearSolution() {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                lights[i][j].setTextColor(Color.BLACK);
            }
        }
    }

    private void showSolution() {
        boolean[][] solution = solver.calculateWinningConfig(light_states);

        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                if (solution[i][j] == Boolean.TRUE)
                    lights[i][j].setTextColor(Color.YELLOW);
            }
        }

    }


    @Override
    public void onClick(View v) {

        if (bReset.isPressed()) {
            setupBoard();
        }

        if (bHint.isPressed()) {
            showSolution();
        }
    }

}