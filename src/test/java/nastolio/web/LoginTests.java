package nastolio.web;

import nastolio.web.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Successful Login")
    void successfulLoginTest() {
        mainPage.openPage().login();

        step("Check that profile avatar is displayed", () ->
                assertTrue(mainPage.isProfileAvatarDisplayed()));
    }
}
