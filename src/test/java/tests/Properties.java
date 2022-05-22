package tests;

import static tests.Owner.login;
import static tests.Owner.password;

public class Properties {
        static String baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
        static String browserSize = System.getProperty("browserSize", "1920x1080");
        static String remote = System.getProperty("remote","https://" + login +":" + password + "@selenoid.autotests.cloud/wd/hub");
    }
