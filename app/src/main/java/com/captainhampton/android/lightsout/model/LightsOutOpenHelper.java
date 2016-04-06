package com.captainhampton.android.lightsout.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.captainhampton.android.lightsout.solver.Levels;

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

        // do we need to check if db is created or will onCreate only be called once

        // Populate initial data
        // can't use this, use levels list to get the cols and rows
        DatabaseLevelHelper.populateDatabase(db, Levels.levelList);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

