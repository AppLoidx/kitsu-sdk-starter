package com.apploidx.kitsusdkstarter.http.error;

import lombok.Data;

/**
 * @author Arthur Kupriyanov on 22.06.2020
 */
@Data
public class Error {
    private String title;
    private String detail;
    private String status;
    private int code;
}
