package nastolio.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private SelenideElement loginButton = $(byText("Вход")),
            profileAvatar = $(".header-profile__avatar"),
            searchInput = $("#app").$("form[method=get").$("input[name=query]"),
            games = $(".menu").$("a[href=https\\:\\/\\/nastol\\.io\\/\\@testHedgehog\\/games]"),
            menuPremium = $(".menu-premium"),
            buyGames = $(".menu").$(byText("Купить игру")),
            discussions = $(".menu").$(byText("Обсуждения"));


    @Step("Open main page")
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

    @Step("Open collection page")
    public MainPage openGamesCollection(){
        games.click();
        return this;
    }

    @Step("Open premium page")
    public MainPage premiumClick(){
        menuPremium.click();
        return this;
    }

    @Step("Open market offers page")
    public MainPage openMarketOffers(){
        buyGames.click();
        return this;
    }

    @Step("Open discussions page")
    public MainPage openDiscussions(){
        discussions.click();
        return this;
    }

    public boolean isProfileAvatarDisplayed(){
        return profileAvatar.isDisplayed();
    }
}
