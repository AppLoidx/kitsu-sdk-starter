package com.apploidx.kitsusdkstarter.model.anime;

import com.apploidx.kitsusdkstarter.model.KitsuResponse;
import lombok.Data;

import java.util.List;

/**
 * @author Arthur Kupriyanov on 23.06.2020
 */
@Data
public class AnimeTrendingResponse {
    List<KitsuResponse.Data<Anime>> data;
}
