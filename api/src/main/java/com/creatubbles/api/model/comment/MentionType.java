package com.creatubbles.api.model.comment;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.github.jasminb.jsonapi.annotations.Type;

/**
 * Created by Janek on 20.12.2017.
 */
public enum MentionType {

    USER("user"),
    GROUP("group"),
    CREATION("creation"),
    GALLERY("gallery"),
    PARTNER_APPLICATION("partner_application");

    private String typeName;

    MentionType(String typeName) {
        this.typeName = typeName;
    }

    @JsonValue
    @NonNull
    public String getTypeName() {
        return typeName;
    }

    @JsonCreator
    public static MentionType fromName(String typeName) {
        for (MentionType mentionType : values()) {
            if (mentionType.typeName.equals(typeName)) {
                return mentionType;
            }
        }
        return null;
    }
}
