package nastolio.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement email = $("#email"),
            password = $("#password"),
            loginButton = $(byText("Войти"));

    public LoginPage setEmail(String value){
        email.sendKeys(value);
        return this;
    }

    public LoginPage setPassword(String value){
        password.sendKeys(value);
        return this;
    }

    public LoginPage doLogin(){
        loginButton.click();
        return this;
    }
}
