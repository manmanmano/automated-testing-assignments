package icd0004.framework;

import icd0004.framework.request.Authentication;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthenticationApi {
    private static final String BASE_URL = "https://restful-booker.herokuapp.com";
    private static final String AUTH_API = BASE_URL + "/auth";

    public static Response postCredentials(Authentication payload, String username, String password) {
        return given()
                .auth()
                .preemptive()
                .basic(username, password)
                .body(payload)
                .contentType(ContentType.JSON)
                .when()
                .post(AUTH_API);
    }

    public static Response postCredentials(Authentication payload) {
        return given()
                .auth()
                .preemptive()
                .basic(payload.getUsername(), payload.getPassword())
                .body(payload)
                .contentType(ContentType.JSON)
                .when()
                .post(AUTH_API);
    }
}
