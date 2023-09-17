package selTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitTest {
    private String driverPath = "";
    private String chromeForTestingPath = "";
    private String url = "https://www.saucedemo.com";

    // created reference variable for WebDriver
    WebDriver driver;
    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",driverPath);
        ChromeOptions co = new ChromeOptions();
        co.setBinary(chromeForTestingPath);
        driver = new ChromeDriver(co);
        driver.get(url);
        driver.manage().window().maximize();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void test(){
        WebElement username = driver.findElement(By.xpath("//input[@class='input_error form_input' and @name='user-name']"));
        username.sendKeys("standard_user");
        //using id locator
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        //using name locator
        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();

        // explicit wait - to wait for the add to cart button to be click-able
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Open Menu']")));
        // click on the menu button as soon as the "Menu" button is visible
        driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
    }

    @AfterMethod
    public  void teardown(){
        // closes all the browser windows opened by web driver
        driver.quit();
    }


}
