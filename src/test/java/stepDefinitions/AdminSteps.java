package stepDefinitions;

import Tests.LoginTest;
import io.cucumber.java.en.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Pages.AdminPage;
import Pages.LoginPage;
import Tests.TestBase;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static Utils.JsonReader.TestJson.getJson;


public class AdminSteps extends TestBase {
    String LoginData ="TestData/Login.json";
    String UserData ="TestData/UserData.json";
    SoftAssert softAssert = new SoftAssert();
    LoginPage loginPage;
    AdminPage adminPage;
    int currentRecords;
    int finalRecords;
    public String Username= getJson(UserData,"UserName")+System.currentTimeMillis();

    @Given("User is on the login page")

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


    @Given("I am logged in as admin")
    public void i_am_logged_in_as_admin() {
        adminPage=new AdminPage(driver);

        loginPage.EnterUserName(getJson(LoginData,"UserName"));
        loginPage.EnterPassword(getJson(LoginData,"Password"));
        loginPage.ClickOnLogin();
        loginPage.assertDashboardPageISPresent();
        softAssert.assertAll();

    }


    @Given("I navigate to Admin page")
    public void i_navigate_to_admin_page() {
        adminPage.NavigateToAdminPage();
    }

    @When("I get the current number of records")
    public void i_get_the_current_number_of_records() {
        currentRecords = adminPage.GetTheNumberOfRecords();
    }

    @When("I add a new user")
    public void i_add_a_new_user() {

        adminPage.NavigateToAdminPage();
        adminPage.ClickOnAddButton();
        adminPage.SelectRoleFromDropList(getJson(UserData,"AdminRole"));
        adminPage.AddEmployeeName();
        adminPage.SelectStatusFromDropLsit(getJson(UserData,"EnabledStatus"));
        adminPage.AddUserName(Username);
        adminPage.AddPassword(getJson(UserData,"Password"));
        adminPage.AddConfirmPassword(getJson(UserData,"Confirm"));
        adminPage.ClickOnSaveButton();

    }

    @Then("the number of records should increase by 1")
    public void the_number_of_records_should_increase_by_1() {
        adminPage.NavigateToAdminPage();
        finalRecords=adminPage.GetTheNumberOfRecords();
        Assert.assertEquals(finalRecords, currentRecords + 1);
    }

    @When("I search for the created user")
    public void i_search_for_the_created_user() {
        adminPage.SearchForUSerName(Username);
    }

    @When("I delete the user")
    public void i_delete_the_user() {
        adminPage.DeleteRecord();
    }

    @Then("the number of records should decrease by 1")
    public void the_number_of_records_should_decrease_by_1() {
        adminPage.NavigateToAdminPage();
        int updated = adminPage.GetTheNumberOfRecords();
        Assert.assertEquals(updated, finalRecords - 1);
        driver.close();
    }

}
