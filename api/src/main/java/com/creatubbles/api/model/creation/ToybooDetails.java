package com.creatubbles.api.model.creation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;

/**
 * Created by Janek on 09.11.2016.
 */

@Type("creation_toyboo_details")
public class ToybooDetails {

    @Id
    private String id;

    @JsonProperty("uzpb_url")
    private String uzpbUrl;

    @JsonProperty("content_url")
    private String contentUrl;

    @JsonCreator
    public ToybooDetails() {
    }

    public String getId() {
        return id;
    }

    public String getUzpbUrl() {
        return uzpbUrl;
    }

    public String getContentUrl() {
        return contentUrl;
    }
}