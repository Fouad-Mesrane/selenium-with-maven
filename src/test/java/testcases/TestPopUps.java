package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestPopUps {
        public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://superdevresources.com/open-links-popup/");
        Set <String> winids = driver.getWindowHandles();
        Iterator<String> iterator = winids.iterator();
        String first_window = iterator.next();
        System.out.println(first_window);


        WebElement link = driver.findElement(By.xpath("//p//a[normalize-space()='Open Link in Popup']"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", link);

        winids = driver.getWindowHandles();
        iterator = winids.iterator();
        iterator.next();
        String second_window = iterator.next();
        System.out.println("this is the second window address : "+second_window);




    }
}
