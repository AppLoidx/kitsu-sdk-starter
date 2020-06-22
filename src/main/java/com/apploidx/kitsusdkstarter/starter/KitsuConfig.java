package com.apploidx.kitsusdkstarter.starter;

import com.apploidx.kitsusdkstarter.client.KitsuClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Arthur Kupriyanov on 22.06.2020
 */
@Configuration
@ConditionalOnClass({KitsuClient.class})
@ComponentScan(basePackages = "com.apploidx.kitsusdkstarter")
public class KitsuConfig {

}
