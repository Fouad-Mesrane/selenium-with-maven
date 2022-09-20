package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCheckBoxes {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("http://www.tizag.com/htmlT/htmlcheckboxes.php");

        /*for (int i = 1;i<=4; i++ ){
            driver.findElement(By.xpath("//div[4]//input["+i+"]")).click();
        }*/
        WebElement section = driver.findElement(By.xpath("//div[4]"));
        List<WebElement> checkboxes = section.findElements(By.name("sports"));
        System.out.println(checkboxes.size() + " is the total checkboxes available");
        for (WebElement checkbox:checkboxes) {
            checkbox.click();
        }




    }
}
