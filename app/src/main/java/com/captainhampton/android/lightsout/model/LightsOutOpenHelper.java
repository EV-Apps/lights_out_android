package com.captainhampton.android.lightsout.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

        db.insert(Stage.TABLE_NAME, null, new Stage.Marshal()
                .num_cols(3)
                .num_rows(3)
                .is_locked(false)
                .level(threeXthree)
                .start_grid(StartGrid.serializeStartGridToJsonString(new StartGrid()))
                // TODO put this in a loop, and give StartGrid a public static method constructor that takes
                // TODO in the arrayList of integer[] pairs
                .asContentValues());
        long getzlaf = db.insert(Player.TABLE_NAME, null, new Player.Marshal()
                .first_name("Ryan")
                .last_name("Getzlaf")
                .number(15)
                .age(30)
                .position(Player.Position.CENTER)
                .shoots(Player.Shoots.RIGHT)
                .weight(221)
                .team(ducks)
                .asContentValues());
        db.update(Team.TABLE_NAME, new Team.Marshal().captain(getzlaf).asContentValues(),
                Team._ID + "=" + ducks, new String[0]);

        long pens = db.insert(Team.TABLE_NAME, null, new Team.Marshal()
                .coach("Mike Sullivan")
                .name("Pittsburgh Penguins")
                .won_cup(true)
                .asContentValues());
        long crosby = db.insert(Player.TABLE_NAME, null, new Player.Marshal()
                .first_name("Sidney")
                .last_name("Crosby")
                .number(87)
                .age(28)
                .position(Player.Position.CENTER)
                .shoots(Player.Shoots.LEFT)
                .weight(200)
                .team(pens)
                .asContentValues());
        db.update(Team.TABLE_NAME, new Team.Marshal().captain(crosby).asContentValues(),
                Team._ID + "=" + pens, new String[0]);

        long sharks = db.insert(Team.TABLE_NAME, null, new Team.Marshal()
                .coach("Peter DeBoer")
                .name("San Jose Sharks")
                .won_cup(false)
                .asContentValues());
        db.insert(Player.TABLE_NAME, null, new Player.Marshal()
                .first_name("Patrick")
                .last_name("Marleau")
                .number(12)
                .age(36)
                .position(Player.Position.LEFT_WING)
                .shoots(Player.Shoots.LEFT)
                .weight(220)
                .team(sharks)
                .asContentValues());
        long pavelski = db.insert(Player.TABLE_NAME, null, new Player.Marshal()
                .first_name("Joe")
                .last_name("Pavelski")
                .number(8)
                .age(31)
                .position(Player.Position.CENTER)
                .shoots(Player.Shoots.RIGHT)
                .weight(194)
                .team(sharks)
                .asContentValues());

        db.update(Level.TABLE_NAME, new Level.Marshal().captain(pavelski).asContentValues(),
                Team._ID + "=" + sharks, new String[0]);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
}
