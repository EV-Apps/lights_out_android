package com.captainhampton.android.lightsout.model;

import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;

import com.captainhampton.android.lightsout.solver.Levels;

import java.io.IOException;
import java.util.ArrayList;

public class DatabaseLevelHelper {

    public static void populateDatabase(SQLiteDatabase db, ArrayList<Pair<Integer, Integer>> levelList) {
        for (Pair<Integer, Integer> pair : levelList) {
            long level = createLevel(db, pair.first, pair.second, false);
            ArrayList<ArrayList<Pair<Integer, Integer>>> levelWithStages = Levels.transformLevelToList(pair.first, pair.second);

            int numOfStages = levelWithStages.size();
            // start at 1 because the the 0 stage should be unlocked
            String serializedLevel = getSerializedString(levelWithStages, 0);
            if (serializedLevel != null) {
                createStage(db, pair.first, pair.second, false, level, serializedLevel);
                for (int i = 1; i < numOfStages; ++i) {
                    serializedLevel = getSerializedString(levelWithStages, i);
                    if (serializedLevel != null) {
                        createStage(db, pair.first, pair.second, true, level, serializedLevel);
                    }
                }
            }
        }
    }

    public static String getSerializedString(ArrayList<ArrayList<Pair<Integer, Integer>>> levelWithStages, int index) {
        try {
            return StartGrid.createSerializedWithGrid(levelWithStages.get(index));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static long createLevel(SQLiteDatabase db, int rows, int cols, boolean isLocked) {
        long level = db.insert(Level.TABLE_NAME, null, new Level.Marshal()
                .is_locked(isLocked)
                .name(String.valueOf(rows) + "x" + String.valueOf(cols))
                .num_cols(cols)
                .num_rows(rows)
                .asContentValues());
        return level;
    }

    public static SQLiteDatabase createStage(SQLiteDatabase db, int rows, int cols, boolean isLocked, long level, String jsonStartGridSerialized) {
        db.insert(Stage.TABLE_NAME, null, new Stage.Marshal()
                .num_cols(cols)
                .num_rows(rows)
//                .is_locked(true) // should default to is_locked BOOLEAN NOT NULL DEFAULT 1
                .level(level)
                .start_grid(jsonStartGridSerialized)
                .asContentValues());
        return db;
    }
}
