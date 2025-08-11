package Tests;

import Pages.HomePage;
import Pages.RegisterPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.HashMap;

public class TestBase {
    public RegisterPage registerPage;
    public HomePage homePage;
    public static WebDriver driver;
    public RegisterTest loginTest;
    @BeforeTest
    public void setup() {
        ChromeOptions options = new ChromeOptions();


        // Initialize driver
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();


        // Open target URL
        driver.get("https://demo.nopcommerce.com/");

        registerPage=new RegisterPage(driver);
        homePage=new HomePage(driver);
        loginTest= new RegisterTest();
    }
//    @AfterTest
//    public void tearDown() {
//        driver.quit();
//    }
}
