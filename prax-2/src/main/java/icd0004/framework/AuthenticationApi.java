package icd0004.framework;

import icd0004.framework.request.Authentication;
import icd0004.framework.response.AuthenticationResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthenticationApi {
    private static final String BASE_URL = "https://restful-booker.herokuapp.com";
    private static final String AUTH_API = BASE_URL + "/auth";

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

    public static String retrieveToken() {
        Authentication credentials = Authentication.getCredentials();
        credentials.setUsername("admin");
        credentials.setPassword("password123");

        AuthenticationResponse authenticationResponse = AuthenticationApi
                .postCredentials(credentials)
                .as(AuthenticationResponse.class);

        return authenticationResponse.getToken();
    }
}
