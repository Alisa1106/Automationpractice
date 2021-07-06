package steps;

import org.openqa.selenium.WebDriver;
import pages.AuthenticationPage;

public class AuthenticationSteps {

    private final AuthenticationPage authenticationPage;

    public AuthenticationSteps(WebDriver driver) {
        authenticationPage = new AuthenticationPage(driver);
    }

    public AuthenticationSteps signIn(String email, String password) {
        authenticationPage
                .openPage()
                .signIn(email, password);
        return this;
    }

    public String invalidSignIn(String email, String password) {
        authenticationPage
                .openPage()
                .signIn(email, password);
        return authenticationPage.getErrorMessageText();
    }
}