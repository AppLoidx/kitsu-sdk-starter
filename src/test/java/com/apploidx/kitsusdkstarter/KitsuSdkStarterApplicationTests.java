package com.apploidx.kitsusdkstarter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = com.apploidx.kitsusdkstarter.starter.KitsuConfig.class)
@AutoConfigureWebClient
class KitsuSdkStarterApplicationTests {

    @Test
    void contextLoads() {
    }

}
