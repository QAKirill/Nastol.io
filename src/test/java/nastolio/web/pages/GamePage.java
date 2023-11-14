package nastolio.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class GamePage {
    private SelenideElement
            name = $(".content-container").$(".games-one-info__name-block").$("h1").shouldHave(Condition.text("Покорение Марса (2016)")),
            englishName = $(".content-container").$(".games-one-info__name-block").$("div").shouldHave(Condition.text("Terraforming Mars")),
            gameImage = $(".content-container").$(".games-one-info").$(".games-main-image__img");

    public boolean nameDisplayed(){
        return name.exists();
    }

    public boolean englishNameDisplayed(){
        return englishName.exists();
    }

    public boolean gameImageDisplayed(){
        return gameImage.exists();
    }
}

