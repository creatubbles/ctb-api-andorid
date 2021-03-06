package com.creatubbles.api.model.creation;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Janek on 14.03.2016.
 */
public enum ImageStatus {
    EMPTY(1),
    PROCESSING(2),
    READY(3);

    private final Integer status;

    ImageStatus(Integer status) {
        this.status = status;
    }

    @JsonValue
    @NonNull
    public Integer toInt() {
        return this.status;
    }

    @JsonCreator
    public static ImageStatus getStatus(Integer status) {
        switch (status) {
            case 1:
                return EMPTY;
            case 2:
                return PROCESSING;
            case 3:
                return READY;
            default:
                return null;
        }
    }

}

