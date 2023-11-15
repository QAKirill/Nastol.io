package nastolio.web.utils;

import org.aeonbits.owner.ConfigFactory;

public enum ConfigReader {
    INSTANCE;

    private static final LoginConfig LOGIN_CONFIG =
            ConfigFactory.create(
                    LoginConfig.class,
                    System.getProperties()
            );

    public LoginConfig getCredentials() {
        return LOGIN_CONFIG;
    }
}
