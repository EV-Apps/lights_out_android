package com.evapps.lightsout.model;

import android.util.Pair;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

// CLASS NOT USED see ArrayListPairAdapter.java

public class PairAdapter {

    // serialization still not working, this class should not be a pair adapter but an arraylist<pair>
    // adapter, I assumed that the container of arraylist, which is supported would be allowed and only
    // the pair would need an explicit adapter, todo test using the arraylist<pair> adapter

    // adapter is not reading the methods, trying to make them public
    // error was in my moshi builder code, was refering to the PairAdapter.class instead of creating a new PairAdapter()
    @ToJson
    String toJson(Pair<Integer, Integer> pair) {
        return String.valueOf(pair.first) + String.valueOf(pair.second);
    }

    @FromJson
    Pair<Integer, Integer> fromJson(String pair) {
//            if (card.length() != 2) throw new JsonDataException("Unknown card: " + card);
        // works only for on digit values, use a delimiter if you need the values to be larger
        // than one digit
        return new Pair<>(Integer.valueOf(pair.charAt(0)), Integer.valueOf(pair.charAt(1)));
    }
}
