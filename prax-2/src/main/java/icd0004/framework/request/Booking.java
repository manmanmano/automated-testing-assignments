package icd0004.framework.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static java.util.concurrent.TimeUnit.DAYS;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect
@Builder
public class Booking {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private String additionalneeds;
    private BookingDates bookingdates;

    public static Booking getFullPayload() {
        Faker faker = new Faker();
        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin(faker.date().future(1, DAYS));
        bookingDates.setCheckout(faker.date().future(3, DAYS));

        return Booking.builder()
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .totalprice(faker.number().randomDigit())
                .depositpaid(true)
                .bookingdates(bookingDates)
                .additionalneeds(faker.howIMetYourMother().catchPhrase())
                .build();
    }
}
