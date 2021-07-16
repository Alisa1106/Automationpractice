package pages;

import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAddressesPage extends HeaderPage {

    public MyAddressesPage(WebDriver driver) {
        super(driver);
    }

    public static final String ADDRESS_CARD = "//*[contains(text(),'%s')]/ancestor::*[contains(@class,'box')]";
    public static final String UPDATE_ADDRESS_BUTTON = ADDRESS_CARD + "/descendant::*[@title='Update']//*";
    public static final String ADDRESS_LINE = ADDRESS_CARD + "/descendant::*[@class='address_address1']";
    public static final String MOBILE_PHONE_LINE = ADDRESS_CARD + "/descendant::*[@class='address_phone_mobile']";

    @FindBy(xpath = "//*[@id='center_column']")
    WebElement centerColumn;

    public MyAddressesPage openPage() {
        super.openPage(AUTOMATIONPRACTICE_MY_ADDRESSES_PAGE_URL);
        return this;
    }

    public MyAddressesPage waitForPageOpened() {
        waitForElementLocated(centerColumn, SHORT_TIMEOUT);
        return this;
    }

    public YourAddressesPage clickUpdateAddressButton(String addressAlias) {
        driver.findElement(By.xpath(String.format(UPDATE_ADDRESS_BUTTON, addressAlias))).click();
        return new YourAddressesPage(driver);
    }

    public String getAddressLineText(String addressAlias) {
        return driver.findElement(By.xpath(String.format(ADDRESS_LINE, addressAlias))).getText();
    }

    public String getMobilePhoneLineText(String addressAlias) {
        return driver.findElement(By.xpath(String.format(MOBILE_PHONE_LINE, addressAlias))).getText();
    }

    public YourAddressesPage clickAddNewAddressButton() {
        new Button(driver, "Add a new address").click();
        return new YourAddressesPage(driver);
    }
}