package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    //Elements
    public By UserNameTextBox= By.name("username");
    public By PasswordTextBox = By.name("password");
    public By LoginButton = By.xpath("//button[@type=\"submit\"]");
    public By DashboardText = By.xpath("//h6[text()=\"Dashboard\"]");

    //Methods

    public void EnterUserName(String Username){
        SetText(UserNameTextBox,Username);
    }

    public void EnterPassword(String Password){
        SetText(PasswordTextBox,Password);
    }

    public void ClickOnLogin(){
        Click(LoginButton);
    }

    public void assertDashboardPageISPresent(){
softAssertionTrue(DashboardText);
    }



    }


