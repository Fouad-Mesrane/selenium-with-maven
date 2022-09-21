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

public class TestClosePopup {
   public static WebDriver driver;
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.way2automation.com/way2auto_jquery/frames-and-windows.php#load_box");


        Set <String> win_ids = driver.getWindowHandles();
        Iterator<String> iterator = win_ids.iterator();

        String first_window = iterator.next();

        driver.findElement(By.xpath("//a[normalize-space()='Open Multiple Windows']")).click();

        WebElement frame = driver.findElement(By.xpath("//*[@id=\"example-1-tab-4\"]/div/iframe"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//a[contains(text(),'Open multiple pages')]")).click();


        win_ids =driver.getWindowHandles();
        iterator = win_ids.iterator();
        iterator.next();
        String first_popup_win = iterator.next();
        driver.switchTo().window(first_window).close();

        //closing the first popup_window
        driver.switchTo().window(first_popup_win).close();


        win_ids =driver.getWindowHandles();
        iterator = win_ids.iterator();

        String second_popup_win = iterator.next();
        //closing the second popup_window
        driver.switchTo().window(second_popup_win).close();

        win_ids =driver.getWindowHandles();
        iterator = win_ids.iterator();

        String third_popup_win = iterator.next();
        //Closing th third_popup_window
        driver.switchTo().window(third_popup_win).close();




    }
}
