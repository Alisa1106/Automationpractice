package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import objects.Account;
import elements.DropDown;
import elements.Input;
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

    @Step("Fill in account fields: {account} and click button 'Register'")
    public MyAccountPage createAccount(Account account) {
        waitForElementLocated(accountCreationTable, SHORT_TIMEOUT);
        log.info(String.format("Fill in first name: '%s' in first name field.", account.getFirstName()));
        new Input(driver, "First name").writeText(account.getFirstName());
        log.info(String.format("Fill in last name: '%s' in last name field.", account.getLastName()));
        new Input(driver, "Last name").writeText(account.getLastName());
        log.info(String.format("Fill in password: '%s' in password field.", account.getPassword()));
        new Input(driver, "Password").writeText(account.getPassword());
        log.info(String.format("Fill in address: '%s' in address field.", account.getAddress()));
        new Input(driver, "Address").writeText(account.getAddress());
        log.info(String.format("Fill in city: '%s' in city field.", account.getCity()));
        new Input(driver, "City").writeText(account.getCity());
        log.info(String.format("Select state: '%s' in state dropdown.", account.getState()));
        new DropDown(driver, "State").select(account.getState());
        log.info(String.format("Fill in zip-code: '%s' in zip-code field.", account.getZipCode()));
        new Input(driver, "Zip/Postal Code").writeText(account.getZipCode());
        log.info(String.format("Select country: '%s' in country dropdown.", account.getCountry()));
        new DropDown(driver, "Country").select(account.getCountry());
        log.info(String.format("Fill in mobile phone: '%s' in mobile phone field.", account.getMobilePhone()));
        new Input(driver, "Mobile phone").writeText(account.getMobilePhone());
        log.info("Click button 'Register'.");
        registerButton.click();
        return new MyAccountPage(driver);
    }
}