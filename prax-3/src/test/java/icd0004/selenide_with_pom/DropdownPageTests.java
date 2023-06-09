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

    @Test
    public void canSelectOptionOne() {
        dropdownPage.selectOptionWithValue(1);

        assertThat(dropdownPage.getSelectedDropdownItem()).isEqualTo("Option 1");
    }

    @Test
    public void canSelectOptionTwo() {
        dropdownPage.selectOptionWithValue(2);

        assertThat(dropdownPage.getSelectedDropdownItem()).isEqualTo("Option 2");
    }
}