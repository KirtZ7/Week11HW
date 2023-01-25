package ultimateqa;

import browserFactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.junit.Assert;

public class LoginTest extends BaseTest {

    String baseurl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {

        openBrowser(baseurl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        // click on the ‘Sign In’ link
        driver.findElement(By.cssSelector("a[href='/users/sign_in']"));
        // Verify the text ‘Welcome Back!’
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//h2[text()='Welcome Back!']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }
    @Test
    public void verifyTheErrorMessage(){
        // click on the ‘Sign In’ link
        driver.findElement(By.cssSelector("a[href='/users/sign_in']"));
        // Enter invalid username
        driver.findElement(By.id("user_email")).sendKeys("invalidusername");
        // Enter invalid password
        driver.findElement(By.id("user_password")).sendKeys("invalidpassword");
        // Click on Login button
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        // Verify the error message ‘Invalid email or password.’
        String expectedText = "Invalid email or password.";
        String actualText = driver.findElement(By.xpath("//div[text()='Invalid email or password.']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void tearDown () {
        closeBrowser();
    }
}