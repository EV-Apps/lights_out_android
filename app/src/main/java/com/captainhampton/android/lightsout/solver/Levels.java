package com.captainhampton.android.lightsout.solver;


import android.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;

public class Levels {

    public static final ArrayList<Pair<Integer, Integer>> levelList = new ArrayList<>(6);
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

    static {
        // 6x6 keeps appearing as the first, while the others retain their order
        levelList.add(new Pair<>(3, 4));
        levelList.add(new Pair<>(4, 3));
        levelList.add(new Pair<>(4, 4));
        levelList.add(new Pair<>(5, 5));
        levelList.add(new Pair<>(6, 6));
        levelList.add(new Pair<>(3, 3));
        // hack to get the first element to be 3x3 by placing in the last slot
//        Collections.sort(levelList, new PairComparator());
        // see attempt to commit each fragment one by one in ActivityLevelSelect
    }

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
        int[][][] levels = getLevels(numRows, numCols);

        int avgNumbersOfLightsPerStage = 8; // arraylist will resize accordingly

        ArrayList<ArrayList<Pair<Integer, Integer>>> level = new ArrayList<>(levels.length);
        ArrayList<Pair<Integer, Integer>> stage = new ArrayList<>(avgNumbersOfLightsPerStage);

        for (int a = 0; a < levels.length; ++a) {
            for (int b = 0; b < levels[a].length - 1; ++b) {
                stage.add(new Pair<>(levels[a][b][0], levels[a][b][1]));
            }
            level.add(stage);
        }
        return level;
    }

    public static ArrayList<Boolean> getStagesListOfIsLocked(int numRows, int numCols) {
        int[][][] levels = getLevels(numRows, numCols);

        ArrayList<Boolean> stage = new ArrayList<>(levels[0].length);

        stage.add(false); // the first level should not be locked, start loop at 1

        for (int b = 1; b < levels[0].length - 1; ++b) {
            stage.add(true);
        }
        return stage;
    }

    static class PairComparator implements Comparator<Pair<Integer, Integer>> {

        @Override
        public int compare(Pair<Integer, Integer> lhs, Pair<Integer, Integer> rhs) {
            return
                    lhs.first < rhs.first ? -1 : // lhs is less than
                            lhs.first > rhs.first ? 1 : // rhs is less than
                                    lhs.second < rhs.second ? -1 : 1; // first are equal, compare second
        }
    }
}
