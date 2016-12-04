package se.lendo.test.search.backend.component.clinet;

import se.lendo.test.common.googlePlaceApi.domain.Place;
import se.lendo.test.common.googlePlaceApi.param.Param;

import java.util.List;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public interface SearchPlaceClient {

    List<Place> getPlacesByQuery(String query, int limit, Param... extraParams);
    List<Place> getPlacesByQueryBasedOnRadar(String query, int limit, int radius, Param... extraParams);

}
