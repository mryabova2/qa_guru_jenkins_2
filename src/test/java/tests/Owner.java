package tests;

import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;


public class Owner {
    static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

        static String login = config.login();
        static String password = config.password();
        static String remote = "https://" + login +":" + password + "@selenoid.autotests.cloud/wd/hub";
}
