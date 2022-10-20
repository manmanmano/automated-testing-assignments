package icd0004.framework;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class BookingApi {
    private static final String BASE_URL = "https://restful-booker.herokuapp.com";
    private static final String BOOKING_API = BASE_URL + "/booking/";

    public static Response getBookings() {
        return given().get(BOOKING_API);
    }

    public static Response getBookingById(int bookingId) {
        return getBookingById(bookingId, JSON);
    }

    public static Response getBookingById(int bookingId, ContentType contentType) {
        return given()
                .accept(contentType.toString())
                .when()
                .get(BOOKING_API + bookingId);
    }
}
