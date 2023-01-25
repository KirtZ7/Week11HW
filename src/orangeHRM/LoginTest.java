package orangeHRM;

import browserFactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import org.junit.Assert;

public class LoginTest extends BaseTest {
    String baseurl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {

        openBrowser(baseurl);
    }

    @Test
    public void userShouldLoginSuccessfully() {
        // Enter valid username
        driver.findElement(By.id("txtUsername")).sendKeys("admin");
        // Enter valid password
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        // Click on ‘LOGIN’ button
        driver.findElement(By.id("btnLogin")).click();
        // Verify the text 'Welcome Admin'
        String expectedText = "Welcome Admin";
        String actualText = driver.findElement(By.id("welcome")).getText();
        Assert.assertEquals(expectedText, actualText);
        driver.quit();
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        // Enter “Admin” username
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        // Enter “admin123” password
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        // Click on ‘LOGIN’ button
        driver.findElement(By.id("btnLogin")).click();
        // Verify the ‘Welcome’ text is display
        String expectedText = "Welcome";
        String actualText = driver.findElement(By.id("welcome")).getText();
        Assert.assertTrue(actualText.contains(expectedText));
        driver.quit();
    }


    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){
        // click on the ‘Forgot your password’ link
        driver.findElement(By.linkText("Forgot your password?")).click();
        // Verify the text ‘Forgot Your Password?’
        String expectedText = "Forgot Your Password?";
        String actualText = driver.findElement(By.xpath("//div[@class='form-header']")).getText();
        Assert.assertEquals(expectedText, actualText);
        driver.quit();
    }

    @After
    public void tearDown () {
        closeBrowser();
    }
}
