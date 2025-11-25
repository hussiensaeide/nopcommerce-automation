package Tests;

import Pages.AdminPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import static Utils.JsonReader.TestJson.getJson;

public class TestBase {
    String LoginData ="TestData/Login.json";
    SoftAssert softAssert = new SoftAssert();
    public LoginPage loginPage;
    public AdminPage adminPage;
    public static WebDriver driver;
    public LoginTest loginTest;
    @BeforeTest
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");

        // Initialize driver
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();


        // Open target URL
        driver.get("https://opensource-demo.orangehrmlive.com/");

        loginPage=new LoginPage(driver);
        adminPage=new AdminPage(driver);
        loginTest= new LoginTest();
    }
    //Login to the Website
    @BeforeClass
    public void UserCanLoginSuccessfully(){
        loginPage.EnterUserName(getJson(LoginData,"UserName"));
        loginPage.EnterPassword(getJson(LoginData,"Password"));
        loginPage.ClickOnLogin();
        loginPage.assertDashboardPageISPresent();
        softAssert.assertAll();


    }



//    @AfterTest
//    public void tearDown() {
//        driver.quit();
//    }
}
