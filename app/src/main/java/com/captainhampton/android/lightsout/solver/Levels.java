package com.captainhampton.android.lightsout.solver;


import android.support.v4.app.INotificationSideChannel;
import android.support.v4.util.Pair;

import java.util.ArrayList;

public class Levels {

    public static final int[][][] LEVELS_3x3 = {
            {{0, 1}, {1, 0}, {1, 1}, {1, 2}, {2, 1}},
            {{0, 0}, {0, 1}, {1, 0}},
            {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}},
            {{0, 0}, {0, 1}, {1, 1}, {1, 2}, {2, 0}},
            {{0, 0}, {0, 2}, {1, 1}, {1, 2}, {2, 0}, {2, 1}},
            {{0, 1}, {1, 1}, {2, 1}},
            {{0, 0}, {0, 1}, {1, 2}, {2, 2}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 1}},
            {{0, 2}, {1, 1}, {1, 2}, {2, 1}, {2, 2}},
            {{0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 1}},
            {{0, 1}, {1, 2}, {2, 1}},
            {{0, 1}, {0, 2}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            {{1, 0}, {1, 1}, {2, 1}},
            {{0, 1}, {1, 0}, {1, 2}, {2, 0}, {2, 1}},
            {{1, 0}, {2, 0}},
    };


    public static final int[][][] LEVELS_3x4 = {
            {{0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 2}, {2, 3}},
            {{0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}},
            {{1, 1}, {1, 3}, {2, 2}, {2, 3}},
    };

    public static final int[][][] LEVELS_4x3 = {
            {{1, 1}, {2, 1}, {2, 0}, {3, 1}, {2, 2}},
            {{0, 0}, {0, 1}, {1, 0}, {2, 2}, {3, 1}, {3, 2}},
    };

    public static final int[][][] LEVELS_4x4 = {
            {{0, 0}, {0, 1}, {1, 0}},
            {{0, 0}, {0, 1}, {1, 0}, {0, 2}, {0, 3}, {1, 3}},
            {{0, 0}, {0, 1}, {1, 0}, {0, 2}, {0, 3}, {1, 3}, {2, 0}, {3, 0}, {3, 1}, {2, 3}, {3, 2}, {3, 3}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {2, 0}, {2, 1}, {3, 0}},
            {{0, 0}, {0, 2}, {0, 3}, {1, 3}, {2, 0}, {2, 1}, {2, 2}, {2, 3}, {3, 3}},
            {{0, 3}, {1, 0}, {1, 2}, {1, 3}, {3, 0}, {3, 3}},
            {{0, 0}, {0, 1}, {1, 1}, {1, 2}, {2, 2}, {3, 1}},
            {{0, 3}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {3, 2}, {3, 3}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {1, 3}, {2, 0}, {2, 1}, {2, 2}, {2, 3}, {3, 3}},
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}, {1, 1}, {1, 2}, {1, 3}, {2, 2}, {2, 3}, {3, 1}, {3, 2}, {3, 3}},
            {{0, 1}, {0, 3}, {1, 0}, {1, 3}, {2, 3}, {3, 0}, {3, 1}, {3, 2}, {3, 3}},
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}, {1, 0}, {1, 2}, {1, 3}, {2, 0}, {2, 3}, {3, 1}, {3, 2}, {3, 3}},
    };

    public static final int[][][] LEVELS_5x5 = {
            {{1, 2}, {2, 1}, {2, 2}, {2, 3}, {3, 2}},
            {{1, 0}, {1, 4}, {2, 0}, {2, 1}, {2, 3}, {2, 4}, {3, 0}, {3, 4}},
            {{0, 3}, {0, 4}, {1, 2}, {1, 4}, {2, 1}, {2, 2}, {2, 3}, {3, 0}, {3, 2}, {4, 0}, {4, 1}},
            {{0, 0}, {0, 1}, {0, 3}, {0, 4}, {1, 0}, {1, 4}, {3, 0}, {3, 4}, {4, 0}, {4, 1}, {4, 3}, {4, 4}},
            {{0, 0}, {0, 1}, {0, 3}, {0, 4}, {1, 0}, {1, 2}, {1, 4}, {2, 1}, {2, 2}, {2, 3}, {3, 0}, {3, 2}, {3, 4}, {4, 0}, {4, 1}, {4, 3}, {4, 4}},
            {{2, 0}, {2, 2}, {2, 4}},
            {{0, 0}, {0, 2}, {0, 4}, {1, 0}, {1, 2}, {1, 4}, {3, 0}, {3, 2}, {3, 4}, {4, 0}, {4, 2}, {4, 4}},
            {{0, 1}, {0, 3}, {1, 0}, {1, 1}, {1, 3}, {1, 4}, {2, 0}, {2, 1}, {2, 3}, {2, 4}, {3, 0}, {3, 1}, {3, 3}, {3, 4}, {4, 1}, {4, 3}},
            {{1, 0}, {1, 1}, {1, 3}, {1, 4}, {3, 0}, {3, 4}, {4, 0}, {4, 1}, {4, 3}, {4, 4}},
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}, {1, 0}, {1, 1}, {1, 2}, {1, 4}, {2, 0}, {2, 1}, {2, 2}, {2, 4}, {3, 3}, {3, 4}, {4, 0}, {4, 1}, {4, 3}, {4, 4}},
            {{2, 0}, {2, 2}, {2, 4}, {3, 0}, {3, 2}, {3, 4}, {4, 1}, {4, 2}, {4, 3}},
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}, {1, 0}, {1, 4}, {2, 0}, {2, 4}, {3, 0}, {3, 4}, {4, 0}, {4, 1}, {4, 2}, {4, 3}},
            {{1, 2}, {2, 1}, {2, 3}, {3, 0}, {3, 2}, {3, 4}, {4, 1}, {4, 3}},
            {{0, 1}, {0, 3}, {1, 0}, {1, 1}, {1, 2}, {1, 3}, {1, 4}, {2, 1}, {2, 2}, {2, 3}, {3, 1}, {3, 3}, {3, 4}, {4, 0}, {4, 1}, {4, 2}},
            {{0, 1}, {0, 2}, {0, 3}, {1, 1}, {1, 2}, {1, 3}, {2, 1}, {2, 2}, {2, 3}},
            {{0, 0}, {0, 2}, {0, 4}, {1, 0}, {1, 2}, {1, 4}, {2, 0}, {2, 2}, {2, 4}, {3, 0}, {3, 2}, {3, 4}, {4, 1}, {4, 2}, {4, 3}},
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4}, {1, 1}, {1, 3}, {2, 0}, {2, 1}, {2, 3}, {2, 4}, {3, 1}, {3, 2}, {3, 3}, {4, 1}, {4, 3}},
            {{0, 3}, {1, 2}, {1, 4}, {2, 1}, {2, 3}, {3, 0}, {3, 2}, {4, 1}},
            {{2, 1}, {3, 1}, {4, 1}},
    };

    public static final int[][][] LEVELS_6x6 = {
            {{0, 0}, {0, 1}, {1, 0}},
            {{1, 2}, {2, 1}, {2, 2}, {2, 3}, {3, 2}},
            {{0, 0}, {0, 1}, {0, 4}, {0, 5}, {1, 0}, {1, 5}},
            {{0, 0}, {0, 1}, {0, 4}, {0, 5}, {1, 0}, {1, 5}, {4, 0}, {4, 5}, {5, 0}, {5, 1}, {5, 4}, {5, 5}},
            {{0, 2}, {0, 3}, {0, 4}, {1, 0}, {1, 1}, {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, {3, 0}, {3, 1}, {3, 3}, {3, 4}, {5, 1}, {5, 4}, {5, 5}},
            {{0, 1}, {0, 2}, {0, 3}, {1, 0}, {1, 2}, {1, 3}, {1, 4}, {2, 0}, {2, 1}, {2, 2}, {2, 4}, {2, 5}, {3, 0}, {3, 4}, {3, 5}, {4, 0}, {4, 1}, {4, 4}, {5, 0}, {5, 3}, {5, 4}},
    };

    public static int[][][] getLevels(int numRows, int numCols) {

        if (numRows == 3 && numCols == 3)
            return LEVELS_3x3;

        if (numRows == 3 && numCols == 4)
            return LEVELS_3x4;

        if (numRows == 4 && numCols == 3)
            return LEVELS_4x3;

        if (numRows == 4 && numCols == 4)
            return LEVELS_4x4;

        if (numRows == 5 && numCols == 5)
            return LEVELS_5x5;

        if (numRows == 6 && numCols == 6)
            return LEVELS_6x6;

        // TODO: FIX THIS DEFAULT RETURN STATEMENT
        return LEVELS_5x5;

    }

    public static ArrayList<ArrayList<Pair<Integer, Integer>>> transformLevelToList(int numRows, int numCols) {
        int[][][] level = getLevels(numRows, numCols);

        int avgNumbersOfLightsPerStage = 8; // arraylist will resize accordingly

        ArrayList<ArrayList<Pair<Integer, Integer>>> levels = new ArrayList<>(level.length);
        ArrayList<Pair<Integer, Integer>> stage = new ArrayList<>(avgNumbersOfLightsPerStage);

        for (int a = 0; a < level.length-1; ++a) {
            for (int b = 0; b < level[a].length-1; ++b) {
                stage.add(new Pair<>(level[a][b][0], level[a][b][1]));
            }
            levels.add(stage);
        }
        return levels;
    }
}

// found better way

//    public static final ArrayList<ArrayList<Pair<Integer, Integer>>> LEVELS_3X3 = new ArrayList<>(16);
//
//    public static final ArrayList<Pair<Integer, Integer>> LEVEL_3x3_A = new ArrayList<>(5);
//    public static final ArrayList<Pair<Integer, Integer>> LEVEL_3x3_B = new ArrayList<>(3);
//    public static final ArrayList<Pair<Integer, Integer>> LEVEL_3x3_C = new ArrayList<>(6);
//    public static final ArrayList<Pair<Integer, Integer>> LEVEL_3x3_D = new ArrayList<>(5);
//    public static final ArrayList<Pair<Integer, Integer>> LEVEL_3x3_E = new ArrayList<>(6);
//    public static final ArrayList<Pair<Integer, Integer>> LEVEL_3x3_F = new ArrayList<>(3);
//    public static final ArrayList<Pair<Integer, Integer>> LEVEL_3x3_G = new ArrayList<>(4);
//    public static final ArrayList<Pair<Integer, Integer>> LEVEL_3x3_H = new ArrayList<>(6);
//    public static final ArrayList<Pair<Integer, Integer>> LEVEL_3x3_I = new ArrayList<>(5);
//    public static final ArrayList<Pair<Integer, Integer>> LEVEL_3x3_J = new ArrayList<>(6);
//    public static final ArrayList<Pair<Integer, Integer>> LEVEL_3x3_K = new ArrayList<>(3);
//    public static final ArrayList<Pair<Integer, Integer>> LEVEL_3x3_L = new ArrayList<>(7);
//    public static final ArrayList<Pair<Integer, Integer>> LEVEL_3x3_M = new ArrayList<>(3);
//    public static final ArrayList<Pair<Integer, Integer>> LEVEL_3x3_N = new ArrayList<>(4);
//    public static final ArrayList<Pair<Integer, Integer>> LEVEL_3x3_O = new ArrayList<>(2);
//static{
//        LEVEL_3x3_A.add(new Pair<>(0,1));
//        LEVEL_3x3_A.add(new Pair<>(1,0));
//        LEVEL_3x3_A.add(new Pair<>(1,1));
//        LEVEL_3x3_A.add(new Pair<>(0,2));
//        LEVEL_3x3_A.add(new Pair<>(2,1));
//
//        LEVELS_3X3.add(LEVEL_3x3_A);
//
//
//
//        { {0,1}, {1,0}, {1,1}, {1,2}, {2,1} },
//        { {0,0}, {0,1}, {1,0} },
//        { {0,0}, {0,1}, {1,0}, {1,2}, {2,1}, {2,2} },
//        { {0,0}, {0,1}, {1,1}, {1,2}, {2,0} },
//        { {0,0}, {0,2}, {1,1}, {1,2}, {2,0}, {2,1} },
//        { {0,1}, {1,1}, {2,1} },
//        { {0,0}, {0,1}, {1,2}, {2,2} },
//        { {0,0}, {0,1}, {0,2}, {1,2}, {2,0}, {2,1} },
//        { {0,2}, {1,1}, {1,2}, {2,1}, {2,2} },
//        { {0,0}, {0,1}, {1,0}, {1,1}, {2,0}, {2,1} },
//        { {0,1}, {1,2}, {2,1} },
//        { {0,1}, {0,2}, {1,1}, {1,2}, {2,0}, {2,1}, {2,2}  },
//        { {1,0}, {1,1}, {2,1} },
//        { {0,1}, {1,0}, {1,2}, {2,0}, {2,1} },
//        { {1,0}, {2,0} },
//        };
