package icd0004.selenide_with_pom;

import icd0004.HoversPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HoversPageTests extends BaseTest {

    private static HoversPage hoversPage;
    private static final String VIEW_PROFILE_URL = "https://the-internet.herokuapp.com/users/";

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
    public void shouldDisplayUserOneNameWhenHoveringOverProfilePicture() {
        assertThat(hoversPage.getUserNameOnHover(0)).contains("user1");
    }

    @Test
    public void shouldDisplayUserTwoNameWhenHoveringOverProfilePicture() {
        assertThat(hoversPage.getUserNameOnHover(1)).contains("user2");
    }

    @Test
    public void shouldDisplayUserThreeNameWhenHoveringOverProfilePicture() {
        assertThat(hoversPage.getUserNameOnHover(2)).contains("user3");
    }

    @Test
    public void shouldDisplayUserOneLinkWhenHoveringOverProfilePicture() {
        assertThat(hoversPage.getUserLinkOnHover(0)).isEqualTo(VIEW_PROFILE_URL + "1");
    }

    @Test
    public void shouldDisplayUserTwoLinkWhenHoveringOverProfilePicture() {
        assertThat(hoversPage.getUserLinkOnHover(1)).isEqualTo(VIEW_PROFILE_URL + "2");
    }

    @Test
    public void shouldDisplayUserThreeLinkWhenHoveringOverProfilePicture() {
        assertThat(hoversPage.getUserLinkOnHover(2)).isEqualTo(VIEW_PROFILE_URL + "3");
    }
}