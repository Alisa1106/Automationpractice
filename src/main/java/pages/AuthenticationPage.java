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

    /**
     * Open authentication page.
     *
     * @return the authentication page
     */
    @Step("Open authentication page")
    public AuthenticationPage openPage() {
        super.openPage(AUTOMATIONPRACTICE_AUTHENTICATION_PAGE_URL);
        return this;
    }

    /**
     * Sign in.
     *
     * @param email    the email
     * @param password the password
     * @return the my account page
     */
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

    /**
     * Gets error message text.
     *
     * @return the error message text
     */
    @Step("Get error message text")
    public String getErrorMessageText() {
        waitForElementLocated(errorMessageContainer, SHORT_TIMEOUT);
        return errorMessageContainer.getText();
    }

    /**
     * Fill create account email field.
     *
     * @param email the email
     * @return the authentication page
     */
    @Step("Fill in {email} in create account email field")
    public AuthenticationPage fillCreateAccountEmailField(String email) {
        waitForElementLocated(createAccountEmailInput, LONG_TIMEOUT);
        log.info(String.format("Fill in email: '%s' in create account email field.", email));
        createAccountEmailInput.sendKeys(email);
        return this;
    }

    /**
     * Click create account button.
     *
     * @return the create account page
     */
    @Step("Click button 'Create an account'")
    public CreateAccountPage clickCreateAccountButton() {
        log.info("Click button 'Create an account'.");
        createAccountButton.click();
        return new CreateAccountPage(driver);
    }
}