package com.mypackage.francis;


import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeleniumShadowRootWebTest {

    public static void main(String[] args) throws InterruptedException {

        String path = System.getProperty("user.dir") + "/resourceFiles/chromedriver";

        System.setProperty("webdriver.chrome.driver", path);

        WebDriver driver = new ChromeDriver();
        driver.get("http://watir.com/examples/shadow_dom.html");

        Thread.sleep(3000);  // Let the user actually see something!

        //shadow
        WebElement shadowHost = driver.findElement(By.cssSelector("#shadow_host"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement shadowContent = shadowRoot.findElement(By.cssSelector("#shadow_content"));
        Assert.assertEquals("some text", shadowContent.getText());

        //Nested shadow
        WebElement nestedShadowHost = shadowRoot.findElement((By.cssSelector("#nested_shadow_host")));
        SearchContext nestedShadowRoot = nestedShadowHost.getShadowRoot();
        WebElement newField = nestedShadowRoot.findElement(By.cssSelector("#nested_shadow_content"));
        Assert.assertEquals("nested text", newField.getText());

        //Textbox
        WebElement textfield = shadowRoot.findElement(By.cssSelector("input[type='text']"));
        textfield.sendKeys("This is test");
        Assert.assertEquals("This is test", textfield.getAttribute("value"));

        Thread.sleep(1000);  // Let the user actually see something!
        driver.quit();

    }
}
