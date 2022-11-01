package icd0004;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DynamicLoadingPage {

    private final By dynamicLoadingPageLink = By.linkText("Dynamic Loading");
    private final By exampleOneLink = By.linkText("Example 1: Element on page that is hidden");
    private final By exampleTwoLink = By.linkText("Example 2: Element rendered after the fact");
    private final By startButton = By.xpath("//button[@type='submit']");
    private final By greetingField = By.tagName("h4");

    public void goTo() {
        open("/");
        $(dynamicLoadingPageLink).click();
    }

    public String getPageTitleText() {
        return $("h3").getText();
    }
}
