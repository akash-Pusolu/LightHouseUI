import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

/**
 * Created by mac on 19/06/18.
 */
public class TestAttributelistingScreen {


    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        baseUrl = "https://www.katalon.com/";
        PropertiesUtilities.setPath();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testAttributelistingScreen() throws Exception {
        driver.get("paste_url_here");
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("anu.engage3@gmail.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Siddhant1");
        driver.findElement(By.id("submitBtn")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/ul/li/a/i")));

        WebElement element = driver.findElement(By.linkText("Logout"));

        Actions action = new Actions(driver);

        action.moveToElement(element).moveToElement(driver.findElement(By.linkText("//div[@id='missions']/nav/div"))).click().build().perform();
        driver.findElement(By.xpath("//div[2]/ul/li/a/i")).click();
        driver.findElement(By.linkText("Product Lighthouse")).click();
        driver.findElement(By.xpath("//select")).click();
        new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText("Walmart, Inc.");
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        driver.findElement(By.xpath("//div[4]/select")).click();
        new Select(driver.findElement(By.xpath("//div[4]/select"))).selectByVisibleText("23 - MEN'S JEANS");
        driver.findElement(By.xpath("//div[5]/select")).click();
        new Select(driver.findElement(By.xpath("//div[5]/select"))).selectByVisibleText("CARPENTER JEANS");
        driver.findElement(By.xpath("//div[6]/select")).click();
        new Select(driver.findElement(By.xpath("//div[6]/select"))).selectByVisibleText("Cargo Fit");
    }
    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

}
