package icd0004.framework;

import org.junit.jupiter.api.Test;

public class SmokeTests {

    @Test
    public void getAllBookingsShouldReturnHttp200() {
        BookingApi.getBookings().then().statusCode(200);
    }

    @Test
    public void getBookingIdShouldReturnHttp200() {
        BookingApi.getBookingById(121).then().statusCode(200);
    }

//    @Test
//    public void postBookingShouldReturnHttp200() {
//        Booking bookingPayload = Booking.getFullPayload();
//        BookingResponse bookingResponse = BookingApi.postBooking(bookingPayload).then().statusCode(200);
//    }
}
