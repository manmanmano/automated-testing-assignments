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

        assertThat(hoversPage.getUserNameOnHover(0)).contains("user1");
    }

    @Test
    public void shouldDisplayUserNameTwoWhenHoveringOverProfilePicture() {

        assertThat(hoversPage.getUserNameOnHover(1)).contains("user1");
    }

    @Test
    public void shouldDisplayUserNameThreeWhenHoveringOverProfilePicture() {

        assertThat(hoversPage.getUserNameOnHover(2)).contains("user2");
    }
}