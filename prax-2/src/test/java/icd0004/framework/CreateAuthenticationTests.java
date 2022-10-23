package icd0004.framework;

import icd0004.framework.request.Authentication;
import icd0004.framework.response.AuthenticationResponse;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CreateAuthenticationTests {

    @Test
    public void postAuthenticationWithIncorrectCredentialsShouldReturnBadCredentials() {
        Authentication credentials = Authentication.getCredentials();

        AuthenticationResponse authenticationResponse = AuthenticationApi
                .postCredentials(credentials)
                .as(AuthenticationResponse.class);

        assertThat(authenticationResponse.getReason()).isNotNull();
        assertThat(authenticationResponse.getReason()).isEqualTo("Bad credentials");
    }
}
