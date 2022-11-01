package icd0004.selenide_with_pom;

import icd0004.HoversPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HoversPageTests extends BaseTest {

    private static HoversPage hoversPage;

    @BeforeEach
    public void goToHoversPage() {
        hoversPage = new HoversPage();
        hoversPage.goTo();
    }

    @Test
    public void canOpenHoversPage() {
        assertThat(hoversPage.getPageTitleText()).isEqualTo("Hovers");
    }

    @Test
    public void shouldDisplayUserNameOneWhenHoveringOverProfilePicture() {
        hoversPage.getUsersHovers(0);

        assertThat(hoversPage.getUserHoverName()).contains("user1");
    }

    @Test
    public void shouldDisplayUserNameTwoWhenHoveringOverProfilePicture() {
        hoversPage.getUsersHovers(1);

        assertThat(hoversPage.getUserHoverName()).contains("user1");
    }

    @Test
    public void shouldDisplayUserNameThreeWhenHoveringOverProfilePicture() {
        hoversPage.getUsersHovers(2);

        assertThat(hoversPage.getUserHoverName()).contains("user1");
    }
}