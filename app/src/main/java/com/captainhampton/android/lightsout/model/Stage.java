package com.captainhampton.android.lightsout.model;

import android.support.v4.util.Pair;

import com.google.auto.value.AutoValue;

import java.util.ArrayList;
import java.util.Collections;

//
//@AutoValue
//public abstract class Stage implements StageModel {
//
//    public static final Mapper<Stage> MAPPER = new Mapper<>(new Mapper.Creator<Stage>(){
//        @Override public Level create(long Id, int numRows, int numCols, boolean isLocked){
//            return new AutoValue_Level(Id, numRows, numCols, isLocked);
//        }
//    });
//}


public class Stage {

    private int avgNumOfLightsOn = 8;
    private ArrayList<Pair<Integer, Integer>> lightsOnList = new ArrayList<>(avgNumOfLightsOn);

    public Stage(){ // lights on is the array of Pair<Integer,Integer>
//        lightsOnList = Arrays.asList(lightsOn);
    }

    public ArrayList<Pair<Integer, Integer>> getLightsOnList() {
        ArrayList<Pair<Integer, Integer>> copyList = new ArrayList<>(lightsOnList.size());
        Collections.copy(copyList, lightsOnList);
        return copyList;
    }

}

/*
Todo Serialize the Arraylist<Pair<Integer, Integer>> for each stage's inital layout, do we need to create an initial layout class type, probably not
Todo after serialization, save the json string in the stage object, be sure to have the stage object point to the correct level
Todo do we need to have an enum in the level with the MxN, hard coded as a compile time type?
https://github.com/bluelinelabs/LoganSquare/blob/master/docs/TypeConverters.md#types-with-built-in-support
https://github.com/square/sqldelight
https://github.com/google/auto/tree/master/value#how-to-use-autovalue
*/