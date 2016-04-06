package com.evapps.lightsout.model;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Level implements LevelModel {

    public static final Mapper<Level> MAPPER = new Mapper<>(new Mapper.Creator<Level>() {
        @Override
        public Level create(long Id, String name, int numRows, int numCols, boolean isLocked) {
            return new AutoValue_Level(Id, name, numRows, numCols, isLocked);
        }
    });

    public static final class Marshal extends LevelMarshal<Marshal> {
    }
}

