package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.AuthenticationPage;

public class AuthenticationSteps {

    private final AuthenticationPage authenticationPage;

    public AuthenticationSteps(WebDriver driver) {
        authenticationPage = new AuthenticationPage(driver);
    }

    @Step("Sign in with valid credentials")
    public AuthenticationSteps signIn(String email, String password) {
        authenticationPage
                .openPage()
                .signIn(email, password);
        return this;
    }

    @Step("Try sign in with invalid credentials")
    public String invalidSignIn(String email, String password) {
        authenticationPage
                .openPage()
                .signIn(email, password);
        return authenticationPage.getErrorMessageText();
    }
}