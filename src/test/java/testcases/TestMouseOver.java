package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestMouseOver {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.navigate().to("https://www.way2automation.com/");

        WebElement menu = driver.findElement(By.xpath("//div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/nav[1]/div[1]/ul[1]/li[3]/a[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(menu).perform();
        driver.findElement(By.xpath("//li[@id='menu-item-27599']//span[@class='menu-text'][normalize-space()='Selenium with Java']")).click();




    }
}
