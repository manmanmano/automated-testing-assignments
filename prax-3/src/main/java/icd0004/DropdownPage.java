package icd0004;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DropdownPage {

    private final By dropdownPageLink = By.linkText("Dropdown");

    public void goTo() {
        open("/");
        $(dropdownPageLink).click();
    }

    public String getPageTitleText() {
        return $("h3").getText();
    }
}
