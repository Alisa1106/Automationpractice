package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import objects.Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class CreateAccountPage extends HeaderPage {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "submitAccount")
    WebElement registerButton;

    @FindBy(className = "account_creation")
    WebElement accountCreationTable;

    /**
     * Create account.
     *
     * @param account the account
     * @return the my account page
     */
    @Step("Fill in account fields: {account} and click button 'Register'")
    public MyAccountPage createAccount(Account account) {
        waitForElementLocated(accountCreationTable, SHORT_TIMEOUT);
        actions.fillInputField(FIRST_NAME, account.getFirstName());
        actions.fillInputField(LAST_NAME, account.getLastName());
        actions.fillInputField(PASSWORD, account.getPassword());
        actions.fillInputField(ADDRESS, account.getAddress());
        actions.fillInputField(CITY, account.getCity());
        actions.selectOption(STATE, account.getState());
        actions.fillInputField(ZIP_CODE, account.getZipCode());
        actions.selectOption(COUNTRY, account.getCountry());
        actions.fillInputField(MOBILE_PHONE, account.getMobilePhone());
        log.info("Click button 'Register'.");
        registerButton.click();
        return new MyAccountPage(driver);
    }
}