package steps;

import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class SearchSteps {

    private final HomePage homePage;

    public SearchSteps(WebDriver driver) {
        homePage = new HomePage(driver);
    }

    public boolean isSearchingProductFound(String productName) {
        return homePage
                .searchProduct(productName)
                .isSearchResultNotEmpty();
    }
}