package nastolio.web;

import com.codeborne.selenide.Selenide;
import nastolio.web.pages.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.*;

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
    void openGameCardTest() {
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

        step("Check that the game is added to collection", () -> {
            assertTrue(collectionPage.gameInCollection());
        });
    }

    @Test
    @DisplayName("Check elements on Premium page")
    void premiumPageTest() {
        mainPage.openPage()
                .premiumClick();

        PremiumPage premiumPage = new PremiumPage();

        step("Check elements on page", () -> {
            assertTrue(premiumPage.checkHeader());
            assertTrue(premiumPage.checkSubscribeButton());
        });
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

    @Test
    @DisplayName("Successful find offers on market")
    void findGameOffersOnMarketTest() {
        mainPage.openPage()
                .openMarketOffers();

        MarketOffersPage offers = new MarketOffersPage();

        step("Find game offers", () -> {
            offers.setName("Манчкин")
                    .setCity("Москва")
                    .submit();
        });

        step("Check result", () -> {
            assertFalse(offers.hasOffers());
        });
    }

    @Test
    @DisplayName("Left comment on discussion")
    void successfulLeftCommentTest() {
        String comment = "Вы абсолютно правы!";
        mainPage.openPage()
                .login()
                .openDiscussions();

        DiscussionsPage discussionsPage = new DiscussionsPage();

        step("Left comment", () ->
        discussionsPage
                .openFirst()
                .leftComment(comment));

        step("Check result", () -> {
            assertTrue(discussionsPage.findMyComment(comment));
        });

        step("Clean up after yourself", () -> {
            Selenide.refresh();
            discussionsPage.deleteComment();
        });
    }
}
