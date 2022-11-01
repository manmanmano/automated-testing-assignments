package icd0004.selenide_with_pom;

import icd0004.FormAuthenticationPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
