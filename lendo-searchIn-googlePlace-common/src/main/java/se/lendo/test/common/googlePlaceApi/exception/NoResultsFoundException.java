package se.lendo.test.common.googlePlaceApi.exception;


import se.lendo.test.common.googlePlaceApi.request.RequestStatus;

public class NoResultsFoundException extends GooglePlacesException {
    public NoResultsFoundException(String errorMessage) {
        super(RequestStatus.STATUS_ZERO_RESULTS, errorMessage);
    }

    public NoResultsFoundException() {
        this(null);
    }
}
