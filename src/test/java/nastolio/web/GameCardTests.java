package nastolio.web;

import nastolio.web.pages.GamePage;
import nastolio.web.pages.MainPage;
import nastolio.web.pages.SearchPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameCardTests extends TestBase{

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Find and open game card")
    void openGameCardTest() {
        mainPage.openPage()
                .searchGame("Terraforming Mars");

        SearchPage searchPage = new SearchPage();
        searchPage.firstHexagonClick();

        GamePage gamePage = new GamePage();

        step("Verify game displayed attributes", () -> {
            assertTrue(gamePage.nameDisplayed());
            assertTrue(gamePage.englishNameDisplayed());
            assertTrue(gamePage.gameImageDisplayed());
        });
    }
}
