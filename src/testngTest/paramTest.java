package testngTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class paramTest {
    WebDriver driver;
    static String ff_driverPath = "D:\\QA\\Java-Selenium\\selenium-demo\\drivers\\geckodriver.exe";
    static String chrome_driverPath = "D:\\QA\\Java-Selenium\\selenium-demo\\drivers\\chromedriver.exe";
    static String chromeForTestingPath = "D:\\QA\\Java-Selenium\\drivers\\chrome.exe";
    static String url = "https://the-internet.herokuapp.com/windows";

    @BeforeTest
    @Parameters({"browser"})
    public void setup(@Optional("chrome")String browser){
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",chrome_driverPath);
            ChromeOptions co = new ChromeOptions();
            co.setBinary(chromeForTestingPath);
            driver = new ChromeDriver(co);
        }
        else if (browser.equalsIgnoreCase("FF")){
            System.setProperty("webdriver.gecko.driver",ff_driverPath);
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(url);

    }

    @Test
    public void test(){
        System.out.println("Test Case in " + getClass().getSimpleName()
                + " with Thread Id:- " + Thread.currentThread().getId());

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
