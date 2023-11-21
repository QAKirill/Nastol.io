package nastolio.web;

import com.codeborne.selenide.Selenide;
import nastolio.web.pages.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.*;

public class DiscussionTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Left comment on discussion")
    void successfulLeftCommentTest() {
        String comment = "Вы абсолютно правы!";
        mainPage.openPage()
                .login()
                .sideMenuClick("Обсуждения");

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
