package se.lendo.test.intergration.googleplace.api.client;

import org.json.JSONArray;
import org.json.JSONObject;
import se.lendo.test.common.googlePlaceApi.exception.CheckException;

import static se.lendo.test.common.googlePlaceApi.request.RequestStatus.STATUS_ZERO_RESULTS;
import static se.lendo.test.intergration.googleplace.api.client.GooglePlaceApiSearchClient.*;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha.hasan@gmail.com>}
 */

public class RequestParser {

    public static JsonDataResult parse(String returnResultFromGoogleUri, int limit) {
        // parse json
        JSONObject createJsonFromReturnedDataFromGoogleUri = new JSONObject(returnResultFromGoogleUri);

        // check root elements
        String statusCode = createJsonFromReturnedDataFromGoogleUri.getString(STRING_STATUS);
        CheckException.checkIfAnyException(statusCode, createJsonFromReturnedDataFromGoogleUri.optString(STRING_ERROR_MESSAGE));
        if (statusCode.equals(STATUS_ZERO_RESULTS))
            return null;

        // the returned data as json string from google uri , of this data we will try to create a Place object
        JSONArray results = createJsonFromReturnedDataFromGoogleUri.getJSONArray(ARRAY_RESULTS);

        //  parseResults(results, Math.min(limit, MAXIMUM_PAGE_RESULTS));

        // the next_page_token key searchTypeValue will returned and next request by this meta data will be send
        // createJsonFromReturnedDataFromGoogleUri.optString(STRING_NEXT_PAGE_TOKEN, null)

        return new JsonDataResult(createJsonFromReturnedDataFromGoogleUri.optString(STRING_NEXT_PAGE_TOKEN, null), results);

    }


    public static class JsonDataResult {

        public JsonDataResult(String nextPageTokenData, JSONArray returnedJsonDataFromGoogleUri) {
            this.nextPageTokenData = nextPageTokenData;
            this.returnedJsonDataFromGoogleUri = returnedJsonDataFromGoogleUri;
        }

        String nextPageTokenData;
        JSONArray returnedJsonDataFromGoogleUri;

        public String getNextPageTokenData() {
            return nextPageTokenData;
        }

        public JSONArray getReturnedJsonDataFromGoogleUri() {
            return returnedJsonDataFromGoogleUri;
        }

        public void setNextPageTokenData(String nextPageTokenData) {
            this.nextPageTokenData = nextPageTokenData;
        }

        public void setReturnedJsonDataFromGoogleUri(JSONArray returnedJsonDataFromGoogleUri) {
            this.returnedJsonDataFromGoogleUri = returnedJsonDataFromGoogleUri;
        }
    }

}
