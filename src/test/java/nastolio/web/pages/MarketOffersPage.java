package nastolio.web.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MarketOffersPage {
    private SelenideElement
            gameNameInput = $(".market-filters").$("[aria-controls=vs1__listbox]"),
            cityInput = $(".market-filters").$("[aria-controls=vs2__listbox]"),
            submitButton = $(".market-filters").$("[type=submit]");

    private ElementsCollection offersList = $(".market-offers-list").$$("div");

    public MarketOffersPage setName(String value){
        gameNameInput.sendKeys(value);
        gameNameInput.pressEnter();
        return this;
    }

    public MarketOffersPage setCity(String value){
        cityInput.sendKeys(value);
        cityInput.pressEnter();
        return this;
    }

    public MarketOffersPage submit(){
        submitButton.click();
        return this;
    }

    public boolean hasOffers(){
        return offersList.isEmpty();
    }
}
