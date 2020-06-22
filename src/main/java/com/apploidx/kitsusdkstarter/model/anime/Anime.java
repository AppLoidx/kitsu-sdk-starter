package com.apploidx.kitsusdkstarter.model.anime;

import lombok.Data;

import java.util.Date;
import java.util.Map;

/**
 * @author Arthur Kupriyanov on 21.06.2020
 */
@Data
public class Anime {
    private Date createdAt;
    private Date updatedAt;
    private String slug;
    private String synopsis;
    private Titles titles;
    private String canonicalTitle;
    private double averageRating;
    private Map<Integer, Integer> ratingFrequencies;
    private String startDate;
    private String endDate;
    private int popularityRank;
    private int ratingRank;
    private String ageRating;
    private String ageRatingGuide;
    private Type subtype;
    private Status status;
    private String tba;
    private Image posterImage;
    private Image coverImage;
    private int episodeCount;
    private int episodeLength;
    private String youtubeVideoId;
    private Type showType;
    private boolean nsfw;
}

