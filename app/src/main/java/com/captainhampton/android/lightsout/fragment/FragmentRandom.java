//package com.captainhampton.android.lightsout.fragment;
//
//import android.content.Context;
//import android.graphics.Color;
//import android.net.Uri;
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.util.Pair;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.TableLayout;
//import android.widget.TableRow;
//import android.widget.TextView;
//
//import com.captainhampton.android.lightsout.R;
//import com.captainhampton.android.lightsout.model.StartGrid;
//import com.captainhampton.android.lightsout.solver.Levels;
//import com.captainhampton.android.lightsout.solver.Solver;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//
//public class FragmentRandom extends Fragment implements OnClickListener {
//
//    public static final String TAG = "FragmentRandom";
//
//    private int NUM_ROWS = 3;
//    private int NUM_COLS = 3;
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//    private static final String ARG_PARAM3 = "param3";
//    private String jsonStartGrid = "";
//    private StartGrid startGrid;
//
//    public Button bHome, bHint, bReset;
//    public TextView tvNumMoves, tvLevelTime;
//    private Button[][] lights = new Button[NUM_ROWS][NUM_COLS];
//
//    private boolean[][] light_states = new boolean[NUM_ROWS][NUM_COLS];
//    private int level_num = 0;
//    private int num_moves;
//    private long level_time; // System.nanoTime()
//    private Solver solver;
//    private OnFragmentInteractionListener mListener;
//
//    public FragmentRandom() {
//        // Required empty public constructor
//    }
//
//    public static FragmentRandom newInstance(int rows, int cols, String jsonGrid) {
//        FragmentRandom fragment = new FragmentRandom();
//        Bundle args = new Bundle();
//        args.putInt(ARG_PARAM1, rows);
//        args.putInt(ARG_PARAM2, cols);
//        args.putString(ARG_PARAM3, jsonGrid);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            NUM_ROWS = getArguments().getInt(ARG_PARAM1);
//            NUM_COLS = getArguments().getInt(ARG_PARAM2);
//            jsonStartGrid = getArguments().getString(ARG_PARAM3);
//            if (jsonStartGrid != null) {
//                try {
//                    startGrid = StartGrid.deserializeJsonStringToStartGrid(jsonStartGrid);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            } else {
//                try {
//                    startGrid = StartGrid.deserializeJsonStringToStartGrid("1020;");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        solver = new Solver(NUM_ROWS, NUM_COLS);
//    }
//
//    private void setLevel(int lvl) {
//        level_num = lvl;
//    }
//
//    private void resetTimer() {
//        level_time = 0;
//        tvLevelTime.setText(String.format("%d", level_time));
//    }
//
//    private void resetNumMoves() {
//        num_moves = 0;
//        tvNumMoves.setText(String.format("%d", num_moves));
//    }
//
//    private void activateButton(int x, int y) {
//        light_states[x][y] = Boolean.TRUE;
//        lights[x][y].setBackgroundColor(Color.RED);
//    }
//
//    private void deactivateButton(int x, int y) {
//        light_states[x][y] = Boolean.FALSE;
//        lights[x][y].setBackgroundColor(Color.WHITE);
//    }
//
//    private void flipLight(int x, int y) {
//        if (isLightActive(x, y))
//            deactivateButton(x, y);
//        else
//            activateButton(x, y);
//    }
//
//    public boolean isLightOutOfBounds(int x, int y) {
//        return (x >= NUM_ROWS || x < 0 || y >= NUM_COLS || y < 0);
//    }
//
//    private boolean isLightActive(int x, int y) {
//        return (light_states[x][y] == Boolean.TRUE);
//    }
//
//    private void pressedLights(int x, int y) {
//        int top = x - 1;
//        int bot = x + 1;
//        int left = y - 1;
//        int right = y + 1;
//
//        flipLight(x, y);
//
//        if (!isLightOutOfBounds(top, y))
//            flipLight(top, y);
//
//
//        if (!isLightOutOfBounds(bot, y))
//            flipLight(bot, y);
//
//
//        if (!isLightOutOfBounds(x, left))
//            flipLight(x, left);
//
//
//        if (!isLightOutOfBounds(x, right))
//            flipLight(x, right);
//
//    }
//
//    private void clearBoard() {
//        for (int i = 0; i < NUM_ROWS; i++) {
//            for (int j = 0; j < NUM_COLS; j++) {
//                deactivateButton(i, j);
//            }
//        }
//        resetTimer();
//        resetNumMoves();
//    }
//
//    private void setupBoard() {
//
//        clearBoard();
//        clearSolution();
//
//
//        // changed to use the passed in startgrid to initialize
//        for (Pair<Integer, Integer> pair : startGrid.startGrid) {
//            int x = pair.first;
//            int y = pair.second;
//            activateButton(x, y);
//        }
//    }
//
//    private boolean checkVictory() {
//        for (int i = 0; i < NUM_ROWS; i++) {
//            for (int j = 0; j < NUM_COLS; j++) {
//                if (isLightActive(i, j)) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    private void setupVariables(View view) {
//
//        TableLayout table = (TableLayout) view.findViewById(R.id.tbRandom);
//
//        bHome = (Button) view.findViewById(R.id.bHome);
//        bHome.setOnClickListener(this);
//
//        bReset = (Button) view.findViewById(R.id.bReset);
//        bReset.setOnClickListener(this);
//
//        bHint = (Button) view.findViewById(R.id.bHint);
//        bHint.setOnClickListener(this);
//
//        tvNumMoves = (TextView) view.findViewById(R.id.tvNumMoves);
//        tvLevelTime = (TextView) view.findViewById(R.id.tvLevelTime);
//
//        for (int i = 0; i < NUM_ROWS; i++) {
//            TableRow tableRow = new TableRow(getActivity());
//            tableRow.setLayoutParams(new TableLayout.LayoutParams(
//                    TableLayout.LayoutParams.MATCH_PARENT,
//                    TableLayout.LayoutParams.MATCH_PARENT,
//                    1.0f
//            ));
//            table.addView(tableRow);
//            for (int j = 0; j < NUM_COLS; j++) {
//
//                final int x = i;
//                final int y = j;
//                Button button = new Button(getActivity());
//                button.setLayoutParams(new TableRow.LayoutParams(
//                        TableRow.LayoutParams.MATCH_PARENT,
//                        TableRow.LayoutParams.MATCH_PARENT,
//                        1.0f
//                ));
//
//                button.setText("" + x + "," + y);
//                // make text not clip on small buttons
//                button.setPadding(0, 0, 0, 0);
//                button.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        Button button = lights[x][y];
//
//                        if (button.isPressed()) {
//                            pressedLights(x, y);
//                            clearSolution();
//                            num_moves++;
//                            tvNumMoves.setText(String.format("%d", num_moves));
//                            tvLevelTime.setText(String.format("%d", level_time));
//                        }
//
//                        if (checkVictory()) {
//                            // go back to activity and check the stage as completed
//                            // TODO : victory dance
//                            level_num++;
//                            if (level_num <= Levels.getLevels(NUM_ROWS, NUM_COLS).length) {
//                                setLevel(level_num);
//                                setupBoard();
//                            } else {
//                                // TODO
//                            }
//                        }
//
//                    }
//                });
//
//                tableRow.addView(button);
//                lights[x][y] = button;
//
//            }
//        }
//
//        setupBoard();
//
//    }
//
//    private void clearSolution() {
//        for (int i = 0; i < NUM_ROWS; i++) {
//            for (int j = 0; j < NUM_COLS; j++) {
//                lights[i][j].setTextColor(Color.BLACK);
//            }
//        }
//    }
//
//    private void showSolution() {
//        boolean[][] solution = solver.calculateWinningConfig(light_states);
//
//        for (int i = 0; i < NUM_ROWS; i++) {
//            for (int j = 0; j < NUM_COLS; j++) {
//                if (solution[i][j] == Boolean.TRUE)
//                    lights[i][j].setTextColor(Color.YELLOW);
//            }
//        }
//
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.random, container, false);
//        setupVariables(view);
//        return view;
//    }
//
//
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(3);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    @Override
//    public void onClick(View v) {
//
//        if (bReset.isPressed()) {
//            setupBoard();
//        }
//
//        if (bHint.isPressed()) {
//            showSolution();
//        }
//
//    }
//
//    public interface OnFragmentInteractionListener {
//        void onFragmentInteraction(int i);
//    }
//}
