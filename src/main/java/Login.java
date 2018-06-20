import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by mac on 19/06/18.
 */
public class Login {


    public String loginFail(WebDriver driver,String userNane, String password)
    {

        driver.get(PropertiesUtilities.getData("LoginUrl"));
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(userNane);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submitBtn")).click();
        driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
//    WebDriverWait wait = new WebDriverWait(driver,30);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-error-box")));
        WebElement errorMessage= driver.findElement(By.xpath("//*[@id='login-error-box']"));

        return errorMessage.getText();


    }

    public WebElement loginPass(WebDriver driver, String userNane, String password)
    {

        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.get(PropertiesUtilities.getData("LoginUrl"));
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(PropertiesUtilities.getData("loginTest.userName"));
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(PropertiesUtilities.getData("loginTest.correctPassword"));
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("submitBtn")).click();

       return driver.findElement(By.linkText("Logout"));
    }


}
