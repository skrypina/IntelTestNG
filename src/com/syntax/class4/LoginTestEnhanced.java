package com.syntax.class4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.CommonMethods;

public class LoginTestEnhanced extends CommonMethods {


    @Test(groups = "smoke")
    public void validAdminLogin() {
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        WebElement welcomeMessage = driver.findElement(By.cssSelector("a#welcome"));

        if (welcomeMessage.isDisplayed()) {
            System.out.println("Test Pass");
        } else {
            System.out.println("Test Fail");
        }
    }


    @Test(groups = "regression")
    public void titleValidation() {
        String expectedTitle = "Human Management System";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Title is valid. Test Pass");
        } else {
            System.out.println("Title is not matched. Test Failed");
        }
    }
}
