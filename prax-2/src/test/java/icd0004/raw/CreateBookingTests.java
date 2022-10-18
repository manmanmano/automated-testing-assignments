package icd0004.raw;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class CreateBookingTests {
    public static final String API_URL = "https://restful-booker.herokuapp.com/booking/";

    @Test
    public void postBookingResponseShouldContainBookingId() {
        String payload = "{\n" +
                "    \"firstname\": \"Al Faysal Bin\",\n" +
                "    \"lastname\": \"Asad\",\n" +
                "    \"totalprice\": 111,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "    \"checkin\": \"2022-10-15\",\n" +
                "    \"checkout\": \"2022-10-18\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";

        given()
                .contentType(JSON.toString())
                .accept(JSON.toString())
                .body(payload)
                .when()
                .post(API_URL)
                .then()
                .statusCode(200)
                .body("bookingid", notNullValue());

    }
}
