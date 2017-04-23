package com.bkarabaeva.trnslayator.network;

public class Direction {
    private String fromLang;
    private String toLang;

    private static final String DELIM = "-";

    public void parseString(String dirs) {
        String[] tokens = dirs.split(DELIM);
        this.fromLang = tokens[0];
        this.toLang = tokens[1];
    }

    public String getFromLang() {
        return fromLang;
    }

    public void setFromLang(String fromLang) {
        this.fromLang = fromLang;
    }

    public String getToLang() {
        return toLang;
    }

    public void setToLang(String toLang) {
        this.toLang = toLang;
    }
}
