package com.apploidx.kitsusdkstarter.model;

import lombok.Getter;
import lombok.ToString;

/**
 * @author Arthur Kupriyanov on 21.06.2020
 */
@Getter
@ToString
public class KitsuResponse<T>{
    Data<T> data;

    @Getter
    private final static class Data<T> {
        T attributes;
    }

    public T getAttributes() {
        return data.getAttributes();
    }
}
