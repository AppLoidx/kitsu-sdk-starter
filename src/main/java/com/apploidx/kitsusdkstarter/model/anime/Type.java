package com.apploidx.kitsusdkstarter.model.anime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Arthur Kupriyanov on 21.06.2020
 */
public enum Type {
    ONA, OVA, TV,
    MOVIE,
    MUSIC("music"),
    SPECIAL("special");

    Type() {
        this.key = this.name();
    }

    Type(String jsonKey) {
        this.key = jsonKey;
    }

    private final String key;

    @JsonCreator
    public static Type fromString(String key) {
        if (key == null) return null;
        return Type.valueOf(key.toUpperCase());
    }

    @JsonValue
    public String getKey() {
        return this.key;
    }
}
