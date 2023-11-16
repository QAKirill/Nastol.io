package nastolio.web.utils;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:openLogin.properties"})

public interface LoginConfig extends Config{
    @Config.Key("login")
    @Config.DefaultValue("ghostman92%40rambler.ru")
    String login();

    @Config.Key("password")
    @Config.DefaultValue("12345678")
    String password();

    @Config.Key("loginPage")
    @Config.DefaultValue("/Login")
    String loginPage();
}
