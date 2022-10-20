package icd0004.framework;

import icd0004.framework.request.Booking;
import icd0004.framework.response.BookingResponse;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CreateBookingTests {

    @Test
    public void postBookingResponseShouldContainBookingId() {
        Booking bookingPayload = Booking.getFullPayload();

        BookingResponse bookingResponse = BookingApi
                .postBooking(bookingPayload)
                .as(BookingResponse.class);

        assertThat(bookingResponse.getBookingid()).isNotNull();
    }
}
