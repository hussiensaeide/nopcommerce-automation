package Tests;

import Pages.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static Utils.JsonReader.TestJson.getJson;


public class RegisterTest extends TestBase {
String RegisterData ="TestData/Register.json";
    SoftAssert softAssert = new SoftAssert();

@Test
public void RegisterMaleGender(){
    homePage.NavigateToRegisterPage();
    registerPage.SelectMaleGender();
    registerPage.SetFirstName(getJson(RegisterData,"FirstName"));
    registerPage.SetLastName(getJson(RegisterData,"LastName"));
    registerPage.SetEmail(getJson(RegisterData,"Email"));
    registerPage.SetCompanyName(getJson(RegisterData,"CompanyName"));
    registerPage.SetPassword(getJson(RegisterData,"Password"));
    registerPage.SetConfirmPassword(getJson(RegisterData,"Password"));
    registerPage.ClickOnRegisterButton();
    registerPage.AssertSuccessfulRegister(getJson(RegisterData,"SuccessMessage"));


}

}
