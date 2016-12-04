package se.lendo.test.integration.googlePlaceApi.mapper;

import org.json.JSONArray;
import org.json.JSONObject;
import se.lendo.test.common.googlePlaceApi.domain.Place;

import java.util.ArrayList;
import java.util.List;

import static se.lendo.test.integration.googlePlaceApi.domain.GooglePlaceApiSearchFace.*;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha.hasan@gmail.com>}
 */
public class PlaceMapper {

    public static Place map(JSONObject jsonObject){

        return Place.builder()
                .withLat(jsonObject.getJSONObject(OBJECT_GEOMETRY).getJSONObject(OBJECT_LOCATION).getDouble(DOUBLE_LATITUDE))
                .withLng(jsonObject.getJSONObject(OBJECT_GEOMETRY).getJSONObject(OBJECT_LOCATION).getDouble(DOUBLE_LONGITUDE))
                .withPlaceId(jsonObject.getString(STRING_PLACE_ID))
                .withName(jsonObject.getString(STRING_NAME))
                .withAddr(jsonObject.optString(STRING_ADDRESS,null))
                .withVicinity(jsonObject.optString(STRING_VICINITY,null))
                .withTypes(typeParse(jsonObject))
                .build();

    }


    private static List<String> typeParse(JSONObject jsonObject){
        List<String> types= new ArrayList<>();

        JSONArray jsonArray = jsonObject.getJSONArray(ARRAY_TYPES);
        if (jsonArray!=null){
            for (int jsonTypeIndex= 0; jsonTypeIndex < jsonArray.length(); jsonTypeIndex ++){

                types.add(jsonArray.getString(jsonTypeIndex));
            }
        }
        return types;
    }

}
