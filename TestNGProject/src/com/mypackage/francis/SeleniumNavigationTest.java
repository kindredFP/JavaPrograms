package com.mypackage.francis;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SeleniumNavigationTest {


    @Test
    public void test() throws Exception {

        String path = System.getProperty("user.dir") + "/resourceFiles/chromedriver";
        System.setProperty("webdriver.chrome.driver", path);

        WebDriver driver = new ChromeDriver();

        driver.get("http://demo.guru99.com/insurance/v1/index.php");

        Thread.sleep(1000);  // Let the user actually see something!


        WebElement button = driver.findElement(By.name("submit"));
        System.out.println("before button click" + driver.getCurrentUrl());
        System.out.println("driver.getWindowHandle" + driver.getWindowHandle());
        System.out.println("driver.getWindowHandles" + driver.getWindowHandles());

        button.click();
        System.out.println("After button click" + driver.getCurrentUrl());
        System.out.println("driver.getWindowHandle" + driver.getWindowHandle());
        System.out.println("driver.getWindowHandles" + driver.getWindowHandles());

        WebElement link = driver.findElement(By.id("ui-id-2"));
        System.out.println("After link click" + driver.getCurrentUrl());
        System.out.println("driver.getWindowHandle" + driver.getWindowHandle());
        System.out.println("driver.getWindowHandles" + driver.getWindowHandles());

        Thread.sleep(1000);  // Let the user actually see something!
        driver.quit();
    }

    @Test()
    public void navigationWindowTest() throws Exception {

        String path = System.getProperty("user.dir") + "/resourceFiles/chromedriver";
        System.setProperty("webdriver.chrome.driver", path);

        WebDriver driver = new ChromeDriver();

        driver.get("http://demo.guru99.com/payment-gateway/index.php");

        Thread.sleep(1000);  // Let the user actually see something!


        WebElement button = driver.findElement(By.linkText("Generate Card Number"));
        System.out.println("before button click" + driver.getCurrentUrl());
        System.out.println("driver.getWindowHandle" + driver.getWindowHandle());
        System.out.println("driver.getWindowHandles" + driver.getWindowHandles());

        button.click();
        System.out.println("After button click" + driver.getCurrentUrl());
        System.out.println("driver.getWindowHandle" + driver.getWindowHandle());
        System.out.println("driver.getWindowHandles" + driver.getWindowHandles());

        for (String myCurrentHandle : driver.getWindowHandles()) {

            driver.switchTo().window(myCurrentHandle);
            System.out.println("driver.getWindowHandle" + driver.getWindowHandle());

        }
        driver.switchTo().defaultContent();

        Thread.sleep(1000);  // Let the user actually see something!
        driver.quit();
    }

    @Test()
    public void navigationWindowClosingTest() throws Exception {

        String path = System.getProperty("user.dir") + "/resourceFiles/chromedriver";
        System.setProperty("webdriver.chrome.driver", path);

        WebDriver driver = new ChromeDriver();

        driver.get("http://demo.guru99.com/payment-gateway/index.php");

        Thread.sleep(1000);  // Let the user actually see something!

        WebElement button = driver.findElement(By.linkText("Generate Card Number"));

        String mainHandle = driver.getWindowHandle();
        System.out.println("before button click" + driver.getCurrentUrl());
        System.out.println("driver.getWindowHandle" + driver.getWindowHandle());
        System.out.println("driver.getWindowHandles" + driver.getWindowHandles());

        button.click();
        System.out.println("After button click" + driver.getCurrentUrl());
        System.out.println("driver.getWindowHandle" + driver.getWindowHandle());
        System.out.println("driver.getWindowHandles" + driver.getWindowHandles());

        String lastHandle = "";
        for (String myCurrentHandle : driver.getWindowHandles()) {

            driver.switchTo().window(myCurrentHandle);
            System.out.println("driver.getWindowHandle" + driver.getWindowHandle());
            System.out.println("current url" + driver.getCurrentUrl());
            lastHandle = myCurrentHandle;

        }

        try {
            driver.switchTo().window(lastHandle);
        } catch (NoSuchWindowException e) {
            Thread.sleep(5000);
            driver.switchTo().window(mainHandle);
        }
        driver.quit();

    }

    @AfterMethod
    public void cleanup() {
    }
}
