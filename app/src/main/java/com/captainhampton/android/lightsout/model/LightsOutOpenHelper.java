package com.captainhampton.android.lightsout.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.IOException;

public final class LightsOutOpenHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static LightsOutOpenHelper instance;

    public LightsOutOpenHelper(Context context) {
        super(context, null, null, DATABASE_VERSION);
    }

    public static LightsOutOpenHelper getInstance(Context context) {
        if (instance == null) {
            instance = new LightsOutOpenHelper(context);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Level.CREATE_TABLE);
        db.execSQL(Stage.CREATE_TABLE);

        // Populate initial data


        long threeXthree = db.insert(Level.TABLE_NAME, null, new Level.Marshal()
                .is_locked(false)
                .name("3x3")
                .num_cols(3)
                .num_rows(3)
                .asContentValues());

        String test = null;
        try {
            test = StartGrid.createSerializedWithGrid(
                    new int[][]{{0, 1}, {1, 0}, {1, 1}, {1, 2}, {2, 1}});
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (test == null) {
            Log.d("openhelper", "onCreate: teststring for startgrid is null");
        }

        db.insert(Stage.TABLE_NAME, null, new Stage.Marshal()
                .num_cols(3)
                .num_rows(3)
                .is_locked(false)
                .level(threeXthree)
                .start_grid(test)
                .asContentValues());
                // TODO put this in a loop, and give StartGrid a public static method constructor that takes
                // TODO in the arrayList of integer[] pairs
//        long getzlaf = db.insert(Player.TABLE_NAME, null, new Player.Marshal()
//                .first_name("Ryan")
//                .last_name("Getzlaf")
//                .number(15)
//                .age(30)
//                .position(Player.Position.CENTER)
//                .shoots(Player.Shoots.RIGHT)
//                .weight(221)
//                .team(ducks)
//                .asContentValues());

//        db.update(Level.TABLE_NAME, new Level.Marshal().captain(getzlaf).asContentValues(),
//                Team._ID + "=" + ducks, new String[0]);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

