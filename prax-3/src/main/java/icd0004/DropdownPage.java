package icd0004;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DropdownPage {

    private final By dropdownPageLink = By.linkText("Dropdown");
    private final By dropdownField = By.id("dropdown");

    public void goTo() {
        open("/");
        $(dropdownPageLink).click();
    }

    public String getPageTitleText() {
        return $("h3").getText();
    }

    public void selectOptionWithValue(int optionValue) {
        $(dropdownField).click();
        $(dropdownField).selectOptionByValue(String.valueOf((optionValue)));
    }

    public String getSelectedDropdownItem() {
        return $(dropdownField).getSelectedOption().getText();
    }
}
