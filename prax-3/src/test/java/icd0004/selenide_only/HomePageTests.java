package icd0004.selenide_only;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePageTests extends BaseTest {

    @Test
    public void canOpenHomePage() {
        open("/");
        $("h1").shouldHave(text("Welcome to the-internet"));
    }

}
