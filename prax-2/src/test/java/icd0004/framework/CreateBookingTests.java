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

    @Test
    public void postBookingResponseShouldContainBooking() {
        Booking bookingPayload = Booking.getFullPayload();
        bookingPayload.setFirstname("Augustin");
        bookingPayload.setLastname("Rincon");
    }

    @Test
    public void createBookingFromFile() {
        Booking bookingPayload = Booking.buildWithResource("test_data/jira_54.json");

        BookingResponse bookingResponse = BookingApi
                .postBooking(bookingPayload)
                .as(BookingResponse.class);

        assertThat(bookingResponse.getBooking())
                .extracting("firstname", "lastname")
                .contains("Donkey", "Kong");
    }
}
