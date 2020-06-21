package com.apploidx.kitsusdkstarter.model.anime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Arthur Kupriyanov on 21.06.2020
 */
public enum Status {
    CURRENT("current"),
    FINISHED("finished"),
    TBA ("tba"),
    UNRELEASED ("unreleased"),
    UPCOMING ("upcoming");

    private final String key;

    Status(String key) {
        this.key = key;
    }

    @JsonCreator
    public static Status fromString(String key) {
        if (key == null) return null;
        return Status.valueOf(key.toUpperCase());
    }

    @JsonValue
    public String getKey() {
        return this.key;
    }
}
