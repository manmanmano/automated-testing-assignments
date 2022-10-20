package icd0004.framework;

import icd0004.framework.request.Authentication;
import org.junit.jupiter.api.Test;

public class CreateAuthenticationTests {

    @Test
    public void postAuthenticationWithIncorrectCredentialsReturnBadCredentials() {
        Authentication credentials = Authentication.getCredentials();
    }
}
