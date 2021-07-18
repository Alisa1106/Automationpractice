package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class AuthenticationPage extends HeaderPage {

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    WebElement signInEmailInput;

    @FindBy(id = "passwd")
    WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    WebElement signInButton;

    @FindBy(className = "alert-danger")
    WebElement errorMessageContainer;

    @FindBy(id = "email_create")
    WebElement createAccountEmailInput;

    @FindBy(id = "SubmitCreate")
    WebElement createAccountButton;

    @Step("Open authentication page")
    public AuthenticationPage openPage() {
        log.info("Open authentication page URL " + AUTOMATIONPRACTICE_AUTHENTICATION_PAGE_URL);
        super.openPage(AUTOMATIONPRACTICE_AUTHENTICATION_PAGE_URL);
        return this;
    }

    @Step("Fill in {email} and {password} in sign in fields and click button 'Sign in'")
    public MyAccountPage signIn(String email, String password) {
        waitForElementLocated(signInEmailInput, LONG_TIMEOUT);
        log.info(String.format("Fill in email: '%s' in sign in email field.", email));
        signInEmailInput.sendKeys(email);
        log.info(String.format("Fill in password: '%s' in password field.", password));
        passwordInput.sendKeys(password);
        log.info("Click button 'Sign in'.");
        signInButton.click();
        return new MyAccountPage(driver);
    }

    @Step("Get error message text")
    public String getErrorMessageText() {
        waitForElementLocated(errorMessageContainer, SHORT_TIMEOUT);
        return errorMessageContainer.getText();
    }

    @Step("Fill in {email} in create account email field and click button 'Create an account'")
    public CreateAccountPage clickCreateAccountButton(String email) {
        waitForElementLocated(createAccountEmailInput, LONG_TIMEOUT);
        log.info(String.format("Fill in email: '%s' in create account email field.", email));
        createAccountEmailInput.sendKeys(email);
        log.info("Click button 'Create an account'.");
        createAccountButton.click();
        return new CreateAccountPage(driver);
    }
}