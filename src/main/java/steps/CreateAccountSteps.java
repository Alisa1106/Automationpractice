package steps;

import io.qameta.allure.Step;
import objects.Account;
import org.openqa.selenium.WebDriver;
import pages.AuthenticationPage;
import pages.CreateAccountPage;

public class CreateAccountSteps {

    private final CreateAccountPage createAccountPage;
    private final AuthenticationPage authenticationPage;

    public CreateAccountSteps(WebDriver driver) {
        createAccountPage = new CreateAccountPage(driver);
        authenticationPage = new AuthenticationPage(driver);
    }

    @Step("Create account")
    public CreateAccountSteps createAccount(String email, Account account) {
        authenticationPage
                .openPage()
                .clickCreateAccountButton(email);
        createAccountPage
                .createAccount(account);
        return this;
    }
}