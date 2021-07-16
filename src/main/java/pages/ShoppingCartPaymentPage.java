package pages;

import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPaymentPage extends HeaderPage {

    public ShoppingCartPaymentPage(WebDriver driver) {
        super(driver);
    }

    public static final String PRODUCT_ITEM_XPATH = "//*[text()='%s']/ancestor::*[contains(@class,'cart_item')]";
    public static final String PRODUCT_COLOR_AND_SIZE_XPATH = "//*[text()='%s']/ancestor::*[@class='cart_description']//small//a";
    public static final String UNIT_PRODUCT_PRICE_XPATH = PRODUCT_ITEM_XPATH + "//*[@class='price']//*";
    public static final String PRODUCT_QUANTITY_XPATH = PRODUCT_ITEM_XPATH + "//*[contains(@class,'cart_quantity')]//*";

    @FindBy(xpath = "//*[@id='center_column']")
    WebElement centerColumn;

    @FindBy(id = "total_price")
    WebElement totalPrice;

    public ShoppingCartPaymentPage waitForPageOpened() {
        waitForElementLocated(centerColumn, SHORT_TIMEOUT);
        return this;
    }

    public String getProductColorAndSize(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_COLOR_AND_SIZE_XPATH, productName))).getText();
    }

    public String getUnitProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(UNIT_PRODUCT_PRICE_XPATH, productName))).getText();
    }

    public String getProductQuantity(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_QUANTITY_XPATH, productName))).getText();
    }

    public BankWirePaymentPage clickPayByBankWireButton() {
        new Button(driver, "Pay by bank wire").click();
        return new BankWirePaymentPage(driver);
    }

    public CheckPaymentPage clickPayByCheckButton() {
        new Button(driver, "Pay by check").click();
        return new CheckPaymentPage(driver);
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }
}