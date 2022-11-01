package icd0004.selenide_with_pom;

import icd0004.DropdownPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DropdownPageTests extends BaseTest {

    private static DropdownPage dropdownPage;

    @BeforeEach
    public void goToDropDownPage() {
        dropdownPage = new DropdownPage();
        dropdownPage.goTo();
    }

    @Test
    public void canOpenDropdownPage() {
        assertThat(dropdownPage.getPageTitleText()).isEqualTo("Dropdown List");
    }
}