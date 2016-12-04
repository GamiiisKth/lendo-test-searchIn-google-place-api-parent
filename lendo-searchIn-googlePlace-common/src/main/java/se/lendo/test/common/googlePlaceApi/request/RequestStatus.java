package se.lendo.test.common.googlePlaceApi.request;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha.hasan@gmail.com>}
 */
public interface RequestStatus {


    String STATUS_OK = "OK";

    String STATUS_ZERO_RESULTS = "ZERO_RESULTS";

    String STATUS_OVER_QUERY_LIMIT = "OVER_QUERY_LIMIT";

    String STATUS_REQUEST_DENIED = "REQUEST_DENIED";

    String STATUS_INVALID_REQUEST = "INVALID_REQUEST";

    String STATUS_UNKNOWN_ERROR = "UNKNOWN_ERROR";

    String STATUS_NOT_FOUND = "NOT_FOUND";
}
