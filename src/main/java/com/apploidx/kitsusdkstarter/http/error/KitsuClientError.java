package com.apploidx.kitsusdkstarter.http.error;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author Arthur Kupriyanov on 22.06.2020
 */
@Data
@ToString
public class KitsuClientError {
    private List<Error> errors;
}
