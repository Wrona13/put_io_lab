package put.selenium.linear;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import put.selenium.utils.ScreenshotAndQuitOnFailureRule;

import static org.junit.Assert.*;


public class AccountsLinearScriptAT {

    private WebDriver driver;

    @Rule
    public ScreenshotAndQuitOnFailureRule screenshotOnFailureAndWebDriverQuitRule =
            new ScreenshotAndQuitOnFailureRule();


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        this.driver = new ChromeDriver();
        screenshotOnFailureAndWebDriverQuitRule.setWebDriver(driver);
        driver.get("http://localhost:8080/accounts/controller?action=db_reset");
    }

    @Test
    public void successfulUserRegistration() throws Exception {
        driver.get("http://localhost:8080/accounts/controller?action=db_reset");
        driver.get("http://localhost:8080/accounts/controller?action=controller");
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_local | ]]
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("nowy@mail.com");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("1234");
        driver.findElement(By.name("repeat_password")).clear();
        driver.findElement(By.name("repeat_password")).sendKeys("1234");
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("1234");
        driver.findElement(By.name("addressData")).clear();
        driver.findElement(By.name("addressData")).sendKeys("1234");
        driver.findElement(By.name("submit")).click();
        // ERROR: Caught exception [unknown command []]
    }


}
