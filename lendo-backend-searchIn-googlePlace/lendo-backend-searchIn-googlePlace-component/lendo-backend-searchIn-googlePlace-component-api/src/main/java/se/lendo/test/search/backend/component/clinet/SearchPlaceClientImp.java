package se.lendo.test.search.backend.component.clinet;

import se.lendo.test.backend.googlePlaceApi.component.service.SearchPlaceService;
import se.lendo.test.backend.googlePlaceApi.component.service.SearchPlaceServiceImpl;
import se.lendo.test.common.googlePlaceApi.domain.Place;
import se.lendo.test.common.googlePlaceApi.param.Param;

import java.util.List;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class SearchPlaceClientImp implements SearchPlaceClient {

    private SearchPlaceService searchPlaceClient = new SearchPlaceServiceImpl();

    @Override
    public List<Place> getPlacesByQuery(String query, int limit, Param... extraParams) {

        return searchPlaceClient.getPlacesByQuery(query, limit, extraParams);

    }

    @Override
    public List<Place> getPlacesByQueryBasedOnRadar(String query, int limit, int radius, Param... extraParams) {
        return searchPlaceClient.getPlacesByQueryBasedOnRadar(query, limit, radius, extraParams);
    }
}
