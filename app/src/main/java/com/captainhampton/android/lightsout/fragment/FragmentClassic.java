package com.captainhampton.android.lightsout.fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.captainhampton.android.lightsout.R;
import com.captainhampton.android.lightsout.solver.Levels;
import com.captainhampton.android.lightsout.solver.Solver;


public class FragmentClassic extends Fragment implements OnClickListener {

    public static final String TAG = "FragmentClassic";
    private static final int[][] LIGHT_IDS = {
            { R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4 },
            { R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9 },
            { R.id.button10, R.id.button11, R.id.button12, R.id.button13, R.id.button14 },
            { R.id.button15, R.id.button16, R.id.button17, R.id.button18, R.id.button19 },
            { R.id.button20, R.id.button21, R.id.button22, R.id.button23, R.id.button24 },
    };
    private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 5;
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public Button bHome, bHint, bReset;
    public TextView tvNumMoves, tvLevelTime;
    private Button[][] lights = new Button[NUM_ROWS][NUM_COLS];
    private boolean[][] light_states = new boolean[NUM_ROWS][NUM_COLS];
    private int level_num = 0;
    private int num_moves;
    private long level_time; // System.nanoTime()
    private Solver solver;
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    public FragmentClassic() {
        // Required empty public constructor
    }

    public static FragmentClassic newInstance(String param1, String param2) {
        FragmentClassic fragment = new FragmentClassic();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        solver = new Solver(NUM_ROWS, NUM_COLS, this);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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
            deactivateButton(x,y);
        else
            activateButton(x, y);
    }

    public boolean isLightOutOfBounds(int x, int y) {
        return ( x >= NUM_ROWS || x < 0 || y >= NUM_COLS || y < 0 );
    }

    private boolean isLightActive(int x, int y) {
        return ( light_states[x][y] == Boolean.TRUE );
    }

    private void pressedLights(int x, int y) {
        int top = x - 1;
        int bot = x + 1;
        int left = y - 1;
        int right = y + 1;

        flipLight(x,y);

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


        for (int i = 0; i < Levels.getLevels(NUM_ROWS,NUM_COLS)[level_num].length; i++) {
            int x = Levels.getLevels(NUM_ROWS,NUM_COLS)[level_num][i][0];
            int y = Levels.getLevels(NUM_ROWS,NUM_COLS)[level_num][i][1];

            activateButton(x, y);
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

    private void setupVariables(View view) {

        bHome = (Button)view.findViewById(R.id.bHome);
        bHome.setOnClickListener(this);

        bReset = (Button)view.findViewById(R.id.bReset);
        bReset.setOnClickListener(this);

        bHint = (Button)view.findViewById(R.id.bHint);
        bHint.setOnClickListener(this);

        tvNumMoves = (TextView)view.findViewById(R.id.tvNumMoves);
        tvLevelTime = (TextView)view.findViewById(R.id.tvLevelTime);

        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {

                final int x = i;
                final int y = j;
                lights[x][y] = (Button)view.findViewById(LIGHT_IDS[x][y]);
                lights[x][y].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (lights[x][y].isPressed()) {
                            pressedLights(x, y);
                            clearSolution();
                            num_moves++;
                            tvNumMoves.setText(String.format("%d", num_moves));
                            tvLevelTime.setText(String.format("%d", level_time));
                        }

                        if ( checkVictory() ) {
                            // TODO : victory dance
                            level_num++;
                            if (level_num <= Levels.getLevels(NUM_ROWS,NUM_COLS).length) {
                                setLevel(level_num);
                                setupBoard();
                            } else {
                                // TODO
                            }
                        }

                    }
                });

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.classic, container, false);
        setupVariables(view);
        return view;
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(3);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(int i);
    }
}
