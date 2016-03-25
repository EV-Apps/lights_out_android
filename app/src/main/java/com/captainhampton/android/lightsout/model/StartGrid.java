package com.captainhampton.android.lightsout.model;


import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;
import java.util.ArrayList;

public class StartGrid {

    private static final Moshi moshi = new Moshi.Builder().build();
    private static final JsonAdapter<StartGrid> jsonAdapter = moshi.adapter(StartGrid.class);


    public ArrayList<Integer[]> startGrid; // testing if Integer[] will work without a converter(note int[] does not work, must be a type for generics)
    // may need a converter for the Pair data structure

    // need to set the startGrid after the deserialization

    public static StartGrid parseJsonStringToStartGrid(String jsonString) throws IOException {
        return jsonAdapter.fromJson(jsonString);
    }

    public static String serializeStartGridToJsonString(StartGrid startGridToSerialize) throws IOException {
        return jsonAdapter.toJson(startGridToSerialize);
    }

}
