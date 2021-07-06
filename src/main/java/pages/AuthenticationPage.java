package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public AuthenticationPage openPage() {
        super.openPage(AUTOMATIONPRACTICE_AUTHENTICATION_PAGE_URL);
        return this;
    }

    public MyAccountPage signIn(String email, String password) {
        waitForElementLocated(signInEmailInput, 20);
        signInEmailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButton.click();
        return new MyAccountPage(driver);
    }

    public String getErrorMessageText() {
        waitForElementLocated(errorMessageContainer, 10);
        return errorMessageContainer.getText();
    }

    public CreateAccountPage startCreateAccount(String email) {
        waitForElementLocated(createAccountEmailInput, 20);
        createAccountEmailInput.sendKeys(email);
        createAccountButton.click();
        return new CreateAccountPage(driver);
    }
}