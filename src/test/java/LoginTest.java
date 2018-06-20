import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginTest {
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
  public void testLoginFail() throws Exception {
//    driver.get(PropertiesUtilities.getData("LoginUrl"));
//    driver.findElement(By.id("username")).click();
//    driver.findElement(By.id("username")).clear();
//    driver.findElement(By.id("username")).sendKeys(PropertiesUtilities.getData("loginTest.userName"));
//    driver.findElement(By.id("password")).clear();
//    driver.findElement(By.id("password")).sendKeys(PropertiesUtilities.getData("loginTest.wrongPassword"));
//    driver.findElement(By.id("submitBtn")).click();
//    driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
////    WebDriverWait wait = new WebDriverWait(driver,30);
//    WebDriverWait wait = new WebDriverWait(driver, 10);
//
//    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-error-box")));
//    WebElement errorMessage= driver.findElement(By.xpath("//*[@id='login-error-box']"));

    Login l= new Login();
    String  errorMessage= l.loginFail(driver,PropertiesUtilities.getData("loginTest.userName"),PropertiesUtilities.getData("loginTest.wrongPassword"));

    Assert.assertEquals(errorMessage,"Username or password invalid, try again.");
  }

  @Test
  public void testLoginSuccess() throws Exception {
//    driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
//    driver.get(PropertiesUtilities.getData("LoginUrl"));
//    driver.findElement(By.id("username")).click();
//    driver.findElement(By.id("username")).clear();
//    driver.findElement(By.id("username")).sendKeys(PropertiesUtilities.getData("loginTest.userName"));
//    driver.findElement(By.id("password")).clear();
//    driver.findElement(By.id("password")).sendKeys(PropertiesUtilities.getData("loginTest.correctPassword"));
//    driver.findElement(By.id("username")).click();
//    driver.findElement(By.id("username")).click();
//    driver.findElement(By.id("username")).click();
//    driver.findElement(By.id("submitBtn")).click();


    Login l1= new Login();

    WebElement login= l1.loginPass(driver,PropertiesUtilities.getData("loginTest.userName"),PropertiesUtilities.getData("loginTest.correctPassword"));
    assertNotNull(login);
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
