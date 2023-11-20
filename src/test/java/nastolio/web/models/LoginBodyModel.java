package nastolio.web.models;

import lombok.Data;
import nastolio.web.methods.StepsApi;
import nastolio.web.utils.ConfigReader;
import nastolio.web.utils.LoginConfig;

@Data
public class LoginBodyModel {
    String login, password, loginPage, token;
    private final LoginConfig loginConfig = ConfigReader.INSTANCE.getCredentials();

    public LoginBodyModel() {
        this.login = loginConfig.login();
        this.password = loginConfig.password();
        //this.loginPage = loginConfig.loginPage();
    }

    public String getAuthData() {
        return String.format("_token=%s&email=%s&password=%s", token, login, password);
    }
}