package tests;

import constants.ITestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;
import utils.Retry;

public class SearchTest extends BaseTest implements ITestConstants {

    /**
     * Check that search results are displayed.
     */
    @Test(description = "Check that search results are displayed", retryAnalyzer = Retry.class)
    public void searchProductTest() {
        authenticationSteps
                .signIn(System.getenv().getOrDefault(EMAIL_PROPERTY, PropertyReader.getProperty(EMAIL_PROPERTY)),
                        System.getenv().getOrDefault(PASSWORD_PROPERTY, PropertyReader.getProperty(PASSWORD_PROPERTY)));
        Assert.assertTrue(searchSteps.isSearchingProductFound(PRINTED_CHIFFON_DRESS_PRODUCT));
    }
}