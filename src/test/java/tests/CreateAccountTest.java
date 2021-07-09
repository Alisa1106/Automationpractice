package tests;

import objects.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.ITestData;

public class CreateAccountTest extends BaseTest implements ITestData {

    @Test
    public void createAccountTest() {
        Account account = new Account("Hanna", "Smith", "123456", "75 PARK PLACE 8TH FLOOR",
                "NY", "New York", "12345", "United States", "12345678912", "New customer address");
        createAccountSteps
                .createAccount(getRandomChar() + "@mailinator.com", account);
        Assert.assertEquals(myAccountSteps.getMyAccountName(), account.getFirstName() + " " + account.getLastName());
    }
}