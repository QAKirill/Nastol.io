package nastolio.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    private SelenideElement firstHex = $(".content-container").$$("img")
            .first().$(byXpath("parent::*"));

    public SearchPage firstHexagonClick(){
        firstHex.click();
        return this;
    }
}
