package com.mypackage.francis;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class SeleniumWebTest {

    //TODO convert and use a page object
    @FindBy(id = "firstName")
    private WebElement firstName;

    public static void main(String[] args) throws InterruptedException {

        String path = System.getProperty("user.dir") + "/resourceFiles/chromedriver";

        System.setProperty("webdriver.chrome.driver", path);

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");

        Thread.sleep(3000);  // Let the user actually see something!

        //TODO Grab all field with page object
        WebElement myFirstName = driver.findElement(By.id("firstName"));
        myFirstName.click();
        myFirstName.sendKeys("Francis");

        Thread.sleep(3000);  // Let the user actually see something!
        driver.quit();


    }
}
