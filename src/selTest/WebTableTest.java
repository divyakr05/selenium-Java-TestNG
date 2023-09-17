package selTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTableTest {
    private String driverPath = "";
    private String chromeForTestingPath = "";
    private String url = "https://omayo.blogspot.com/";

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
        List<WebElement> rows  = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("Size of rows: "+rows.size());
        List<WebElement> cols  = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("Size of columns: "+cols.size());
    }

    @AfterMethod
    public  void teardown(){
        // closes all the browser windows opened by web driver
        driver.quit();
    }
}
