package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class ProductDetailsPage extends HeaderPage {

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public static final String CHOOSE_COLOR_XPATH = "//*[@class='attribute_list']/descendant::*[contains(@name,'%s')]";

    @FindBy(id = "quantity_wanted")
    WebElement chooseProductQuantityField;

    @FindBy(id = "group_1")
    WebElement selectProductSize;

    @FindBy(xpath = "//*[@name='Submit']")
    WebElement addToCartButton;

    @FindBy(xpath = "//*[@id='center_column']")
    WebElement centerColumn;

    /**
     * Wait for product details page opened.
     *
     * @return the product details page
     */
    public ProductDetailsPage waitForPageOpened() {
        waitForElementLocated(centerColumn, SHORT_TIMEOUT);
        return this;
    }

    /**
     * Choose product quantity.
     *
     * @param quantity the quantity
     * @return the product details page
     */
    @Step("Clear choose product quantity field and fill in quantity: {quantity}")
    public ProductDetailsPage chooseProductQuantity(String quantity) {
        log.info("Clear product quantity field.");
        chooseProductQuantityField.clear();
        log.info(String.format("Fill in quantity: '%s' in product quantity field.", quantity));
        chooseProductQuantityField.sendKeys(quantity);
        return this;
    }

    /**
     * Select product size.
     *
     * @param size the size
     * @return the product details page
     */
    @Step("Select product size: {size}")
    public ProductDetailsPage selectProductSize(String size) {
        Select select = new Select(selectProductSize);
        log.info(String.format("Select product size: '%s'.", size));
        select.selectByVisibleText(size);
        return this;
    }

    /**
     * Chose product color.
     *
     * @param color the color
     * @return the product details page
     */
    @Step("Choose product color: {color}")
    public ProductDetailsPage choseProductColor(String color) {
        log.info(String.format("Choose product color: '%s'.", color));
        driver.findElement(By.xpath(String.format(CHOOSE_COLOR_XPATH, color))).click();
        return this;
    }

    /**
     * Click add to cart button.
     *
     * @return the product added to cart modal
     */
    @Step("Click button 'Add to cart'")
    public ProductAddedToCartModal clickAddToCartButton() {
        log.info("Click button 'Add to cart'.");
        addToCartButton.click();
        return new ProductAddedToCartModal(driver);
    }
}