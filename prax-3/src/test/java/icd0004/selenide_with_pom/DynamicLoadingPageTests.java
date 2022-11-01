package icd0004.selenide_with_pom;

import icd0004.DynamicLoadingPage;
import org.junit.jupiter.api.BeforeEach;

public class DynamicLoadingPageTests {

    private static DynamicLoadingPage dynamicLoadingPage;

    @BeforeEach
    public void goToDynamicLoadingPage() {
        dynamicLoadingPage = new DynamicLoadingPage();
        dynamicLoadingPage.goTo();
    }
}
