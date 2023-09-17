package selTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsTest {

    static String path = "D:\\QA\\Java-Selenium\\drivers\\chromedriver.exe";
    static String url = "";
    public static void main(String args[]){
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver",path);
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.id(""));

        Actions action = new Actions(driver);
                action.click(element).perform();
                action.contextClick(element).perform();
                action.clickAndHold(element).perform();
        //using build() for chaining the actions - attaching multiple commands together
        action.moveToElement(element).click().build().perform();
        action.contextClick(element).perform();
        action.clickAndHold(element).perform();


    }
}
