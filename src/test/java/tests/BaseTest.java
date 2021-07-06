package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.AuthenticationSteps;
import steps.CreateAccountSteps;
import steps.MyAccountSteps;

public class BaseTest {
    WebDriver driver;
    AuthenticationSteps authenticationSteps;
    MyAccountSteps myAccountSteps;
    CreateAccountSteps createAccountSteps;

    @BeforeMethod
    public void InitTest() {
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
    }
}