package nastolio.web;

import nastolio.web.pages.GamePage;
import nastolio.web.pages.LoginPage;
import nastolio.web.pages.MainPage;
import nastolio.web.pages.SearchPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Successful login")
    void successfulLoginTest() {
        LoginPage loginPage = new LoginPage();

        mainPage.openPage();

        step("Do login", () -> {
            mainPage.login();
            loginPage.setEmail("ghostman92@rambler.ru")
                    .setPassword("12345678")
                    .doLogin();
        });

        step("Check that profile avatar is displayed", () ->
                assertTrue(mainPage.isProfileAvatarDisplayed()));
    }

    @Test
    @DisplayName("Find and open game card")
    void openGameCard() {
        mainPage.openPage();

        step("Search game", () ->
                mainPage.doSearch("Tarraforming Mars"));

        SearchPage searchPage = new SearchPage();

        step("Open game page", () ->
                searchPage.firstHexagonClick());

        GamePage gamePage = new GamePage();

        step("Verify game displayed attributes", () -> {
            assertTrue(gamePage.nameDisplayed());
            assertTrue(gamePage.englishNameDisplayed());
            assertTrue(gamePage.gameImageDisplayed());
        });
    }
}
