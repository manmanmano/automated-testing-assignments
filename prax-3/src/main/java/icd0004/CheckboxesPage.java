package icd0004;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class CheckboxesPage {

   private final By checkboxesPageLink = By.linkText("Checkboxes");
   private final By checkboxesCollection = By.xpath("//input");

    public void goTo() {
        open("/");
        $(checkboxesPageLink).click();
    }

    public String getPageTitleText() {
        return $("h3").getText();
    }

    public Integer countCheckboxes() {
        return $$(checkboxesCollection).size();
    }
}
