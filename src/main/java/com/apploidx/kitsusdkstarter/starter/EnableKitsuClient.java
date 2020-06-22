package com.apploidx.kitsusdkstarter.starter;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Arthur Kupriyanov on 21.06.2020
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(KitsuConfig.class)
public @interface EnableKitsuClient {
}
