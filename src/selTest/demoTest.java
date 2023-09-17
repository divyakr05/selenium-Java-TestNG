package selTest;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class demoTest {
    WebDriver driver;
    static String driverPath = "D:\\QA\\Java-Selenium\\selenium-demo\\drivers\\geckodriver.exe";
    static String url = "https://the-internet.herokuapp.com/windows";
    //url = "https://the-internet.herokuapp.com/frames";
    //url = "https://the-internet.herokuapp.com/checkboxes";
    //url = "https://the-internet.herokuapp.com/dropdown";
    //url = "https://the-internet.herokuapp.com/drag_and_drop";
    //url = "https://the-internet.herokuapp.com/javascript_alerts";

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.gecko.driver",driverPath);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
    }

    @Test
    public void dropdownTest(){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        dropdown.click();
        Select select = new Select(dropdown);
        select.selectByValue("2");
        String selectedOption= select.getFirstSelectedOption().getText();
        Assert.assertEquals("Option 2",selectedOption,"Validation failed!!");

    }

    @Test
    public void checkBoxTest(){
        WebElement cb = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        cb.click();
        Assert.assertTrue(cb.isSelected(),"Validation failed!!");
    }

    @Test
    public void dragAndDropTest(){
        WebElement src = driver.findElement(By.xpath("//div[@id='column-a']"));
        WebElement tgt = driver.findElement(By.xpath("//div[@id='column-b']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(src,tgt).perform();
        String tgtText = driver.findElement(By.xpath("//div[@id='column-b']/header")).getText();
        Assert.assertEquals("A",tgtText,"Validation failed!!");
    }

    @Test
    public void alertTest(){
        WebElement element = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        element.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        element = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        element.click();
        alert = driver.switchTo().alert();
        alert.dismiss();
        element = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        element.click();
        alert = driver.switchTo().alert();
        alert.sendKeys("alert test");
        alert.accept();
    }

    @Test
    public void iFrameTest(){
        WebElement iframeLink = driver.findElement(By.linkText("iFrame"));
        iframeLink.click();
        driver.switchTo().frame("mce_0_ifr");
        WebElement contentSec = driver.findElement(By.xpath("//body[@id='tinymce']/p"));
        String text = contentSec.getText();
        System.out.println(text);
    }

    @Test
    public void newWindowTest(){
        System.out.println("Parent window : "+driver.getCurrentUrl());
        WebDriver newWindow = driver.switchTo().newWindow(WindowType.WINDOW);
        newWindow.get("https://www.selenium.dev/");
        System.out.println("Switched to new window : "+driver.getCurrentUrl());
    }

    @Test
    public void newTabTest(){
        System.out.println("Parent window : "+driver.getCurrentUrl());
        WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
        newTab.get("https://www.selenium.dev/");
        System.out.println("Switched to new window : "+driver.getCurrentUrl());
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
