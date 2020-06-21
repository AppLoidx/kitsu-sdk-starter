package com.apploidx.kitsusdkstarter.client;

import com.apploidx.kitsusdkstarter.model.anime.Anime;
import com.apploidx.kitsusdkstarter.model.anime.Episodes;

import java.util.List;

/**
 * @author Arthur Kupriyanov on 21.06.2020
 */
public interface KitsuClient {
    Anime fetchAnime(int id);
    Episodes fetchEpisodes(int id);
    List<Anime> fetchTrendingAnime();
}
