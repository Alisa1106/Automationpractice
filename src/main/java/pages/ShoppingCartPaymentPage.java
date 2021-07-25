package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
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

    /**
     * Wait for shopping cart payment page opened.
     *
     * @return the shopping cart payment page
     */
    public ShoppingCartPaymentPage waitForPageOpened() {
        waitForElementLocated(centerColumn, SHORT_TIMEOUT);
        return this;
    }

    /**
     * Gets product color and size.
     *
     * @param productName the product name
     * @return the product color and size
     */
    public String getProductColorAndSize(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_COLOR_AND_SIZE_XPATH, productName))).getText();
    }

    /**
     * Gets unit product price.
     *
     * @param productName the product name
     * @return the unit product price
     */
    public String getUnitProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(UNIT_PRODUCT_PRICE_XPATH, productName))).getText();
    }

    /**
     * Gets product quantity.
     *
     * @param productName the product name
     * @return the product quantity
     */
    public String getProductQuantity(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_QUANTITY_XPATH, productName))).getText();
    }

    /**
     * Click pay by bank wire button.
     *
     * @return the bank wire payment page
     */
    @Step("Click button 'Pay by bank wire'")
    public BankWirePaymentPage clickPayByBankWireButton() {
        actions.clickButton(PAY_BY_BANK_WIRE_BUTTON);
        return new BankWirePaymentPage(driver);
    }

    /**
     * Click pay by check button.
     *
     * @return the check payment page
     */
    @Step("Click button 'Pay by check'")
    public CheckPaymentPage clickPayByCheckButton() {
        actions.clickButton(PAY_BY_CHECK_BUTTON);
        return new CheckPaymentPage(driver);
    }

    /**
     * Gets total price.
     *
     * @return the total price
     */
    public String getTotalPrice() {
        return totalPrice.getText();
    }
}