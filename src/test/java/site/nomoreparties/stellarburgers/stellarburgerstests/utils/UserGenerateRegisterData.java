package site.nomoreparties.stellarburgers.stellarburgerstests.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerateRegisterData {
    public static String name;
    private static String email;
    private static String password;

    public static String getValidNameData() {
        name = RandomStringUtils.randomAlphabetic(4);
        return name;
    }

    public static String getValidEmailData() {
        email = RandomStringUtils.randomAlphabetic(2) + "@" + RandomStringUtils.randomAlphabetic(2) + "." + RandomStringUtils.randomAlphabetic(2);
        return email;
    }

    public static String getValidPasswordData() {
        password = "password";
        return password;
    }

    public static String getInvalidPasswordData() {
        password = "1234";
        return password;
    }
}
