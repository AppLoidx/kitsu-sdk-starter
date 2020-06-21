package com.apploidx.kitsusdkstarter.http;

import com.apploidx.kitsusdkstarter.model.anime.AnimeResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author Arthur Kupriyanov on 21.06.2020
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class KitsuHttpTransportTest {
    @Autowired
    private KitsuHttpTransport kitsuHttpTransport;

    @Test
    public void test() {
        AnimeResponse response = kitsuHttpTransport.fetchResource(AnimeResponse.class, 2);
        log.info(response.toString());
        log.info(response.getAttributes().toString());
    }

}