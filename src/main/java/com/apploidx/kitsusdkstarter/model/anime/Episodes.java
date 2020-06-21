package com.apploidx.kitsusdkstarter.model.anime;

import java.util.Date;

/**
 * @author Arthur Kupriyanov on 21.06.2020
 */
public record Episodes(
        Date createdAt,
        Date updatedAt,
        Titles titles,
        String canonicalTitle,
        int seasonNumber,
        int number,
        int relativeNumber,
        String synopsis,
        String airdate,
        String length,
        Thumbnail thumbnail
) {
}
