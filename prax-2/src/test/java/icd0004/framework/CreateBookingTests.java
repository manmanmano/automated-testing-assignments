package icd0004.framework;

import icd0004.framework.request.Booking;
import icd0004.framework.response.BookingResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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

    @Test
    public void postBookingResponseShouldContainBooking() {
        Booking bookingPayload = Booking.getFullPayload();
        bookingPayload.setFirstname("Bill");
        bookingPayload.setLastname("Gates");

        BookingResponse bookingResponse = BookingApi
                .postBooking(bookingPayload)
                .as(BookingResponse.class);

        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Bill");
        assertThat(bookingResponse.getBooking().getLastname()).isEqualTo("Gates");
    }

    @Test
    public void createBookingFromFile() throws IOException {
        Booking bookingPayload = Booking.buildWithResource("test_data/jira_54.json");

        BookingResponse bookingResponse = BookingApi
                .postBooking(bookingPayload)
                .as(BookingResponse.class);

        assertThat(bookingResponse.getBooking())
                .extracting("firstname", "lastname")
                .contains("Donkey", "Kong");
    }
}
