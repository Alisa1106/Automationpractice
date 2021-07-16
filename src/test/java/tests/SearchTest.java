package tests;

import constants.ITestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class SearchTest extends BaseTest implements ITestConstants {

    @Test(description = "Check that search results are displayed")
    public void searchProductTest() {
        authenticationSteps
                .signIn(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")),
                        System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        Assert.assertTrue(searchSteps.isSearchingProductFound(PRINTED_CHIFFON_DRESS_PRODUCT));
    }
}