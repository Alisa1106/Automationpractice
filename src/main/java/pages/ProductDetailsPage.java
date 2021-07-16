package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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

    public ProductDetailsPage waitForPageOpened() {
        waitForElementLocated(centerColumn, SHORT_TIMEOUT);
        return this;
    }

    public ProductDetailsPage chooseProductQuantity(String quantity) {
        chooseProductQuantityField.clear();
        chooseProductQuantityField.sendKeys(quantity);
        return this;
    }

    public ProductDetailsPage selectProductSize(String size) {
        Select select = new Select(selectProductSize);
        select.selectByVisibleText(size);
        return this;
    }

    public ProductDetailsPage choseProductColor(String color) {
        driver.findElement(By.xpath(String.format(CHOOSE_COLOR_XPATH, color))).click();
        return this;
    }

    public ProductAddedToCartModal clickAddToCartButton() {
        addToCartButton.click();
        return new ProductAddedToCartModal(driver);
    }
}