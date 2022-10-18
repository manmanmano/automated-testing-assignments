package icd0004.raw;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;

public class SmokeTests {

    public static final String API_URL = "https://restful-booker.herokuapp.com/booking";

    @Test
    public void getAllBookingsShouldReturn200() {
        when()
                .get(API_URL)
                .then()
                .statusCode(200);
    }
}
