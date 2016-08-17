package com.creatubbles.api.model.gallery.response;

import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("id")
    private String id;

    @SerializedName("type")
    private String type;

    @SerializedName("attributes")
    private Attributes attributes;

    @SerializedName("relationships")
    private Relationships relationships;

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public Relationships getRelationships() {
        return relationships;
    }
}
