package com.evapps.lightsout.model;

import android.util.Pair;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import java.util.ArrayList;

public final class ArrayListPairAdapter {

    @ToJson
    String toJson(ArrayList<Pair<Integer, Integer>> alp) {
        int size = alp.size();
        String jsonOut = "";
        for (int i = 0; i < size; i++) {
            Pair<Integer, Integer> pair = alp.get(i);
            jsonOut += pair.first.toString() + pair.second.toString();
            // 1331 is the format
        }
        jsonOut += ';'; // ; indicates the end
        return jsonOut;
    }

    /*
    this method does not account for data that is two digits ex. 13 thus all of the input from Levels.java
    is single digit
     */
    @FromJson
    ArrayList<Pair<Integer, Integer>> fromJson(String jsonIn) {
//        for loop extrating the values from the string into the arraylist
        char[] chars = jsonIn.toCharArray();
        ArrayList<Pair<Integer, Integer>> alp = new ArrayList<>();
        for (int i = 0; chars[i] != ';'; i += 2) {
            alp.add(new Pair<Integer, Integer>(Character.getNumericValue(chars[i]), Character.getNumericValue(chars[i + 1])));
        }
        return alp;
    }
}
