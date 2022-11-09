package icd0004.selenide_with_pom;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
    }
}
