package icd0004.framework;


public class BookingApi {
    private static final String BASE_URL = "https://restful-booker.herokuapp.com";
    private static final String BOOKING_API = BASE_URL + "/booking/";

    public static Response getBookings() {
        return given().get(BOOKING_API);
    }
}
