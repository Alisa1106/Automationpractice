package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationByCheckPage extends HeaderPage {

    public OrderConfirmationByCheckPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@class,'box')]")
    WebElement orderConfirmation;

    /**
     * Gets order reference.
     *
     * @return the order reference
     */
    public String getOrderReference() {
        String orderInformationText = this.orderConfirmation.getText();
        String[] orderInformationLines = orderInformationText.split("\n");
        String[] referenceInfo = orderInformationLines[4].split(" ");
        return referenceInfo[9].replace(".", "");
    }
}