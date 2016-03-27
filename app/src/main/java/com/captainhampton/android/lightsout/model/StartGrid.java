package com.captainhampton.android.lightsout.model;


import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;
import java.util.ArrayList;

public class StartGrid {

    private static final Moshi moshi = new Moshi.Builder().build();


    public ArrayList startGrid;
    // Integer[] does not work, will try raw type
    // testing if Integer[] will work without a converter(note int[] does not work, must be a type for generics)
    // may need a converter for the Pair data structure

    // need to set the startGrid after the deserialization

    public static StartGrid deserializeJsonStringToStartGrid(String jsonString) throws IOException {
        JsonAdapter<StartGrid> jsonAdapter = moshi.adapter(StartGrid.class);
        return jsonAdapter.fromJson(jsonString);
    }

    public static String serializeStartGridToJsonString(StartGrid startGridToSerialize) throws IOException {
        JsonAdapter<StartGrid> jsonAdapter = moshi.adapter(StartGrid.class);
        return jsonAdapter.toJson(startGridToSerialize);
    }

    public static StartGrid createWithGrid(int[][] arrayGrid) {
        StartGrid sg = new StartGrid();
        Integer[] ar = new Integer[2];
        for (int i = 0; i < arrayGrid.length; i++) {
            ar[0] = arrayGrid[i][0];
            ar[1] = arrayGrid[i][1];
            sg.startGrid.add(ar);
        }
        return sg;
    }

    public static String createSerializedWithGrid(int[][] arrayGrid) throws IOException {
        return StartGrid.serializeStartGridToJsonString(
                createWithGrid(arrayGrid));
    }

}
