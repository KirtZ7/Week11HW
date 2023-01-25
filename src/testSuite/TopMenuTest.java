package testSuite;

import browserFactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.junit.Assert;

public class TopMenuTest extends BaseTest {
    String baseurl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {

        openBrowser(baseurl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {

        // click on the ‘Computers’ Tab
        driver.findElement(By.linkText("Computers")).click();
        // Verify the text ‘Computers’
        String expectedText = "Computers";
        String actualText = driver.findElement(By.xpath("//h1[text()='Computers']")).getText();
        Assert.assertEquals(expectedText, actualText);
        driver.quit();
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        // click on the ‘Electronics’ Tab
        driver.findElement(By.linkText("Electronics")).click();
        // Verify the text ‘Electronics’
        String expectedText = "Electronics";
        String actualText = driver.findElement(By.xpath("//h1[text()='Electronics']")).getText();
        Assert.assertEquals(expectedText, actualText);
        driver.quit();
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        // click on the ‘Apparel’ Tab
        driver.findElement(By.linkText("Apparel")).click();
        // Verify the text ‘Apparel’
        String expectedText = "Apparel";
        String actualText = driver.findElement(By.xpath("//h1[text()='Apparel']")).getText();
        Assert.assertEquals(expectedText, actualText);
        driver.quit();
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        // click on the ‘Digital downloads’ Tab
        driver.findElement(By.linkText("Digital downloads")).click();
        // Verify the text ‘Digital downloads’
        String expectedText = "Digital downloads";
        String actualText = driver.findElement(By.xpath("//h1[text()='Digital downloads']")).getText();
        Assert.assertEquals(expectedText, actualText);
        driver.quit();
    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        // click on the ‘Books’ Tab
        driver.findElement(By.linkText("Books")).click();
        // Verify the text ‘Books’
        String expectedText = "Books";
        String actualText = driver.findElement(By.xpath("//h1[text()='Books']")).getText();
        Assert.assertEquals(expectedText, actualText);
        driver.quit();
    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        // click on the ‘Jewelry’ Tab
        driver.findElement(By.linkText("Jewelry")).click();
        // Verify the text ‘Jewelry’
        String expectedText = "Jewelry";
        String actualText = driver.findElement(By.xpath("//h1[text()='Jewelry']")).getText();
        Assert.assertEquals(expectedText, actualText);
        driver.quit();
    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        // click on the ‘Gift Cards’ Tab
        driver.findElement(By.linkText("Gift Cards")).click();
        // Verify the text ‘Gift Cards’
        String expectedText = "Gift Cards";
        String actualText = driver.findElement(By.xpath("//h1[text()='Gift Cards']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }
    @After
    public void tearDown () {
        closeBrowser();
    }


}
