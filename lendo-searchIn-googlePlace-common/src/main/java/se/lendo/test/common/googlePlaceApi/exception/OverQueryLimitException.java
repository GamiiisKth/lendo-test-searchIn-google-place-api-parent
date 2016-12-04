package se.lendo.test.common.googlePlaceApi.exception;


import se.lendo.test.common.googlePlaceApi.request.RequestStatus;

public class OverQueryLimitException extends GooglePlacesException {
    public OverQueryLimitException(String errorMessage) {
        super(RequestStatus.STATUS_OVER_QUERY_LIMIT, errorMessage);
    }

    public OverQueryLimitException() {
        this(null);
    }
}
