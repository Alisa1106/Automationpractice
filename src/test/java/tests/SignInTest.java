package tests;

import constants.ITestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_data.ITestData;
import utils.PropertyReader;

public class SignInTest extends BaseTest implements ITestConstants {

    @Test
    public void signInWithValidCredentialsTest() {
        authenticationSteps
                .signIn(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")),
                        System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        Assert.assertEquals(myAccountSteps.getMyAccountName(), MY_ACCOUNT_NAME);
    }

    @Test(dataProvider = "Invalid sign in credentials", dataProviderClass = ITestData.class)
    public void signInWithInvalidCredentialsTest(String email, String password, String error) {
        Assert.assertEquals(authenticationSteps.invalidSignIn(email, password), error);
    }
}