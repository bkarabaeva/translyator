package com.bkarabaeva.trnslayator.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Languages {

    @SerializedName("dirs")
    @Expose
    private List<String> dirs = null;
    @SerializedName("langs")
    @Expose
    private Map<String, String> langs;

    public List<Direction> getDirs() {
        List<Direction> directions = new ArrayList<>();
        for (String string : dirs) {
            Direction direction = new Direction();
            direction.parseString(string);
            directions.add(direction);
        }
        return directions;
    }

    public void setDirs(List<String> dirs) {
        this.dirs = dirs;
    }

    public Map<String, String> getLangs() {
        return langs;
    }

    public void setLangs(Map<String, String> langs) {
        this.langs = langs;
    }
}
