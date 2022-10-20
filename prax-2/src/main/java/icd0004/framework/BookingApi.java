package icd0004.framework;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookingApi {
    private static final String BASE_URL = "https://restful-booker.herokuapp.com";
    private static final String BOOKING_API = BASE_URL + "/booking/";

    public static Response getBookings() {
        return given().get(BOOKING_API);
    }
}
