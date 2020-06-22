package com.apploidx.kitsusdkstarter.http;

import com.apploidx.kitsusdkstarter.model.KitsuResponse;
import com.apploidx.kitsusdkstarter.model.anime.AnimeResponse;
import com.apploidx.kitsusdkstarter.model.anime.EpisodesResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * @author Arthur Kupriyanov on 21.06.2020
 */
@Service
public class KitsuHttpTransport {
    private static final String API_PATH = "https://kitsu.io/api/edge";
    private static final String ANIME_ENDPOINT = "anime";
    private static final String EPISODES_ENDPOINT = "episodes";

    private final RestTemplate restTemplate;

    public KitsuHttpTransport(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <T extends KitsuResponse<?>> T fetchResource(Class<T> clazz, int id) {
        final HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.set("Accept", "application/vnd.api+json");
        HttpEntity<String> req = new HttpEntity<>(headers);
        if (clazz == AnimeResponse.class) {
            return restTemplate.exchange(String.format("%s/%s/%d", API_PATH, ANIME_ENDPOINT, id), HttpMethod.GET, req, clazz).getBody();
        } else if (clazz == EpisodesResponse.class) {
            return restTemplate.getForEntity(String.format("%s/%s/%d", API_PATH, EPISODES_ENDPOINT, id), clazz).getBody();
        } else {
            throw new IllegalArgumentException("Can't handle passed class " + clazz.getCanonicalName());
        }
    }
}
