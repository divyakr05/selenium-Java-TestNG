package selTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Set;

public class MultipleWindowsTest {
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
    public void test(){
        driver.findElement(By.id("windowButton")).click();
        // It will return the parent window name as a String
        String parentWindow = driver.getWindowHandle();
        Set<String> allWindow = driver.getWindowHandles();

        for (String handle:allWindow) {
            if(!handle.equals(parentWindow)){
                driver.switchTo().window(handle);
                System.out.println("New window title: "+driver.getTitle());
                System.out.println("New window url: "+driver.getCurrentUrl());
                driver.close();
            }

        }
        driver.switchTo().window(parentWindow);
        System.out.println("Switched to parent window: "+driver.getCurrentUrl());
    }

    @AfterTest()
    public void tearDown(){
        driver.quit();
    }
}
