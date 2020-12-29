package com.syntax.class1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HW {
    public class Homework01 {
        WebDriver driver;
        String browser = "chrome";
        String url = "http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        static final String INVALID_USERNAME = "Nokia";
        static final String INVALID_PASSWORD = "Not_connecting_people";
        String expectedInvLogMessage = "Invalid credentials";
        @BeforeMethod
         void openAndNavigate(){
            switch (browser){
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
            }
            driver.get(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
        @Test
        void syntaxLogoIsDisplayed(){
            WebElement element = driver.findElement(By.xpath("//div[@id = 'divLogo']//img"));
            if (!element.isDisplayed()){
                throw new RuntimeException("Syntax logo isn't displayed");
            }
        }
        @Test
        void InvalidLogMessageCheck(){
            loginProcess(INVALID_USERNAME,INVALID_PASSWORD);
            WebElement message = driver.findElement(By.id("spanMessage"));
            if (!message.getText().equals(expectedInvLogMessage)){
                throw new RuntimeException("Invalid login Actual message in not matching with expected");
            }
        }
        @AfterMethod
        void finish(){
            driver.close();
        }
         void loginProcess (String username, String password){
            WebElement usernameBox = driver.findElement(By.id("txtUsername"));
            WebElement passwordBox = driver.findElement(By.id("txtPassword"));
            WebElement loginButton = driver.findElement(By.id("btnLogin"));
            usernameBox.sendKeys(username);
            passwordBox.sendKeys(password);
            loginButton.click();
        }
    }
}
