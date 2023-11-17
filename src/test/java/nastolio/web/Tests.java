package nastolio.web;

import nastolio.web.methods.StepsApi;
import nastolio.web.pages.GamePage;
import nastolio.web.pages.MainPage;
import nastolio.web.pages.SearchPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Successful Login")
    void successfulLoginTest() {
        mainPage.openPage().login();

        step("Check that profile avatar is displayed", () ->
                assertTrue(mainPage.isProfileAvatarDisplayed()));
    }

    @Test
    @DisplayName("Find and open game card")
    void openGameCard() {
        mainPage.openPage();

        step("Search game", () ->
                mainPage.doSearch("Terraforming Mars"));

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

    @Test
    void nameApi(){
        StepsApi authResponse = new StepsApi();
        authResponse.login();

        mainPage.openPage();
        step("Check that profile avatar is displayed", () ->
                assertTrue(mainPage.isProfileAvatarDisplayed()));
    }

    @Test
    @DisplayName("Successfully adding the game to user collection")
    void successfulAddGameToCollection() {
        mainPage.openPage().login();

        step("Add game to collection", () ->
                mainPage.openGamesCollection()
                        .addGameButtonClick()
                        .searchGame("Покорение марса ")
                        .addGame());

        step("Check that the game is added to collection", () -> {
                assertTrue(mainPage.gameInCollection());
        });
    }
}
