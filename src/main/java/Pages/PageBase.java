package Pages;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class PageBase {
    public WebDriver driver ;
    protected SoftAssert softAssert = new SoftAssert();

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement find(By locator){
        highlightElement(locator);
     return driver.findElement(locator);
    }
    public void SetText(By locator , String data){
        waitElement(locator);
        Click(locator);
        find(locator).isEnabled();
        find(locator).clear();
        find(locator).sendKeys(data);
    }
    public void waitElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void Click (By locator){
        find(locator).click();
}
    public String GetText(By locator){
        return find(locator).getText();
    }
    public boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    public void highlightElement(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].style.border='2px solid fuchsia'", element);
    }
    public String getContent(By locator) {
        waitElement(locator);
        return find(locator).getText();
    }
    public void highlightAssertedElements(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].style.border='2px solid blue'", element);
        jsExecutor.executeScript("arguments[0].style.backgroundColor = 'green';", element);
    }
    public void highlightUnAssertedElements(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].style.border='2px solid blue'", element);
        jsExecutor.executeScript("arguments[0].style.backgroundColor = 'red';", element);
    }
    public static String getCurrentDate() {
        return new SimpleDateFormat("dd-MM-yyyy hh.mm.ss a").format(new Date());
    }


    public void softAssertionEqual(By locator, String expected) {
        waitElement(locator);
        softAssert.assertEquals(getContent(locator), expected);
        if (getContent(locator).equals(expected)) {
            highlightAssertedElements(locator);
        } else {
            highlightUnAssertedElements(locator);
            String currentMethod = new Object() {
            }.getClass().getSimpleName();
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File src = screenshot.getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(src, new File(
                        ".\\TestData\\ScreenShots\\SoftAssertions\\" + getClass().getName() + "\\" + currentMethod + "_" + PageBase.getCurrentDate() + ".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
