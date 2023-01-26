package sauce;

import browserFactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginTest extends BaseTest {

    String baseurl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {

        openBrowser(baseurl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        // Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        // Verify the text “PRODUCTS”
        String expectedText = "PRODUCTS";
        String actualText = driver.findElement(By.xpath("(//span[@class='title'])")).getText();
        Assert.assertEquals(expectedText, actualText);
    }


    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){

        // Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        // Verify that six products are displayed on page
        int expectedCount = 6;
        int actualCount = driver.findElements(By.xpath("//div[@class='inventory_item']")).size();
        Assert.assertEquals(expectedCount, actualCount);
    }


    @After
    public void tearDown () {
        closeBrowser();
    }
}
