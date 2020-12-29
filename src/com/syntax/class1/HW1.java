package com.syntax.class1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HW1 {
    /*
   US 17666 Syntax Logo should be present on the login page
   US 17667 Error message "Invalid credentials" should be displayed when user enters invalid credentials
    */
    WebDriver driver;
    @BeforeMethod
    //before the test method, we want to open browser and navigate to site
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test
    //During test, we want to run methods that test certain things
    //this test is to check if logo is displayed
    public void checkLogo() {
        WebElement logo = driver.findElement(By.xpath("//img[contains(@src, 'syntax.png')]"));
        System.out.println("Is logo present on login page?" + logo.isDisplayed());
    }
    @Test
    //during test we want to setup another method for a different
    //part of test case
    public void errorMessageShown() {
        WebElement userNameField = driver.findElement(By.id("txtUsername"));
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        userNameField.sendKeys("Wrong user");
        passwordField.sendKeys("Wrong pass");
        WebElement errorMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String expectedTxt = "Invalid credentials";
        String actualTxt = errorMsg.getText();
        if (expectedTxt.equals(actualTxt)) {
            System.out.println("error message is correct");
        } else {
            System.out.println("error message is not correct");
        }
    }
    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}

