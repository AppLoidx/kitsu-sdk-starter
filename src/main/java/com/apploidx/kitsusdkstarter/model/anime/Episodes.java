package com.apploidx.kitsusdkstarter.model.anime;

import lombok.Data;

import java.util.Date;

/**
 * @author Arthur Kupriyanov on 21.06.2020
 */
@Data
public class Episodes {
    private Date createdAt;
    private Date updatedAt;
    private Titles titles;
    private String canonicalTitle;
    private int seasonNumber;
    private int number;
    private int relativeNumber;
    private String synopsis;
    private String airdate;
    private String length;
    private Thumbnail thumbnail;
}
