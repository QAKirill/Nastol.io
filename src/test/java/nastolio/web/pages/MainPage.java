package nastolio.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import nastolio.web.configs.ConfigReader;
import nastolio.web.configs.LoginConfig;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private SelenideElement loginButton = $(byText("Вход")),
            profileAvatar = $(".header-profile__avatar"),
            searchInput = $("#app").$("form[method=get").$("input[name=query]"),
            games = $(".menu").$("a[href=https\\:\\/\\/nastol\\.io\\/\\@testHedgehog\\/games]"),
            menuPremium = $(".menu-premium"),
            menu = $(".menu");


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
        LoginConfig config = ConfigReader.INSTANCE.getCredentials();

        openLogin();
        loginPage.loginAsUser(config.email(), config.password());

        return this;
    }

    @Step("Search game")
    public MainPage searchGame(String value){
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

    @Step("Open {value} page")
    public MainPage sideMenuClick(String value){
        menu.$(byText(value)).click();
        return this;
    }

    public boolean isProfileAvatarDisplayed(){
        return profileAvatar.isDisplayed();
    }
}
