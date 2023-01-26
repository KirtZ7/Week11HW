package ultimateqa;

import browserFactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

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
        // Verify the login page
        String actualText = driver.findElement(By.xpath("h2[@class='page__heading']")).getText();
        String expectedText = "Welcome Back!";
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
        driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']")).click();
        // Verify the error message ‘Invalid email or password.’
        String actualText = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        String expectedText = "Invalid email or password.";
        Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void tearDown () {
        closeBrowser();
    }
}