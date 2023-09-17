package selTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class newWindowTest {
    String driverPath = " ";
    String chromeForTestingPath = " ";
    String url ="https://demoqa.com/browser-windows";
    WebDriver driver;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",driverPath);
        ChromeOptions co = new ChromeOptions();
        co.setBinary(chromeForTestingPath);
        driver = new ChromeDriver(co);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void newWindowTest() {
        String parWinHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://www.browserstack.com/");
        System.out.println("Switched to new window : "+driver.getCurrentUrl());
        for (String s: driver.getWindowHandles()) {
            if(s.equals(parWinHandle)){
                driver.switchTo().window(parWinHandle);
                break;
            }
        }
        System.out.println("Parent window after switch: "+driver.getTitle());
    }
    @Test
    public void newTabTest(){
        String parWinHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.browserstack.com/");
        System.out.println("Switched to new Tab : "+driver.getCurrentUrl());
        for (String s: driver.getWindowHandles()) {
            if(s.equals(parWinHandle)){
                driver.switchTo().window(parWinHandle);
                break;
            }
            System.out.println("Parent window after switch: "+driver.getTitle());
        }
    }

    @AfterMethod()
    public void tearDown(){
        driver.quit();
    }
}
