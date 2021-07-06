package pages;

import objects.Account;
import elements.DropDown;
import elements.Input;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends HeaderPage {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "submitAccount")
    WebElement registerButton;

    @FindBy(className = "account_creation")
    WebElement accountCreationTable;

    public MyAccountPage createAccount(Account account) {
        waitForElementLocated(accountCreationTable, 10);
        new Input(driver, "First name").writeText(account.getFirstName());
        new Input(driver, "Last name").writeText(account.getLastName());
        new Input(driver, "Password ").writeText(account.getPassword());
        new Input(driver, "Address").writeText(account.getAddress());
        new Input(driver, "City").writeText(account.getCity());
        new DropDown(driver, "State").select(account.getState());
        new Input(driver, "Zip/Postal Code").writeText(account.getZip_code());
        new DropDown(driver, "Country").select(account.getCountry());
        new Input(driver, "Mobile phone").writeText(account.getMobile_phone());
        new Input(driver, "Assign an address alias for future reference.").writeText(account.getAddress_alias());
        registerButton.click();
        return new MyAccountPage(driver);
    }
}