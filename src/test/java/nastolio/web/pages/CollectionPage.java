package nastolio.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CollectionPage {
    private SelenideElement
            addGameButton = $(".content-container").$(".users-add-game").$("[type=button]"),
            gameSearch = $(".modal-content").$("#game"),
            addButton = $(".modal-content").$("button[title=Добавить]"),
            gameInCollection = $("a[href=\\/terraforming_mars]");

    public CollectionPage addGameButtonClick(){
        addGameButton.click();
        return this;
    }

    public CollectionPage searchGame(String value){
        gameSearch.sendKeys(value);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        gameSearch.pressEnter();

        return this;
    }

    public CollectionPage addGame(){
        addButton.click();
        return this;
    }

    public CollectionPage openGameCardFromCollection(){
        gameInCollection.click();
        return this;
    }

    public boolean gameInCollection(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return gameInCollection.exists();
    }
}
