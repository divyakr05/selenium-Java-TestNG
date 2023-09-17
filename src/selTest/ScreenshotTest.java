package selTest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ScreenshotTest {
    static String driverPath = "";
    static String chromeForTestingPath = "";
    static String url = "https://demoqa.com/alerts";
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
    public void test() throws IOException {
        //Typecast driver to TakesScreenshot class
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String destinationPath = System.getProperty("user.dir")+ "\\screenshots\\" + "image.png";
        FileHandler.copy(src,new File(destinationPath));
    }

    @AfterMethod
    public  void teardown(){
        // closes all the browser windows opened by web driver
        driver.quit();
    }

}
