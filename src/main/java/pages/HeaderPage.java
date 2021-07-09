package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage {

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "account")
    WebElement myCustomerAccountNameField;

    public String getCustomerNameText() {
        waitForElementLocated(myCustomerAccountNameField, 10);
        return myCustomerAccountNameField.getText();
    }
}