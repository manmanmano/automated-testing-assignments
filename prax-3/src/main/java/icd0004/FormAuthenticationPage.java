package icd0004;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormAuthenticationPage {

    private final By dropdownPageLink = By.linkText("Form Authentication");

    public void goTo() {
        open("/");
        $(dropdownPageLink).click();
    }
}
