package se.lendo.test.backend.googlePlaceApi.component.service;

import org.json.JSONObject;
import se.lendo.test.common.googlePlaceApi.domain.Place;
import se.lendo.test.common.googlePlaceApi.param.Param;
import se.lendo.test.intergration.googleplace.api.client.GooglePlaceApiSearchClient;
import se.lendo.test.intergration.googleplace.api.client.GooglePlaceApiSearchClientImpl;

import java.util.List;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha.hasan@gmail.com>}
 */
public class SearchPlaceServiceImpl implements SearchPlaceService {

    private GooglePlaceApiSearchClient placeApiSearchClient = new GooglePlaceApiSearchClientImpl("AIzaSyD4ztDjzUZ047Wpqvl36uPiiddocI8p-rY");


    @Override
    public List<Place> getPlacesByQuery(String query, int limit, Param... extraParams) {

        return placeApiSearchClient.getPlacesByQuery(query, limit, extraParams);

    }

    @Override
    public List<Place> getPlacesByQueryBasedOnRadar(String query, int limit, int radius, Param... extraParams) {

        return placeApiSearchClient.getPlacesByQueryBasedOnRadar(query, limit, radius, extraParams);

    }
}
