package com.apploidx.kitsusdkstarter.model.anime;

import java.util.Date;
import java.util.Map;

/**
 * @author Arthur Kupriyanov on 21.06.2020
 */
public record Anime(
        Date createdAt,
        Date updatedAt,
        String slug,
        String synopsis,
        Titles titles,
        String canonicalTitle,
        double averageRating,
        Map<Integer, Integer> ratingFrequencies,
        String startDate,
        String endDate,
        int popularityRank,
        int ratingRank,
        String ageRating,
        String ageRatingGuide,
        Type subtype,
        Status status,
        String tba,
        Image posterImage,
        Image coverImage,
        int episodeCount,
        int episodeLength,
        String youtubeVideoId,
        Type showType,
        boolean nsfw
) {

}

