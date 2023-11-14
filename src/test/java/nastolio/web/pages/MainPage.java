package nastolio.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private SelenideElement loginButton = $(byText("Вход")),
            profileAvatar = $(".header-profile__avatar"),
            searchInput = $("#app").$("form[method=get").$("input[name=query]");//(".search__input");


    @Step
    public MainPage openPage(){
        open("/");
        return this;
    }

    public MainPage login(){
        loginButton.click();
        return this;
    }

    public MainPage doSearch(String value){
        searchInput.sendKeys(value);
        searchInput.pressEnter();
        return this;
    }

    public boolean isProfileAvatarDisplayed(){
        return profileAvatar.isDisplayed();
    }
}
