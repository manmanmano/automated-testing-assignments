package icd0004.selenide_with_pom;

import icd0004.CheckboxesPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckboxesPageTests extends BaseTest {

    private static CheckboxesPage checkboxesPage;

    @BeforeEach
    public void goToCheckboxesPage() {
        checkboxesPage = new CheckboxesPage();
        checkboxesPage.goTo();
    }

    @Test
    public void canOpenCheckboxesPage() {
        assertThat(checkboxesPage.getPageTitleText()).isEqualTo("Checkboxes");
    }

    @Test
    public void shouldCheckAllCheckboxes() {
        checkboxesPage.checkAllCheckboxes();

        assertThat(checkboxesPage.countCheckedCheckboxes()).isEqualTo(2);
    }

    @Test
    public void shouldUnheckAllCheckboxes() {
        checkboxesPage.uncheckAllCheckboxes();

        assertThat(checkboxesPage.countCheckedCheckboxes()).isEqualTo(0);
    }
}
