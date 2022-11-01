package icd0004.selenide_only;

import com.codeborne.selenide.SelenideElement;
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

    @Test
    public void canSelectOptionOne() {
        $("#dropdown").click();
        $("#dropdown").selectOptionByValue("1");
        SelenideElement selectedOption = $("#dropdown").getSelectedOption();
        selectedOption.shouldHave(text("Option 1"));
    }

    @Test
    public void canSelectionOptionTwo() {
        $("#dropdown").click();
        $("#dropdown").selectOptionByValue("2");
        SelenideElement selectedOption = $("#dropdown").getSelectedOption();
        selectedOption.shouldHave(text("Option 2"));
    }
}
