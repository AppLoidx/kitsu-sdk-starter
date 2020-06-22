package com.apploidx.kitsusdkstarter.http.error;

import lombok.Getter;

/**
 * @author Arthur Kupriyanov on 22.06.2020
 */
@Getter
public class KitsuClientException extends RuntimeException {
    public KitsuClientException(KitsuClientError error) {
        super("Kitsu client error", new RuntimeException(), false, false);
        this.body = error;
    }

    private final KitsuClientError body;
}
