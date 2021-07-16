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

    public CartDropdown waitForPageOpened() {
        waitForElementLocated(cartDropdownContent, 10);
        return this;
    }

    public String getProductColorAndSize(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_COLOR_AND_SIZE_XPATH, productName))).getText();
    }

    public String getProductQuantity(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_QUANTITY_XPATH, productName))).getText();
    }

    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE_XPATH, productName))).getText();
    }

    public String getProductPriceForOnePiece(String productName) {
        String productPrice = getProductPrice(productName).replace("$", "");
        float price = Float.parseFloat(productPrice);
        int quantity = Integer.parseInt(getProductQuantity(productName));
        float priceForOnePiece = price / quantity;
        String productPriceForOnePiece = Float.toString(priceForOnePiece);
        return "$" + productPriceForOnePiece + "0";
    }
}