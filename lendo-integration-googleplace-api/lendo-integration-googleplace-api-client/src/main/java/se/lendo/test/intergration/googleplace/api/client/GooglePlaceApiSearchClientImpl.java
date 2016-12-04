package se.lendo.test.intergration.googleplace.api.client;

import se.lendo.test.common.googlePlaceApi.exception.GooglePlacesException;
import se.lendo.test.common.googlePlaceApi.param.Param;
import se.lendo.test.common.googlePlaceApi.domain.Place;
import se.lendo.test.integration.googlePlaceApi.mapper.PlaceMapper;
import se.lendo.test.integration.googlePlaceApi.service.GoogleIntegrationService;
import se.lendo.test.integration.googlePlaceApi.service.GoogleIntegrationServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha.hasan@gmail.com>}
 */
public class GooglePlaceApiSearchClientImpl implements GooglePlaceApiSearchClient {

    /**
     * Argument #1: API Base URL
     * Argument #2: API Method
     * Argument #3: API Method arguments
     */

    public static String API_URL_FORMAT_STRING = "%s%s/json?%s";

    static String GOOGLE_API_URL = "https://maps.googleapis.com/maps/api/place/";


    private GoogleIntegrationService googleIntegrationService;
    private String googleApiKey;
    private boolean debugModeEnabled;
    private LinkedBlockingQueue<String> responseAvailable = new LinkedBlockingQueue<>();

    public GooglePlaceApiSearchClientImpl(String googleApiKey) {

        // create a bean av impl and injected to service
        this(new GoogleIntegrationServiceImpl(), googleApiKey);

    }

    public GooglePlaceApiSearchClientImpl(GoogleIntegrationService googleIntegrationService, String googleApiKey) {
        this.googleIntegrationService = googleIntegrationService;
        this.googleApiKey = googleApiKey;
    }

    public GooglePlaceApiSearchClientImpl() {
    }

    @Override
    public boolean isDebugModeEnabled() {
        return debugModeEnabled;
    }

    @Override
    public void setDebugModeEnabled(boolean debugModeEnabled) {
        this.debugModeEnabled = debugModeEnabled;
    }

    @Override
    public String getApiKey() {

        return googleApiKey;
    }

    @Override
    public void setApiKey(String googleApiKey) {
        this.googleApiKey = googleApiKey;
    }

    @Override
    public GoogleIntegrationService getRequestHandler() {
        return null;
    }

    @Override
    public void setRequestHandler(GoogleIntegrationService requestHandler) {

    }

    @Override
    public List<Place> getNearbyPlaces(double lat, double lng, double radius, int limit, Param... extraParams) {
        try {
            String uri = buildUrl(METHOD_NEARBY_SEARCH, String.format(Locale.ENGLISH, "key=%s&location=%s,%s&radius=%s",
                    googleApiKey, String.valueOf(lat), String.valueOf(lng), String.valueOf(radius)), extraParams);
            return getPlaces(uri, METHOD_NEARBY_SEARCH, limit);
        } catch (Exception e) {
            throw new GooglePlacesException(e);
        }
    }

    @Override
    public List<Place> getPlacesByQuery(String query, int limit, Param... extraParams) {
        try {
            String uri = buildUrl(METHOD_TEXT_SEARCH, String.format("query=%s&key=%s", query, googleApiKey), extraParams);
            return getPlaces(uri, METHOD_TEXT_SEARCH, limit);
        } catch (Exception e) {
            throw new GooglePlacesException(e);
        }
    }


    @Override
    public List<Place> getPlacesByQueryBasedOnRadar(String query, int limit, int radius, Param... extraParams) {

        try {
            String uri = buildUrl(METHOD_TEXT_SEARCH, String.format("query=%s&key=%s&radius=%s", query, googleApiKey, String.valueOf(radius)), extraParams);
            return getPlaces(uri, METHOD_TEXT_SEARCH, limit);
        } catch (Exception e) {
            throw new GooglePlacesException(e);
        }
    }

    @Override
    public List<Place> getNearbyPlaces(double lat, double lng, double radius, Param... extraParams) {
        return getNearbyPlaces(lat, lng, radius, DEFAULT_RESULTS, extraParams);
    }

    @Override
    public List<Place> getNearbyPlacesRankedByDistance(double lat, double lng, int limit, Param... params) throws GooglePlacesException {
        try {
            String uri = buildUrl(METHOD_NEARBY_SEARCH, String.format(Locale.ENGLISH, "key=%s&location=%s,%s&rankby=distance",
                    googleApiKey, String.valueOf(lat), String.valueOf(lng)), params);
            return getPlaces(uri, METHOD_NEARBY_SEARCH, limit);
        } catch (Exception e) {
            throw new GooglePlacesException(e);
        }
    }

    private static String addExtraParams(String base, Param... extraParams) {
        for (Param param : extraParams)
            base += "&" + param.name + (param.value != null ? "=" + param.value : "");
        return base;
    }

    /**
     * REMOVE all methods below to other class !!!
     */

    private static String buildUrl(String method, String params, Param... extraParams) {
        String url = String.format(Locale.ENGLISH, API_URL_FORMAT_STRING, GOOGLE_API_URL, method, params);
        url = addExtraParams(url, extraParams);
        url = url.replace(' ', '+');

        System.out.println(url);

        return url;

    }


    private List<Place> getPlaces(String uri, String method, int limit) throws IOException {
        limit = Math.min(limit, MAXIMUM_PAGE_RESULTS); // max of 60 results possible
        int pages = (int) Math.ceil(limit / (double) SINGLE_PAGE_MAXIMUM_RESULTS);


        // remove it and get this as retur
        List<Place> places = new ArrayList<>();

        // new request for each page
        for (int i = 0; i < pages; i++) {
            debug("Page: " + (i + 1));


            /**
             * the result from google which is repesented as json
             */

            String raw=googleIntegrationService.getUriData(uri);
            debug(raw);

            /**
             * the result from google which is repesented as json
             */

            //   String nextPage = parse(this, places, raw, limit);
            RequestParser.JsonDataResult jsonDataResult = RequestParser.parse(raw, limit);


            /**
             create a place object, we have maximum 60 result we will  return back
             every 20 object we returned on single page t
             !!! this method should running on other thread without blocking the main thread
             */

            for (int returnedPlace = 0; returnedPlace < jsonDataResult.getReturnedJsonDataFromGoogleUri().length(); returnedPlace++) {
                places.add(PlaceMapper.map(jsonDataResult.getReturnedJsonDataFromGoogleUri().getJSONObject(returnedPlace)));
            }

            // reduce the limit, update the uri and wait for token, but only if there are more pages to read

            if (jsonDataResult.getNextPageTokenData() != null && i < pages - 1) {
                limit -= MAXIMUM_PAGE_RESULTS;
                uri = String.format("%s%s/json?pagetoken=%s&key=%s", GOOGLE_API_URL, method, jsonDataResult.getNextPageTokenData(), googleApiKey);

                // remove this and use linkedBlockedQueue
                sleep(3000); // Page tokens have a delay before they are available
            } else {
                break;
            }


        }
        return places;
    }


    protected static void checkStatus(String statusCode, String errorMessage) {
        GooglePlacesException e = GooglePlacesException.parse(statusCode, errorMessage);
        if (e != null)
            throw e;
    }

    // use linkedBlockedQueue instead try to sleep the thread there where this method calls
    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void debug(String msg) {
        if (debugModeEnabled)
            System.out.println(msg);
    }

}