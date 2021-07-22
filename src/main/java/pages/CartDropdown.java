package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartDropdown extends HeaderPage {

    public CartDropdown(WebDriver driver) {
        super(driver);
    }

    public static final String PRODUCT_BLOCK_XPATH = "//*[contains(text(),'%s')]/ancestor::*[contains(@class,'first_item')]";
    public static final String PRODUCT_QUANTITY_XPATH = PRODUCT_BLOCK_XPATH + "//*[@class='quantity']";
    public static final String PRODUCT_COLOR_AND_SIZE_XPATH = PRODUCT_BLOCK_XPATH + "//*[@class='product-atributes']//*";
    public static final String PRODUCT_PRICE_XPATH = PRODUCT_BLOCK_XPATH + "//*[@class='price']";

    @FindBy(className = "cart_block_list")
    WebElement cartDropdownContent;

    /**
     * Wait for cart dropdown page opened.
     *
     * @return the cart dropdown
     */
    public CartDropdown waitForPageOpened() {
        waitForElementLocated(cartDropdownContent, SHORT_TIMEOUT);
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
     * Gets product quantity.
     *
     * @param productName the product name
     * @return the product quantity
     */
    public String getProductQuantity(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_QUANTITY_XPATH, productName))).getText();
    }

    /**
     * Gets product price.
     *
     * @param productName the product name
     * @return the product price
     */
    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE_XPATH, productName))).getText();
    }

    /**
     * Gets product price for one item.
     *
     * @param productName the product name
     * @return the product price for one item
     */
    public String getProductPriceForOneItem(String productName) {
        String productPrice = getProductPrice(productName).replace("$", "");
        float price = Float.parseFloat(productPrice);
        int quantity = Integer.parseInt(getProductQuantity(productName));
        float priceForOneItem = price / quantity;
        String productPriceForOneItem = Float.toString(priceForOneItem);
        return "$" + productPriceForOneItem + "0";
    }
}