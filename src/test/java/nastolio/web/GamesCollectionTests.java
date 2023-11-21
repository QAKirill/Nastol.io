package nastolio.web;

import io.qameta.allure.Epic;
import nastolio.web.pages.CollectionPage;
import nastolio.web.pages.GamePage;
import nastolio.web.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Games collections")
public class GamesCollectionTests extends TestBase {
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Successfully adding the game to user collection")
    void successfulAddGameToCollectionTest() {
        mainPage.openPage()
                .login()
                .openGamesCollection();

        CollectionPage collectionPage = new CollectionPage();

        step("Add game to collection", () -> {
            collectionPage.addGameButtonClick()
                    .searchGame("Покорение марса ")
                    .addGame();
        });

        step("Check that the game is added to collection", () ->
                assertTrue(collectionPage.gameInCollection()));
    }

    @Test
    @DisplayName("Successfully deleting game from collection")
    void successfulDeleteGameFromCollectionTest() {
        mainPage.openPage()
                .login()
                .openGamesCollection();

        CollectionPage collectionPage = new CollectionPage();

        step("Add game to collection", () -> {
            collectionPage.addGameButtonClick()
                    .searchGame("Покорение марса ")
                    .addGame();
        });

        step("Delete game from collection", () -> {
            collectionPage.openGameCardFromCollection();

            GamePage gamePage = new GamePage();
            gamePage.removeGame();

            mainPage.openGamesCollection();
        });

        step("Check that the game is deleted from collection", () -> {
            assertFalse(collectionPage.gameInCollection());
        });
    }
}
