package com.captainhampton.android.lightsout.model;


import android.util.Pair;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;
import java.util.ArrayList;

public class StartGrid {

//    private static final Moshi moshi = new Moshi.Builder().add(new ArrayListPairAdapter()).build();


    public ArrayList<Pair<Integer, Integer>> startGrid = new ArrayList<>();
    // Integer[] does not work, will try raw type
    // testing if Integer[] will work without a converter(note int[] does not work, must be a type for generics)
    // may need a converter for the Pair data structure

    // need to set the startGrid after the deserialization

    public static StartGrid deserializeJsonStringToStartGrid(String jsonString) throws IOException {
        Moshi moshi = new Moshi.Builder().add(new ArrayListPairAdapter()).build(); // testing these here instead of in
        // the class scope
        JsonAdapter<StartGrid> jsonAdapter = moshi.adapter(StartGrid.class);
        return jsonAdapter.fromJson(jsonString);
    }

    public static String serializeStartGridToJsonString(StartGrid startGridToSerialize) throws IOException {
        Moshi moshi = new Moshi.Builder().add(new ArrayListPairAdapter()).build();
        JsonAdapter<StartGrid> jsonAdapter = moshi.adapter(StartGrid.class);
        String jsonString = jsonAdapter.toJson(startGridToSerialize);
        return jsonString;
    }

    public static StartGrid createWithGrid(int[][] arrayGrid) {
        StartGrid sg = new StartGrid();
        for (int i = 0; i < arrayGrid.length; i++) {
            Pair<Integer, Integer> pair = new Pair<>(arrayGrid[i][0], arrayGrid[i][1]);
            sg.startGrid.add(pair);
        }
        return sg;
    }

    public static String createSerializedWithGrid(int[][] arrayGrid) throws IOException {
        StartGrid sg = createWithGrid(arrayGrid);
        String jsonString = StartGrid.serializeStartGridToJsonString(sg);
        return jsonString;
    }

}
