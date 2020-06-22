package com.apploidx.kitsusdkstarter.http;

import com.apploidx.kitsusdkstarter.http.error.KitsuClientError;
import com.apploidx.kitsusdkstarter.http.error.KitsuClientException;
import com.apploidx.kitsusdkstarter.model.KitsuResponse;
import com.apploidx.kitsusdkstarter.model.anime.AnimeResponse;
import com.apploidx.kitsusdkstarter.model.anime.AnimeTrendingResponse;
import com.apploidx.kitsusdkstarter.model.anime.EpisodesResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


/**
 * @author Arthur Kupriyanov on 21.06.2020
 */
@Service
@Slf4j
public class KitsuHttpTransport {
    private static final String API_PATH = "https://kitsu.io/api/edge";
    private static final String ANIME_ENDPOINT = "anime";
    private static final String EPISODES_ENDPOINT = "episodes";
    private static final ObjectReader KITSU_ERROR_READER = new ObjectMapper().reader().forType(KitsuClientError.class);
    private static final HttpEntity<String> HTTP_REQUEST_ENTITY;

    static {
        final HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.set("Accept", "application/vnd.api+json");
        HTTP_REQUEST_ENTITY = new HttpEntity<>(headers);
    }

    private final RestTemplate restTemplate;

    public KitsuHttpTransport(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <T extends KitsuResponse<?>> T fetchResource(Class<T> clazz, int id) {

        try {
            if (clazz == AnimeResponse.class) {
                return restExchange(endpointPathWithIdParam(ANIME_ENDPOINT, id), clazz);
            } else if (clazz == EpisodesResponse.class) {
                return restExchange(endpointPathWithIdParam(EPISODES_ENDPOINT, id), clazz);
            }

            throw new IllegalArgumentException("Can't handle passed class " + clazz.getCanonicalName());

        } catch (HttpClientErrorException httpClientErrorException) {
            throw handleError(httpClientErrorException);
        }
    }

    private String endpointPathWithIdParam(String endpointPath, int id) {
        return String.format("%s/%s/%d", API_PATH, endpointPath, id);
    }

    public AnimeTrendingResponse fetchTrendingAnime() {
        String path = API_PATH + "/trending/anime";
        return restExchange(path, AnimeTrendingResponse.class);
    }

    private RuntimeException handleError(HttpClientErrorException httpClientErrorException) {
        try {
            KitsuClientError clientError = KITSU_ERROR_READER.readValue(httpClientErrorException.getResponseBodyAsString());
            return new KitsuClientException(clientError);
        } catch (JsonProcessingException ignored) {
            return httpClientErrorException;
        }
    }

    private <T> T restExchange(String uri, Class<T> clazz) {
        return restTemplate.exchange(uri, HttpMethod.GET, HTTP_REQUEST_ENTITY, clazz).getBody();
    }
}
