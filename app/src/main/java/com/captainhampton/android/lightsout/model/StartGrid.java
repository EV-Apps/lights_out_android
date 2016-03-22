package com.captainhampton.android.lightsout.model;

import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import com.bluelinelabs.logansquare.annotation.OnJsonParseComplete;
import com.bluelinelabs.logansquare.annotation.OnPreJsonSerialize;

import java.io.IOException;
import java.util.ArrayList;

@JsonObject
public class StartGrid {

    @JsonField(name = "lights_on")
    public ArrayList<Integer[]> lightsOn; // testing if Integer[] will work without a converter(note int[] does not work)
    // may need a converter for the Pair data structure

    public static StartGrid parseJsonStringToStartGrid(String jsonString) throws IOException {
        return LoganSquare.parse(jsonString, StartGrid.class);
    }

    public static String serializeStartGridToJsonString(StartGrid startGridToSerialize) throws IOException {
        return LoganSquare.serialize(startGridToSerialize);
    }

    @OnJsonParseComplete
    void onParseComplete() {
    }

    @OnPreJsonSerialize
    void onPreSerialize() {
    }
}
