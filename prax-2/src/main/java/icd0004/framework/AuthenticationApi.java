package icd0004.framework;

import io.restassured.response.Response;

public class AuthenticationApi {
    private static final String BASE_URL = "https://restful-booker.herokuapp.com";
    private static final String AUTH_API = BASE_URL + "/auth";

    public static Response postCredentials(Authentication payload) {

    }
}
