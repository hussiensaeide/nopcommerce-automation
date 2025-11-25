package Tests;

import io.cucumber.java.StepDefinitionAnnotations;
import org.testng.Assert;
import io.cucumber.java.en.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static Utils.JsonReader.TestJson.getJson;


public class AdminTest extends TestBase{

    SoftAssert softAssert = new SoftAssert();
    String UserData ="TestData/UserData.json";
    public String Username= getJson(UserData,"UserName")+System.currentTimeMillis();

@Test public void VerifyTheNumberOfRecords(){
    adminPage.NavigateToAdminPage();
         adminPage.GetTheNumberOfRecords();
    }
    @Test
    public void VerifyTheRecordIsAddedAndDeleted(){
        adminPage.NavigateToAdminPage();
        int currentRecord =  adminPage.GetTheNumberOfRecords();

        adminPage.NavigateToAdminPage();
        adminPage.ClickOnAddButton();
        adminPage.SelectRoleFromDropList(getJson(UserData,"AdminRole"));
        adminPage.AddEmployeeName();
        adminPage.SelectStatusFromDropLsit(getJson(UserData,"EnabledStatus"));
        adminPage.AddUserName(Username);
        adminPage.AddPassword(getJson(UserData,"Password"));
        adminPage.AddConfirmPassword(getJson(UserData,"Confirm"));
        adminPage.ClickOnSaveButton();

        int finalRecord =  adminPage.GetTheNumberOfRecords();
//Verify the record added successfully
     Assert.assertEquals(finalRecord,currentRecord+1);
//Delete the record
        adminPage.SearchForUSerName(Username);
        adminPage.DeleteRecord();
        adminPage.NavigateToAdminPage();
        int updatedRecord = adminPage.GetTheNumberOfRecords();
        //Verify the record deleted successfully
        Assert.assertEquals(updatedRecord,finalRecord-1);


    }


}
