package com.yourCompanyName.projectName.pages;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
    public static final Target USERNAME_LOGIN =  Target.the("User name ").locatedBy("#email");
    public static final Target PASSWORD_LOGIN =  Target.the("Pass word ").locatedBy("#password_1");
    public static final Target LOGIN_BUTTON =  Target.the("Login button ").locatedBy(".g-recaptcha");


}
