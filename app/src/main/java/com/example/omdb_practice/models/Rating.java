package com.example.omdb_practice.models;

import com.google.gson.annotations.SerializedName;

public class Rating {

    @SerializedName("Source")
    private String source;
    @SerializedName("Value")
    private String value;

    public String getSource() {
        return source;
    }

    public String getValue() {
        return value;
    }
}
