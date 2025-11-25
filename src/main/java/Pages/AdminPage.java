package Pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage extends PageBase{
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    //Elements

    public By AdminPage = By.linkText("Admin");
    public By RecordsFound = By.xpath("//div[@class=\"orangehrm-horizontal-padding orangehrm-vertical-padding\"]/child::span");
    public By AddButton = By.xpath("//*[contains(@class, 'oxd-button-icon')]");
    public By UserRoleDropListField =By.xpath("//div[@class=\"oxd-select-wrapper\"]/child::div[1]");
    public By EmployeeNameField = By.xpath("//input[@placeholder='Type for hints...']");
    public By StatusDropListField = By.xpath("(//div)[44]");
    public By UserNameField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    public By PasswordField = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']");
    public By ConfirmPasswordField=By.xpath("(//input[@type='password'])[2]");
    public By SaveButton = By.xpath("(//button[@type='submit'])");
    public By USerNameSearchField = By.xpath("//label[text()='Username']/../following-sibling::div//input");
    public By SearchButton = By.xpath("//button[normalize-space()='Search']");
    public By DeleteIcon = By.xpath("//i[@class='oxd-icon bi-trash']");
    public By YesDeleteButton = By.xpath("//button[normalize-space()='Yes, Delete']");

    //Methods

    public void NavigateToAdminPage(){
        Click(AdminPage);
    }

    public int GetTheNumberOfRecords(){
        waitElement(RecordsFound);
       String text= getContent(RecordsFound);
        String numberOnly = text.replaceAll("[^0-9]", "");
        return Integer.parseInt(numberOnly);

    }
public void ClickOnAddButton(){
        Click(AddButton);
}
public void SelectRoleFromDropList(String value){
        Click(UserRoleDropListField);
        Click(By.xpath("//div//span[text()=\""+value+"\"]/parent::div"));
}
public void AddEmployeeName(){
        SetText(EmployeeNameField,"Timo");

        Click(By.xpath("//span[text()=\"Timothy Lewis Amiano\"]"));


}
public void SelectStatusFromDropLsit(String value){
        Click(StatusDropListField);
        Click(By.xpath("//span[text()=\""+value+"\"]"));
}
public void AddUserName(String username){
        Click(UserNameField);
        SetText(UserNameField,username);
}
public void AddPassword(String Password){
        SetText(PasswordField,Password);
}
public void AddConfirmPassword(String ConfirmPassword){
        SetText(ConfirmPasswordField,ConfirmPassword);
}
public void ClickOnSaveButton(){
        Click(SaveButton);
    try {
        Thread.sleep(3000); // 3000 ملي ثانية = 3 ثواني
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
public void SearchForUSerName(String UserName){
SetText(USerNameSearchField,UserName);
        Click(SearchButton);
    }
public void DeleteRecord(){
        Click(DeleteIcon);
        Click(YesDeleteButton);
}



}
