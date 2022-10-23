package icd0004.framework;

import icd0004.framework.request.Authentication;
import icd0004.framework.request.Booking;
import icd0004.framework.response.BookingResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.http.ContentType.TEXT;

public class SmokeTests {

    @Test
    public void getAllBookingsShouldReturnHttp200() {
        BookingApi.getBookings().then().statusCode(200);
    }

    @Test
    public void getBookingIdShouldReturnHttp200() {
        BookingApi.getBookingById(1211).then().statusCode(200);
    }

    @Test
    public void postBookingShouldReturnHttp200() {
        Booking bookingPayload = Booking.getFullPayload();

        BookingApi.postBooking(bookingPayload).then().statusCode(200);
    }

    @Test
    public void postAuthenticationWithCorrectCredentialsReturnHttp200() {
        Authentication credentials = Authentication.getCredentials();
        credentials.setUsername("admin");
        credentials.setUsername("password");

        AuthenticationApi
                .postCredentials(credentials)
                .then()
                .statusCode(200);
    }

    @Test
    public void postBookingWithWrongAcceptHeaderReturnHttp418() {
        Booking bookingPayload = Booking.getFullPayload();

        BookingApi
                .postBooking(bookingPayload, TEXT)
                .then()
                .statusCode(418);
    }
}
