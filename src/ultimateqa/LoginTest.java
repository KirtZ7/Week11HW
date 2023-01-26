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
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();
        // Enter valid username
        driver.findElement(By.id("user[email]")).sendKeys("kirtz_777@hotmail.co.uk");
        // Enter valid password
        driver.findElement(By.id("user[password]")).sendKeys("Test1234");
        // Verify the login
        String expectedText = "My Dashboard";
        String actualText = driver.findElement(By.xpath("(//li[@class='header__nav-item header__nav-item--default']])")).getText();
        Assert.assertEquals(expectedText, actualText);
    }
    @Test
    public void verifyTheErrorMessage(){
        // click on the ‘Sign In’ link
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();
        // Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("invalidusername");
        // Enter invalid password
        driver.findElement(By.id("user[password]")).sendKeys("invalidpassword");
        // Click on Login button
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        // Verify the error message ‘Invalid email or password.’
        String expectedText = "Invalid email or password.";
        String actualText = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void tearDown () {
        closeBrowser();
    }
}