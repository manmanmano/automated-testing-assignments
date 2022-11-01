package icd0004;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DynamicLoadingPage {

    private final By dynamicLoadingPageLink = By.linkText("Dynamic Loading");
    public void goTo() {
        open("/");
        $(dynamicLoadingPageLink).click();
    }

    public String getPageTitleText() {
        return $("h3").getText();
    }
}
