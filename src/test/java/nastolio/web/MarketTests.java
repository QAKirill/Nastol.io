package nastolio.web;

import io.qameta.allure.Epic;
import nastolio.web.pages.MainPage;
import nastolio.web.pages.MarketOffersPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Epic("Market")
public class MarketTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Successful find offers on market")
    void findGameOffersOnMarketTest() {
        mainPage.openPage()
                .sideMenuClick("Купить игру");

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
}
