package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
    }
public  By RegisterPage = By.xpath("//*[@class='ico-register']");

public void NavigateToRegisterPage(){
    Click(RegisterPage);
}
}
