package se.lendo.test.intergration.googleplace.api.client;



import se.lendo.test.common.googlePlaceApi.domain.Place;
import se.lendo.test.common.googlePlaceApi.exception.GooglePlacesException;
import se.lendo.test.common.googlePlaceApi.param.Param;
import se.lendo.test.integration.googlePlaceApi.service.GoogleIntegrationService;

import java.util.List;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha.hasan@gmail.com>}
 */
public interface GooglePlaceApiSearchClient {

    int SINGLE_PAGE_MAXIMUM_RESULTS = 20;

    int DEFAULT_RESULTS = SINGLE_PAGE_MAXIMUM_RESULTS;

    int MAXIMUM_PAGE_RESULTS = 60;

    int MAXIMUM_RADAR_RESULTS = 200;


    double MAXIMUM_RADIUS_SEARCH = 50000;


    // METHODS
    String METHOD_NEARBY_SEARCH = "nearbysearch";
    String METHOD_TEXT_SEARCH = "textsearch";
    String METHOD_RADAR_SEARCH = "radarsearch";
    String METHOD_DETAILS = "details";
    String METHOD_ADD = "add";
    String METHOD_DELETE = "delete";
    String METHOD_AUTOCOMPLETE = "autocomplete";
    String METHOD_QUERY_AUTOCOMPLETE = "queryautocomplete";


    int MAX_PHOTO_SIZE = 1600;

    /**
     * Types of place
     */
    String ARRAY_TYPES = "types";

    /**
     * Array for results
     */
    String ARRAY_RESULTS = "results";

    /**
     * Signifies the hours of operation of a place
     */
    String ARRAY_PERIODS = "periods";

    /**
     * Array containing photo information
     */
    String ARRAY_PHOTOS = "photos";

    /**
     * An array containing each element in a places full address
     */
    String ARRAY_ADDRESS_COMPONENTS = "address_components";

    /**
     * Array of reviews of a Place
     */
    String ARRAY_REVIEWS = "reviews";

    /**
     * Array of aspects of a review
     */
    String ARRAY_ASPECTS = "aspects";

    /**
     * Array of autocomplete predictions
     */
    String ARRAY_PREDICTIONS = "predictions";

    /**
     * Array of terms describing a autocomplete prediction description
     */
    String ARRAY_TERMS = "terms";

    /**
     * Used for matching matched substrings for autocompletion
     */
    String ARRAY_MATCHED_SUBSTRINGS = "matched_substrings";

    /**
     * Defines alternate entries for a specified place.
     */
    String ARRAY_ALT_IDS = "alt_ids";

    /**
     * If the place is opened now
     */
    String BOOLEAN_OPENED = "open_now";

    /**
     * Latitude of place
     */
    String DOUBLE_LATITUDE = "lat";

    /**
     * Longitude of place
     */
    String DOUBLE_LONGITUDE = "lng";

    /**
     * The "rating" of the place
     */
    String DOUBLE_RATING = "rating";

    /**
     * How expensive the place is
     */
    String INTEGER_PRICE_LEVEL = "price_level";

    /**
     * Day represented by an int 0-6, starting with Sunday
     */
    String INTEGER_DAY = "day";

    /**
     * Used for describing a photo's width
     */
    String INTEGER_WIDTH = "width";

    /**
     * Used for describing a photo's height
     */
    String INTEGER_HEIGHT = "height";

    /**
     * Reviews use integer ratings
     */
    String INTEGER_RATING = "rating";

    /**
     * Minutes that a location is of from UTC
     */
    String INTEGER_UTC_OFFSET = "utc_offset";

    /**
     * Accuracy of location, in meters
     */
    String INTEGER_ACCURACY = "accuracy";

    /**
     * Used for autocomplete predictions
     */
    String INTEGER_OFFSET = "offset";

    /**
     * Used for autocomplete substring length
     */
    String INTEGER_LENGTH = "length";

    /**
     * Used for the date of a review
     */
    String LONG_TIME = "time";

    /**
     * Used for responses with single results
     */
    String OBJECT_RESULT = "result";

    /**
     * Geographic information
     */
    String OBJECT_GEOMETRY = "geometry";

    /**
     * Contains latitude and longitude coordinates
     */
    String OBJECT_LOCATION = "location";

    /**
     * Contains open_now
     */
    String OBJECT_HOURS = "opening_hours";

    /**
     * The beginning of a period
     */
    String OBJECT_OPEN = "open";

    /**
     * The end of a period
     */
    String OBJECT_CLOSE = "close";

    /**
     * The unique, stable, identifier for this place
     */
    String STRING_PLACE_ID = "place_id";

    /**
     * Url to the icon to represent this place
     */
    String STRING_ICON = "icon";

    /**
     * The valueOf of the place
     */
    String STRING_NAME = "valueOf";

    /**
     * The address of the place
     */
    String STRING_ADDRESS = "formatted_address";

    /**
     * The vicinity of which the place can be found (sometimes replaces formatted_address)
     */
    String STRING_VICINITY = "vicinity";

    /**
     * The url for an event at a place
     */
    String STRING_URL = "url";

    /**
     * A root element to indicate the status of the query.
     */
    String STRING_STATUS = "status";

    /**
     * A message that may or may not be present when an error occurs.
     */
    String STRING_ERROR_MESSAGE = "error_message";

    /**
     * A token used for getting the next page of results
     */
    String STRING_NEXT_PAGE_TOKEN = "next_page_token";

    /**
     * The phone number of the place
     */
    String STRING_PHONE_NUMBER = "formatted_phone_number";

    /**
     * The phone number of the place with an international country code
     */
    String STRING_INTERNATIONAL_PHONE_NUMBER = "international_phone_number";

    /**
     * The website associated with a place
     */
    String STRING_WEBSITE = "website";

    /**
     * A time represented by an hhmm format
     */
    String STRING_TIME = "time";

    /**
     * A reference to an actual photo
     */
    String STRING_PHOTO_REFERENCE = "photo_reference";

    /**
     * Represents an address component's long valueOf
     */
    String STRING_LONG_NAME = "long_name";

    /**
     * Represents an address component's short valueOf
     */
    String STRING_SHORT_NAME = "short_name";

    /**
     * Name of a review author
     */
    String STRING_AUTHOR_NAME = "author_name";

    /**
     * Url of author
     */
    String STRING_AUTHOR_URL = "author_url";

    /**
     * Language for review localization
     */
    String STRING_LANGUAGE = "language";

    /**
     * Review content
     */
    String STRING_TEXT = "text";

    /**
     * Description of autocomplete prediction
     */
    String STRING_DESCRIPTION = "description";

    /**
     * Used for autocomplete terms
     */
    String STRING_VALUE = "searchTypeValue";

    /**
     * Used for singular types in review aspects
     */
    String STRING_TYPE = "type";

    /**
     * Restricts the results to places matching at least one of the specified types.
     */
    String STRING_TYPES = "types";


    String STRING_SCOPE = "scope";

    /**
     * Returns true if the client is running in debug mode.
     *
     * @return true if debug mode
     */
    boolean isDebugModeEnabled();

    /**
     * Sets if the client should run in debug mode.
     *
     * @param debugModeEnabled true if in debug mode
     */
    void setDebugModeEnabled(boolean debugModeEnabled);


    /**
     * Returns the API key associated with this GooglePlaces object.
     *
     * @return clinet key
     */
    String getApiKey();

    /**
     * Sets the API key associated with this GooglePlaces object.
     *
     * @param googleApiKey to set
     */
    void setApiKey(String googleApiKey);

    /**
     * Returns the interface that handles HTTP requests to Google's server.
     *
     * @return request handler for HTTP traffic
     **/



    GoogleIntegrationService getRequestHandler();

    /**
     * Sets the request handler to delegate HTTP traffic.
     *
     * @param requestHandler to handle HTTP traffic
     */
    void setRequestHandler(GoogleIntegrationService requestHandler);

    List<Place> getPlacesByQuery(String query, int limit, Param... extraParams);

    List<Place> getPlacesByQueryBasedOnRadar(String query, int limit, int radius,Param... extraParams);

    // create a class with builder class that have lat and all other
    List<Place> getNearbyPlaces(double lat, double lng, double radius, int limit, Param... extraParams);


    List<Place> getNearbyPlaces(double lat, double lng, double radius, Param... extraParams);


    List<Place> getNearbyPlacesRankedByDistance(double lat, double lng, int limit, Param... params)
            throws GooglePlacesException;



}