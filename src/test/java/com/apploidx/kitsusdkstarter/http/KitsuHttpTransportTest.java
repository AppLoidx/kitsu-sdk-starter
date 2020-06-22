package com.apploidx.kitsusdkstarter.http;

import com.apploidx.kitsusdkstarter.model.anime.AnimeResponse;
import com.apploidx.kitsusdkstarter.model.anime.AnimeTrendingResponse;
import com.apploidx.kitsusdkstarter.model.anime.EpisodesResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author Arthur Kupriyanov on 21.06.2020
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = com.apploidx.kitsusdkstarter.starter.KitsuConfig.class)
@AutoConfigureWebClient
@Slf4j
class KitsuHttpTransportTest {
    @Autowired
    private KitsuHttpTransport kitsuHttpTransport;

    @Test
    public void test() {
        AnimeTrendingResponse resp = kitsuHttpTransport.fetchTrendingAnime();
        resp.getData().stream().map(Object::toString).forEach(log::info);
    }

}