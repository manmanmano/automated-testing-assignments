package icd0004.raw;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.http.ContentType.JSON;

public class SmokeTests {

    public static final String API_URL = "https://restful-booker.herokuapp.com/booking";

    @Test
    public void getAllBookingsShouldReturn200() {
        when()
                .get(API_URL)
                .then()
                .statusCode(200);
    }

    @Test
    public void getBookingIdShouldReturn200() {
        given()
                .contentType(JSON.toString())
                .when()
                .get(API_URL + "/121")
                .then()
                .statusCode(200);
    }
}
