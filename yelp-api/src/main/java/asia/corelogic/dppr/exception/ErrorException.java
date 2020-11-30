package asia.corelogic.dppr.exception;

public final class ErrorException extends RuntimeException {

    private ErrorException(String message) {
        super(message);
    }

    public static ErrorException noRestaurantFound() {
        return new ErrorException("asia.corelogic.dppr.annotations.validations.NoRestaurantFound.message");
    }

    public static ErrorException noReviewFound() {
        return new ErrorException("asia.corelogic.dppr.annotations.validations.NoReviewFound.message");
    }
}
