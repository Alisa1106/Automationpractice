package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.*;
import utils.TestListener;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    AuthenticationSteps authenticationSteps;
    MyAccountSteps myAccountSteps;
    CreateAccountSteps createAccountSteps;
    HomeSteps homeSteps;
    ShoppingCartSummarySteps shoppingCartSummarySteps;
    ShoppingCartPaymentSteps shoppingCartPaymentSteps;
    ShoppingCartAddressSteps shoppingCartAddressSteps;
    BankWirePaymentSteps bankWirePaymentSteps;
    CheckPaymentSteps checkPaymentSteps;
    OrderConfirmationSteps orderConfirmationSteps;
    MyAddressesSteps myAddressesSteps;
    OrderHistorySteps orderHistorySteps;
    CartDropdownSteps cartDropdownSteps;
    SearchSteps searchSteps;

    /**
     * Init test.
     * This method performed before the test method.
     *
     * @param context the context
     */
    @BeforeMethod
    public void initTest(ITestContext context) {

        WebDriverManager.chromedriver().setup();
        try {
            driver = new ChromeDriver();
        } catch (SessionNotCreatedException e) {
            log.fatal("ERROR: Chromedriver isn't started. " + e.getMessage());
        }
        driver.manage().window().maximize();
        initSteps();
        String variable = "driver";
        log.debug("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);
    }

    /**
     * End test.
     * This method performed after test method regardless of the test result.
     */
    @AfterMethod(alwaysRun = true)
    public void endTest() {
        log.debug("Close browser.");
        driver.quit();
    }

    /**
     * Init steps.
     */
    public void initSteps() {
        authenticationSteps = new AuthenticationSteps(driver);
        myAccountSteps = new MyAccountSteps(driver);
        createAccountSteps = new CreateAccountSteps(driver);
        homeSteps = new HomeSteps(driver);
        shoppingCartSummarySteps = new ShoppingCartSummarySteps(driver);
        shoppingCartPaymentSteps = new ShoppingCartPaymentSteps(driver);
        shoppingCartAddressSteps = new ShoppingCartAddressSteps(driver);
        bankWirePaymentSteps = new BankWirePaymentSteps(driver);
        checkPaymentSteps = new CheckPaymentSteps(driver);
        orderConfirmationSteps = new OrderConfirmationSteps(driver);
        myAddressesSteps = new MyAddressesSteps(driver);
        orderHistorySteps = new OrderHistorySteps(driver);
        cartDropdownSteps = new CartDropdownSteps(driver);
        searchSteps = new SearchSteps(driver);
    }
}