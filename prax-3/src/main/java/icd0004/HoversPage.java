package icd0004;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HoversPage {

   private final By hoversPageLink = By.linkText("Hovers");

    public void goTo() {
        open("/");
        $(hoversPageLink).click();
    }

    public String getPageTitleText() {
        return $("h3").getText();
    }
}
