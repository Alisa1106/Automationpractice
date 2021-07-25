package tests;

import constants.ITestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_data.ITestData;
import utils.PropertyReader;
import utils.Retry;

public class SignInTest extends BaseTest implements ITestConstants {

    /**
     * Check possibility of sign in site with valid credentials.
     */
    @Test(description = "Check possibility of sign in site with valid credentials", retryAnalyzer = Retry.class)
    public void signInWithValidCredentialsTest() {
        authenticationSteps
                .signIn(System.getenv().getOrDefault(EMAIL_PROPERTY, PropertyReader.getProperty(EMAIL_PROPERTY)),
                        System.getenv().getOrDefault(PASSWORD_PROPERTY, PropertyReader.getProperty(PASSWORD_PROPERTY)));
        Assert.assertEquals(myAccountSteps.getMyAccountName(), MY_ACCOUNT_NAME);
    }

    /**
     * Check that when sign in site with invalid credentials error message is displayed.
     *
     * @param email    the email
     * @param password the password
     * @param error    the error
     */
    @Test(description = "Check that when sign in site with invalid credentials error message is displayed",
            retryAnalyzer = Retry.class, dataProvider = "Invalid sign in credentials", dataProviderClass = ITestData.class)
    public void signInWithInvalidCredentialsTest(String email, String password, String error) {
        Assert.assertEquals(authenticationSteps.invalidSignIn(email, password), error);
    }
}