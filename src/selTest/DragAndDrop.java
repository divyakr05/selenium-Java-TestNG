package selTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DragAndDrop {
    static String driverPath = " ";
    static String chromeForTestingPath = " ";
    static String url = "https://demoqa.com/droppable/";
    public static void main(String args[]){
        //set the path to chromedriver exe
        System.setProperty("webdriver.chrome.driver",driverPath);
        ChromeOptions co = new ChromeOptions();
        co.setBinary(chromeForTestingPath);
        WebDriver driver = new ChromeDriver(co);
        driver.get(url);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Actions builder = new Actions(driver);
        WebElement from = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement to = driver.findElement(By.xpath("//div[@id='droppable']//*[text()='Drop here']"));
        builder.dragAndDrop(from,to).perform();
        String text = to.getText();
        if(text.equals("Dropped!"))
            System.out.println("PASS: Source is dropped to target as expected");
        else
            System.out.println("FAIL: Source not dropped to target as expected");
        driver.quit();
    }
}
