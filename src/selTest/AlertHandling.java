package selTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class AlertHandling {
    static String driverPath = "D:\\QA\\Java-Selenium\\drivers\\chromedriver.exe";
    static String chromeForTestingPath = "D:\\QA\\Java-Selenium\\drivers\\chrome.exe";
    static String url = "https://demoqa.com/alerts";
    public static  void main(String args[]){

        System.setProperty("webdriver.chrome.driver",driverPath);
        ChromeOptions co = new ChromeOptions();
        co.setBinary(chromeForTestingPath);
        WebDriver driver = new ChromeDriver(co);
        driver.get(url);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement button = driver.findElement(By.xpath("//button[@id='promtButton' and text()='Click me']"));
        button.click();
        Alert promptAlert = driver.switchTo().alert();
        String alertText = promptAlert.getText();
        System.out.println("Alert text is: "+alertText);
        promptAlert.sendKeys("hello");
        promptAlert.accept();

    }
}
