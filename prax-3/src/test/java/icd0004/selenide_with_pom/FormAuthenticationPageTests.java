package icd0004.selenide_with_pom;

import icd0004.FormAuthenticationPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FormAuthenticationPageTests extends BaseTest {

    private static FormAuthenticationPage formAuthenticationPage;

    @BeforeEach
    public void goToFormAuthenticationPage() {
        formAuthenticationPage = new FormAuthenticationPage();
        formAuthenticationPage.goTo();
    }

    @Test
    public void canOpenFormAuthenticationPage() {
        assertThat(formAuthenticationPage.getPageTitleText()).isEqualTo("Login Page");
    }

    @Test
    public void shouldLoginToSecureAreaWithValidCredentials() {
        String validUsername = "tomsmith";
        String validPassword = "SuperSecretPassword!";

        formAuthenticationPage.loginWithCredentials(validUsername, validPassword);

        assertThat(formAuthenticationPage.getNotification().getText()).contains("You logged into a secure area!");
    }
}
