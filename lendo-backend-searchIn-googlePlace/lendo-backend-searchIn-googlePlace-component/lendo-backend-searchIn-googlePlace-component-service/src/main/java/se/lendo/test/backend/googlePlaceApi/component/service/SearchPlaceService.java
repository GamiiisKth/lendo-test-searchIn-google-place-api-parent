package se.lendo.test.backend.googlePlaceApi.component.service;

import org.json.JSONObject;
import se.lendo.test.common.googlePlaceApi.domain.Place;
import se.lendo.test.common.googlePlaceApi.param.Param;

import java.io.InputStream;
import java.util.List;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha.hasan@gmail.com>}
 */
public interface SearchPlaceService {


    //    JsonObject getSearchDetailes( String type, String where, int radious )

   // this is what we will get from  backend client and we will return a json

   // we should get a PlaceModels from integration side instead
   // solution should be this json object should be mapped to a model in integration-mapper och modelMapper
   List<Place> getPlacesByQuery(String query, int limit, Param... extraParams);

   List<Place> getPlacesByQueryBasedOnRadar(String query, int limit, int radius, Param... extraParams);


}
