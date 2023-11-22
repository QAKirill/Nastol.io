package nastolio.web;

import io.qameta.allure.Epic;
import nastolio.web.pages.GamePage;
import nastolio.web.pages.MainPage;
import nastolio.web.pages.SearchPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Game card")
public class GameCardTests extends TestBase{

    MainPage mainPage = new MainPage();
    GamePage gamePage = new GamePage();

    @Test
    @DisplayName("Find and open game card")
    void openGameCardTest() {
        mainPage.openPage()
                .searchGame("Terraforming Mars");

        SearchPage searchPage = new SearchPage();
        searchPage.firstHexagonClick();

        step("Verify game displayed attributes", () -> {
            assertTrue(gamePage.nameDisplayed("Покорение Марса (2016)"));
            assertTrue(gamePage.englishNameDisplayed("Terraforming Mars"));
            assertTrue(gamePage.gameImageDisplayed());
        });
    }
}
