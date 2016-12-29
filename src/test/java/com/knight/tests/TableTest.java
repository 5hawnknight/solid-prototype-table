package com.knight.tests;

import com.knight.pageobjects.ChallengingDOMPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by shawn knight
 * shawn.knight.work@gmail.com
 */
public class TableTest
{
    private WebDriver driver;

    @BeforeTest
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.2.27");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/challenging_dom");
    }
    @Test
    public void test() throws InterruptedException
    {
        ChallengingDOMPageObject page = PageFactory.initElements(driver,ChallengingDOMPageObject.class).isLoaded();
        System.out.println(page.searchAndReadAmetColumn("Iuvaret8"));
        page.searchAndDeleteRow("Iuvaret8");

        // Create assertions to test if the correct row is returned.
        Thread.sleep(5000); //this is only here to review the web page before it closes
    }
    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
}
