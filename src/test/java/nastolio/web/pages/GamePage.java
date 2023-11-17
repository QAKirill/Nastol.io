package nastolio.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class GamePage {
    private SelenideElement
            name = $(".content-container").$(".games-one-info__name-block").$("h1").shouldHave(text("Покорение Марса (2016)")),
            englishName = $(".content-container").$(".games-one-info__name-block").$("div").shouldHave(text("Terraforming Mars")),
            gameImage = $(".content-container").$(".games-one-info").$(".games-main-image__img"),
            removeGame =$(".games-one-actions").$("#__BVID__55__BV_button_");

    public GamePage removeGame(){
        removeGame.shouldHave(text("Удалить из «Коллекция»"));
        removeGame.click();
        return this;
    }

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

