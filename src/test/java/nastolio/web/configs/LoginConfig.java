package nastolio.web.configs;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:login.properties"})

public interface LoginConfig extends Config{
    @Config.Key("login")
    @Config.DefaultValue("")
    String email();

    @Config.Key("password")
    @Config.DefaultValue("12345678")
    String password();
}
