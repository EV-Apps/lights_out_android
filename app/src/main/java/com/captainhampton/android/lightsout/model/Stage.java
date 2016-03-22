package com.captainhampton.android.lightsout.model;


import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Stage implements StageModel {

    public static final Mapper<Stage> MAPPER = new Mapper<>(new Mapper.Creator<Stage>() {
        @Override
        public Stage create(long Id, int numRows, int numCols, boolean isLocked, Long level, String startGrid) {
            return new AutoValue_Stage(Id, numRows, numCols, isLocked, level, startGrid);
        }
    });
}


/*
Todo Serialize the Arraylist<Pair<Integer, Integer>> for each stage's inital layout, do we need to create an initial layout class type, probably not
Todo after serialization, save the json string in the stage object, be sure to have the stage object point to the correct level
Todo do we need to have an enum in the level with the MxN, hard coded as a compile time type?
https://github.com/bluelinelabs/LoganSquare/blob/master/docs/TypeConverters.md#types-with-built-in-support
https://github.com/square/sqldelight
https://github.com/google/auto/tree/master/value#how-to-use-autovalue
*/