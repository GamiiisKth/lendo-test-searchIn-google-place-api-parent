package se.lendo.test.common.googlePlaceApi.exception;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha.hasan@gmail.com>}
 */
public class CheckException {

    public static void checkIfAnyException(String statusCode, String errorMessage) {
        GooglePlacesException e = GooglePlacesException.parse(statusCode, errorMessage);
        if (e != null)
            throw e;
    }
}
