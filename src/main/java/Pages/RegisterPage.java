package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage extends PageBase{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    //Elements
    public By GenderMaleButton =By.xpath("//*[@id='gender-male']");
    public By FirstNameField = By.xpath("//*[@id='FirstName']");
    public By LastNameField = By.xpath("//*[@id='LastName']");
    public By EmailField = By.xpath("//*[@id='Email']");
    public By CompanyNameField = By.xpath("//*[@id='Company']");
    public By PasswordField = By.xpath("//*[@id='Password']");
    public By ConfirmPasswordField = By.xpath("//*[@id='ConfirmPassword']");
    public By RegisterButton = By.xpath("//*[@id='register-button']");
    public By SuccessMessage = By.xpath("//*[@class='result']");

    //Methods

    public void SelectMaleGender(){
        Click(GenderMaleButton);
    }
    public void SetFirstName(String FirstName){
        SetText(FirstNameField,FirstName);
    }
    public void SetLastName(String LastName){
        SetText(LastNameField,LastName);
    }
    public void SetEmail(String Email){
        SetText(EmailField,Email);
    }
    public void SetCompanyName(String CompanyName){
        SetText(CompanyNameField,CompanyName);
    }
    public void SetPassword(String Password){
        SetText(PasswordField,Password);
    }
    public void SetConfirmPassword(String ConfirmPassword){
        SetText(ConfirmPasswordField,ConfirmPassword);
    }
    public void ClickOnRegisterButton(){
        Click(RegisterButton);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.xpath("//*[contains(text(),'Verifying')]")));
        } catch (TimeoutException e) {
            System.out.println("Cloudflare took too long.");
        }


    }
    public void AssertSuccessfulRegister(String msg){
        softAssertionEqual(SuccessMessage,msg);

    }








    }


