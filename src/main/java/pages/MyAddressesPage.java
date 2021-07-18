package pages;

import elements.Button;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
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

    @Step("Open my address page")
    public MyAddressesPage openPage() {
        log.info("Open my address page URL " + AUTOMATIONPRACTICE_MY_ADDRESSES_PAGE_URL);
        super.openPage(AUTOMATIONPRACTICE_MY_ADDRESSES_PAGE_URL);
        return this;
    }

    public MyAddressesPage waitForPageOpened() {
        waitForElementLocated(centerColumn, SHORT_TIMEOUT);
        return this;
    }

    @Step("Click button 'Update address' for address: {addressAlias}")
    public YourAddressesPage clickUpdateAddressButton(String addressAlias) {
        log.info(String.format("Click button 'Update address' for address: '%s'.", addressAlias));
        driver.findElement(By.xpath(String.format(UPDATE_ADDRESS_BUTTON, addressAlias))).click();
        return new YourAddressesPage(driver);
    }

    public String getAddressLineText(String addressAlias) {
        return driver.findElement(By.xpath(String.format(ADDRESS_LINE, addressAlias))).getText();
    }

    public String getMobilePhoneLineText(String addressAlias) {
        return driver.findElement(By.xpath(String.format(MOBILE_PHONE_LINE, addressAlias))).getText();
    }

    @Step("Click button 'Add a new address'")
    public YourAddressesPage clickAddNewAddressButton() {
        log.info("Click button 'Add a new address'");
        new Button(driver, "Add a new address").click();
        return new YourAddressesPage(driver);
    }
}