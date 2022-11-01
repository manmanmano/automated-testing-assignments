package icd0004;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HoversPage {

   private final By hoversPageLink = By.linkText("Hovers");
   private final By hoversUsersList = By.cssSelector(".figure");
   private final By hoversSpecificUserName = By.cssSelector(".figcaption > h5");

    public void goTo() {
        open("/");
        $(hoversPageLink).click();
    }

    public String getPageTitleText() {
        return $("h3").getText();
    }

    public String getUserNameOnHover(int userIndex) {
        return $$(hoversUsersList).get(userIndex).hover()
                .$(hoversSpecificUserName).shouldBe(visible).getText();
    }
}
