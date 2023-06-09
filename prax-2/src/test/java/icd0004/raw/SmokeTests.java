package icd0004.raw;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class SmokeTests {

    public static final String API_URL = "https://restful-booker.herokuapp.com/booking";

    @Test
    public void getAllBookingsShouldReturnHttp200() {
        when()
                .get(API_URL)
                .then()
                .statusCode(200);
    }

    @Test
    public void getBookingIdShouldReturnHttp200() {
        given()
                .contentType(JSON.toString())
                .when()
                .get(API_URL + "/1221")
                .then()
                .statusCode(200);
    }

    @Test
    public void postBookingShouldReturnHttp200() {
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
                .accept(JSON.toString())
                .contentType(JSON.toString())
                .body(payload)
                .post(API_URL)
                .then()
                .statusCode(200);
    }
}