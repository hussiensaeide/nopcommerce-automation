package Tests;

import io.cucumber.java.StepDefinitionAnnotation;
import org.testng.annotations.Test;
import io.cucumber.java.en.*;

import org.testng.asserts.SoftAssert;

import static Utils.JsonReader.TestJson.getJson;


public class LoginTest extends TestBase {
String LoginData ="TestData/Login.json";
    SoftAssert softAssert = new SoftAssert();

@Test
public void UserCanLoginSuccessfully(){
    loginPage.EnterUserName(getJson(LoginData,"UserName"));
    loginPage.EnterPassword(getJson(LoginData,"Password"));
    loginPage.ClickOnLogin();
    loginPage.assertDashboardPageISPresent();

softAssert.assertAll();




}

}
