package com.iluv2code.tests;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class AppTest {

    //The 'browser' itself
    private WebDriver driver;

    @BeforeTest
    public void setupSelenium(){
        //Start the browser (firefox for now)
	System.setProperty("webdriver.chrome.driver", "bin/chromedriver");
        driver = new ChromeDriver();

        //This adds implicit timeouts to the driver (instead of clickAndWait())
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testSearch(){
        driver.navigate().to("http://www.iluv2code.com");

        String searchTerm = "Java";

        //Clear the search box and ype searchTerm
        driver.findElement(By.cssSelector("#s")).clear();
        driver.findElement(By.cssSelector("#s")).sendKeys(searchTerm);

        //Click on the magnifying glass
        //driver.findElement(By.cssSelector("#searchsubmit")).click();

        //Get search term for search results, to check if matches the given search
        //String termInTitle =
        //        driver.findElement(By.cssSelector("#archive-title>strong")).getText();

        //assertEquals(termInTitle, searchTerm,
        //        "Search term not found in search results");

    }

    @Test
    public void testAdd(){
	String abc = "abc";
	assertEquals(abc, "abc", "Add failed");
    }

    @AfterTest
    public void closeSelenium(){
        //Shutdown the browser
        driver.quit();
    }
}
