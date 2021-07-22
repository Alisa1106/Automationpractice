package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.MyAccountPage;

public class MyAccountSteps {

    private final MyAccountPage myAccountPage;

    public MyAccountSteps(WebDriver driver) {
        myAccountPage = new MyAccountPage(driver);
    }

    /**
     * Gets my account name.
     *
     * @return the my account name
     */
    @Step("Get customer name")
    public String getMyAccountName() {
        return myAccountPage.getCustomerNameText();
    }
}