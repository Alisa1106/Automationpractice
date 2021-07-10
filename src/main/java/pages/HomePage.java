package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends HeaderPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static final String PRODUCT_ITEM_XPATH = "//*[contains(text(),'%s')]/ancestor::*[@class='product-container']";
    public static final String MORE_BUTTON_XPATH = PRODUCT_ITEM_XPATH + "//*[contains(@class,'button lnk_view')]";
    public static final String ADD_TO_CART_BUTTON_XPATH = PRODUCT_ITEM_XPATH + "//*[contains(@class,'ajax_add_to_cart_button')]";
    public static final String PRODUCT_PRICE_XPATH = "//*[contains(text(),'%s')]/ancestor::*[@class='right-block']//*[@class='price product-price']";

    public HomePage openPage() {
        super.openPage(AUTOMATIONPRACTICE_HOME_PAGE_URL);
        return this;
    }

    public HomePage moveToProductItem(String productName) {
        String productItem = String.format(PRODUCT_ITEM_XPATH, productName);
        waitForElementLocated(By.xpath(productItem), 20);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(productItem))).build().perform();
        return this;
    }

    public ProductDetailsPage clickMoreButton(String productName) {
        moveToProductItem(productName);
        driver.findElement(By.xpath(String.format(MORE_BUTTON_XPATH, productName))).click();
        return new ProductDetailsPage(driver);
    }

    public ProductAddedToCartModal clickAddToCartButton(String productName) {
        moveToProductItem(productName);
        driver.findElement(By.xpath(String.format(ADD_TO_CART_BUTTON_XPATH, productName))).click();
        return new ProductAddedToCartModal(driver);
    }
}