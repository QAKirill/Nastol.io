package nastolio.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {
    private SelenideElement firstHex = $$(".hexagon-list-item__inner")
            .first().$(byXpath("parent::*"));

    @Step("Open first game page")
    public SearchPage firstHexagonClick(){
        firstHex.click();
        return this;
    }
}
