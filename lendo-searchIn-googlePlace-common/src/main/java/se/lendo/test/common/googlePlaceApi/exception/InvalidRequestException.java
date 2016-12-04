package se.lendo.test.common.googlePlaceApi.exception;

import se.lendo.test.common.googlePlaceApi.request.RequestStatus;

public class InvalidRequestException extends GooglePlacesException {
    public InvalidRequestException(String errorMessage) {
        super(RequestStatus.STATUS_INVALID_REQUEST, errorMessage);
    }

    public InvalidRequestException() {
        this(null);
    }
}
