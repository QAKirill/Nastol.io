package nastolio.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class GamePage {
    private SelenideElement
            name = $(".content-container").$(".games-one-info__name-block").$("h1"),
            englishName = $(".content-container").$(".games-one-info__name-block").$("div"),
            gameImage = $(".content-container").$(".games-one-info").$(".games-main-image__img"),
            removeGame =$(".games-one-actions").$("#__BVID__55__BV_button_");

    public GamePage removeGame(){
        removeGame.shouldHave(text("Удалить из «Коллекция»"));
        removeGame.click();
        return this;
    }

    public boolean nameDisplayed(String value){
        return name.shouldHave(text(value)).exists();
    }

    public boolean englishNameDisplayed(String value){
        return englishName.shouldHave(text(value)).exists();
    }

    public boolean gameImageDisplayed(){
        return gameImage.exists();
    }
}

