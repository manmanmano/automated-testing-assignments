package icd0004.selenide_only;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormAuthenticationPageTests extends BaseTest {
    @BeforeEach
    public void navigateToPage() {
        open("/");
        $(By.linkText("Form Authentication")).click();
    }

    @Test
    public void canOpenFormAuthenticationPage() {
        $("h2").shouldHave(text("Login Page"));
    }

    @Test
    public void shouldLoginToSecureAreaWithValidCredentials() {
        String validUsername = "tomsmith";
        String validPassword = "SuperSecretPassword!";

        $("#username").setValue(validUsername);
        $("#password").setValue(validPassword);
        $("button").click();
        $("h2").shouldHave(text("Secure Area"));
    }

    @Test
    public void shouldLoginToSecureAreaWithInvalidCredentials() {
        String invalidUsername = "johnsmith";
        String invalidPassword = "NotSecretPassword!";

        $("#username").setValue(invalidUsername);
        $("#password").setValue(invalidPassword);
        $("button").click();
        $("#flash").shouldHave(text("Your username is invalid!"));
    }
}
