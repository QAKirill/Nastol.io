package nastolio.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private SelenideElement loginButton = $(byText("Вход")),
            profileAvatar = $(".header-profile__avatar"),
            searchInput = $("#app").$("form[method=get").$("input[name=query]"),
            games = $(".menu").$("a[href=https\\:\\/\\/nastol\\.io\\/\\@testHedgehog\\/games"),
            addGameButton = $(".content-container").$(".users-add-game").$("[type=button]"),
            gameSearch = $(".modal-content").$("#game"),
            addButton = $(".modal-content").$("button[title=Добавить]"),
            gameInCollection = $("a[href=\\/terraforming_mars]");


    @Step
    public MainPage openPage(){
        open("/");
        return this;
    }

    public MainPage openLogin(){
        loginButton.click();
        return this;
    }

    @Step("Do login")
    public MainPage login() {
        LoginPage loginPage = new LoginPage();

        openLogin();
        loginPage.setEmail("ghostman92@rambler.ru")
                .setPassword("12345678")
                .doLogin();

        return this;
    }

    public MainPage doSearch(String value){
        searchInput.sendKeys(value);
        searchInput.pressEnter();
        return this;
    }

    public MainPage openGamesCollection(){
        games.click();
        return this;
    }

    public MainPage addGameButtonClick(){
        addGameButton.click();
        return this;
    }

    public MainPage searchGame(String value){
        gameSearch.sendKeys(value);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        gameSearch.pressEnter();

        return this;
    }

    public MainPage addGame(){
        addButton.click();
        return this;
    }

    public boolean gameInCollection(){
        return gameInCollection.exists();
    }

    public boolean isProfileAvatarDisplayed(){
        return profileAvatar.isDisplayed();
    }
}
