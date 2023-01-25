package heroku;

import browserFactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.junit.Assert;

public class LoginTest extends BaseTest {

    String baseurl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {

        openBrowser(baseurl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        // Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        // Enter “SuperSecretPassword!” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // Verify the text “Secure Area”
        String expectedText = "Secure Area";
        String actualText = driver.findElement(By.xpath("//h2[text()='Secure Area']")).getText();
        Assert.assertEquals(expectedText, actualText);

    }
    @Test
    public void verifyTheUsernameErrorMessage(){

        // Enter “tomsmith1” username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        // Enter “SuperSecretPassword!” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // Verify the error message “Your username is invalid!”
        String expectedText = "Your username is invalid!";
        String actualText = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(actualText.contains(expectedText));

    }

    @Test
    public void verifyThePasswordErrorMessage(){
        // Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        // Enter “SuperSecretPassword” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // Verify the error message “Your password is invalid!”
        String expectedText = "Your password is invalid!";
        String actualText = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(actualText.contains(expectedText));

    }

    @After
    public void tearDown () {
        closeBrowser();
    }
}
