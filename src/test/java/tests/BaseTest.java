package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.*;

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

    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        initSteps();
    }

    @AfterMethod(alwaysRun = true)
    public void endTest() {
        driver.quit();
    }

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
    }
}