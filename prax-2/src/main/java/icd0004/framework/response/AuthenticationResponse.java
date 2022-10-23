package icd0004.framework.response;

import icd0004.framework.request.Authentication;
import lombok.Data;

@Data
public class AuthenticationResponse {
    private String token;
    private String reason;
    private Authentication auth;
}
