package com.mypackage.francis;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;

public class SeleniumWebTest {

    //xpath to grab the sibling beside the column
    private final static String COUNTRY = "//tbody/tr/th[contains(text(),'%s')]/following-sibling::td[%d]";

    //static columns
    private final static int COUNTRY_COLUMN = 1;
    private final static int CITY = 2;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/fpalattao/Documents/Dropbox/gitRepository/gitHubRepos/JavaPrograms/resourceFiles/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("http://toolsqa.com/automation-practice-table/");

        Thread.sleep(5000);  // Let the user actually see something!

        //first argument is the first row value which can be dynamic (Burj, Clock, etc)
        //2nd argument is what column which we can define a constant
        String firstRowFirstColumnXPATH = String.format(COUNTRY, "Burj", COUNTRY_COLUMN);
        String firstRowSecondColumnXPATH = String.format(COUNTRY, "Burj", CITY);


        //Print first value
        WebElement columnElement = driver.findElement(By.xpath(firstRowFirstColumnXPATH));
        String columnValue = columnElement.getText();
        System.out.println("First column Value of first row = " + columnValue);

        //Print next value
        columnElement = driver.findElement(By.xpath(firstRowSecondColumnXPATH));
        columnValue = columnElement.getText();
        System.out.println("Second column Value of first row = " + columnValue);

        Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();
    }
}
