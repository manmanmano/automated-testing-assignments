package icd0004.framework;

import icd0004.framework.request.Booking;
import icd0004.framework.response.BookingResponse;
import org.junit.jupiter.api.Test;

public class EditBookingTests {
    @Test
    public void putBookingShouldReturnHttp200() {
        Booking bookingPayload = Booking.getFullPayload();
        String token = AuthenticationApi.retrieveToken();

        BookingResponse bookingResponse = BookingApi
                .postBooking(bookingPayload)
                .as(BookingResponse.class);

        BookingApi
                .putBooking(bookingPayload, token, bookingResponse.getBookingid())
                .then()
                .statusCode(200);
    }

    @Test
    public void deleteBookingShouldReturnHttp201() {
        Booking bookingPayload = Booking.getFullPayload();
        String token = AuthenticationApi.retrieveToken();

        BookingResponse bookingResponse = BookingApi
                .postBooking(bookingPayload)
                .as(BookingResponse.class);

        BookingApi
                .deleteBooking(token, bookingResponse.getBookingid())
                .then()
                .statusCode(201);
    }
}
