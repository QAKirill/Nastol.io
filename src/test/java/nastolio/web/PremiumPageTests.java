package nastolio.web;

import io.qameta.allure.Epic;
import nastolio.web.pages.MainPage;
import nastolio.web.pages.PremiumPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Premium page")
public class PremiumPageTests extends TestBase {

    MainPage mainPage = new MainPage();

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
}
