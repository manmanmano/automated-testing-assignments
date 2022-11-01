package icd0004;

import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePageTests {

    @BeforeClass
    public void setUp()  {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.browser = "chrome";
    }

    @Test
    public static void canOpenHomePage() {
        open("/");
        $("h1").shouldHave(text("Welcome to the internet"));
    }
}