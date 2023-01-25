package testSuite;

import browserFactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.junit.Assert;

public class RegisterTest extends BaseTest {
    String baseurl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {

        openBrowser(baseurl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        // click on the ‘Register’ link
        driver.findElement(By.linkText("Register")).click();
        // Verify the text ‘Register’
        String expectedText = "Register";
        String actualText = driver.findElement(By.xpath("//h1[text()='Register']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        // click on the ‘Register’ link
        driver.findElement(By.linkText("Register")).click();
        // Select gender radio button
        driver.findElement(By.xpath("//input[@id='gender-male']")).click();
        // Enter First name
        driver.findElement(By.id("FirstName")).sendKeys("FirstName");
        // Enter Last name
        driver.findElement(By.id("LastName")).sendKeys("LastName");
        // Select Day Month and Year
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("1");
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("January");
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("2000");
        // Enter Email address
        driver.findElement(By.id("Email")).sendKeys("test@test.com");
        // Enter Password
        driver.findElement(By.id("Password")).sendKeys("password");
        // Enter Confirm password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("password");
        // Click on REGISTER button
        driver.findElement(By.xpath("//input[@value='Register']")).click();
        // Verify the text 'Your registration completed’
        String expectedText = "Your registration completed";
        String actualText = driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void tearDown () {
        closeBrowser();
    }
}
