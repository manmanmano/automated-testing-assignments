package icd0004.selenide_only;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DropdownPageTests extends BaseTest {

    @BeforeEach
    public void navigateToPage() {
        open("/");
        $(By.linkText("Dropdown")).click();
    }

    @Test
    public void canOpenDropdownPage() {
        $("h3").shouldHave(text("Dropdown List"));
    }
}
