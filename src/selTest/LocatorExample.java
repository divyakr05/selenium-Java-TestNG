package selTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class LocatorExample {
    static String path = "D:\\QA\\Java-Selenium\\drivers\\chromedriver.exe";
    static String url = "https://www.saucedemo.com/";
    public static void main(String args[]){
        //set the path to chromedriver executable
        System.setProperty("webdriver.chrome.driver",path);
        //use chrome options and set binary for that - create object of ChromeOptions
        ChromeOptions co = new ChromeOptions();
        co.setBinary("D:\\QA\\Java-Selenium\\drivers\\chrome.exe");
        //set new instance of chromedriver
        WebDriver driver = new ChromeDriver(co);
        //open a webpage
        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        //using xpath locator
        WebElement username = driver.findElement(By.xpath("//input[@class='input_error form_input' and @name='user-name']"));
        username.sendKeys("standard_user");
        //using id locator
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        //using name locator
        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();
        //using partial link text locator
        WebElement backpackProd = driver.findElement(By.partialLinkText("Backpack"));
        backpackProd.click();
        //using css selector - id
        WebElement addToCart = driver.findElement(By.cssSelector("button#add-to-cart-sauce-labs-backpack"));
        addToCart.click();

        //dropdown or Multiple select
        WebElement filterDropdown = driver.findElement(By.xpath("//*[@class='product_sort_container']"));
        Select filter = new Select(filterDropdown);
        filter.selectByIndex(1);
        filter.selectByValue("hilo");
        filter.selectByVisibleText("Price (high to low)");
        driver.quit();

    }


}
