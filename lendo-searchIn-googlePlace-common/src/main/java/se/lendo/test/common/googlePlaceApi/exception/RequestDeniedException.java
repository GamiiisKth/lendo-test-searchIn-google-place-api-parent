package se.lendo.test.common.googlePlaceApi.exception;


import se.lendo.test.common.googlePlaceApi.request.RequestStatus;

public class RequestDeniedException extends GooglePlacesException {
    public RequestDeniedException(String errorMessage) {
        super(RequestStatus.STATUS_REQUEST_DENIED, errorMessage);
    }

    public RequestDeniedException() {
        this(null);
    }
}