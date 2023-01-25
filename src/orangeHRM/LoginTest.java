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
        driver.findElement(By.name("username")).sendKeys("admin");
        // Enter valid password
        driver.findElement(By.name("password")).sendKeys("admin123");
        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // Verify the text 'Welcome Admin'
        String expectedText = "Welcome Admin";
        String actualText = driver.findElement(By.id("welcome")).getText();
        Assert.assertEquals(expectedText, actualText);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        // Enter “Admin” username
        driver.findElement(By.name("username")).sendKeys("Admin");
        // Enter “admin123” password
        driver.findElement(By.name("password")).sendKeys("admin123");
        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // Verify the ‘Welcome’ text is display - Failed Test
        String expectedText = "Welcome";
        String actualText = driver.findElement(By.id("welcome")).getText();
        Assert.assertTrue(actualText.contains(expectedText));

    }


    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){
        // click on the ‘Forgot your password’ link
        driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']]")).click();
        // Verify the text ‘Forgot Your Password?’
        String expectedText = "Forgot Your Password?";
        String actualText = driver.findElement(By.xpath("//div[@class='form-header']")).getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @After
    public void tearDown () {
        closeBrowser();
    }
}
