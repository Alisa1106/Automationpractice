package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class SearchSteps {

    private final HomePage homePage;

    public SearchSteps(WebDriver driver) {
        homePage = new HomePage(driver);
    }

    @Step("Get search result list and check that it isn`t empty")
    public boolean isSearchingProductFound(String productName) {
        return homePage
                .searchProduct(productName)
                .isSearchResultNotEmpty();
    }
}