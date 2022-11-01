package icd0004.selenide_only;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DynamicLoadingPageTests extends BaseTest {

    @BeforeEach
    public void navigateToPage() {
        open("/");
        $(By.linkText("Dynamic Loading")).click();
    }

}
