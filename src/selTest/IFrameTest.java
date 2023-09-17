package selTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class IFrameTest {
    private String driverPath = " ";
    private String chromeForTestingPath = " ";
    private String url = "https://the-internet.herokuapp.com/iframe";

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
        driver.switchTo().frame("mce_0_ifr");
        WebElement contentSec = driver.findElement(By.xpath("//body[@id='tinymce']/p"));
        contentSec.clear();
        contentSec.sendKeys("Divya Karippali");
    }

    @AfterMethod
    public  void teardown(){
        // closes all the browser windows opened by web driver
        driver.quit();
    }
}
