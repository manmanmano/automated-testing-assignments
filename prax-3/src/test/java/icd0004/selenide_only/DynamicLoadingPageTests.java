package icd0004.selenide_only;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DynamicLoadingPageTests extends BaseTest {

    @BeforeEach
    public void navigateToPage() {
        open("/");
        $(By.linkText("Dynamic Loading")).click();
    }

    @Test
    public void canOpenDynamicLoadingPage() {
        $("h3").shouldHave(text("Dynamically Loaded Page Elements"));
    }

}
