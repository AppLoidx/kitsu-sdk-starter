package com.apploidx.kitsusdkstarter.client.impl;

import com.apploidx.kitsusdkstarter.client.KitsuClient;
import com.apploidx.kitsusdkstarter.http.KitsuHttpTransport;
import com.apploidx.kitsusdkstarter.model.anime.Anime;
import com.apploidx.kitsusdkstarter.model.anime.AnimeResponse;
import com.apploidx.kitsusdkstarter.model.anime.Episodes;
import com.apploidx.kitsusdkstarter.model.anime.EpisodesResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Arthur Kupriyanov on 21.06.2020
 */
@Service
public class KitsuClientImpl implements KitsuClient {

    private final KitsuHttpTransport kitsuHttpTransport;

    public KitsuClientImpl(KitsuHttpTransport kitsuHttpTransport) {
        this.kitsuHttpTransport = kitsuHttpTransport;
    }

    @Override
    public Anime fetchAnime(int id) {
        return kitsuHttpTransport.fetchResource(AnimeResponse.class, id).getAttributes();
    }

    @Override
    public Episodes fetchEpisodes(int id) {
        return kitsuHttpTransport.fetchResource(EpisodesResponse.class, id).getAttributes();
    }

    @Override
    public List<Anime> fetchTrendingAnime() {
        return null;
    }
}
