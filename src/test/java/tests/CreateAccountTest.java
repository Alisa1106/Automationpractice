package tests;

import constants.ITestConstants;
import objects.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_data.ITestData;
import utils.Retry;

public class CreateAccountTest extends BaseTest implements ITestData, ITestConstants {

    /**
     * Check that account is created.
     */
    @Test(description = "Check that account is created", retryAnalyzer = Retry.class)
    public void createAccountTest() {
        Account account = new Account(FIRST_NAME, LAST_NAME, CREATE_ACCOUNT_PASSWORD, ADDRESS, CITY, STATE, ZIP_CODE,
                COUNTRY, MOBILE_PHONE);
        createAccountSteps
                .createAccount(getRandomChar() + EMAIL_DOMAIN_NAME, account);
        Assert.assertEquals(myAccountSteps.getMyAccountName(), account.getFirstName() + " " + account.getLastName());
    }
}