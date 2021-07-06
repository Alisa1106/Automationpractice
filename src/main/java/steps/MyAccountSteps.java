package steps;

import org.openqa.selenium.WebDriver;
import pages.MyAccountPage;

public class MyAccountSteps {

    private final MyAccountPage myAccountPage;

    public MyAccountSteps(WebDriver driver) {
        myAccountPage = new MyAccountPage(driver);
    }

    public String getMyAccountName() {
    return myAccountPage.getCustomerNameText();
    }
}