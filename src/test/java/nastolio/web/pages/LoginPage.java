package nastolio.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement email = $("#email"),
            password = $("#password"),
            loginButton = $(byText("Войти"));

    public LoginPage loginAsUser(String email, String password){
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        loginButton.click();
        return this;
    }
}
