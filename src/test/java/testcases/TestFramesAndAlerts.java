package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestFramesAndAlerts {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.w3docs.com/tools/editor/20441");
        WebElement frame1 = driver.findElement(By.xpath("//iframe[@title='result frame']"));
        driver.switchTo().frame(frame1);

        driver.findElement(By.xpath("//body/form[1]/input[2]")).click();
        //driver.switchTo().defaultContent();
        Alert alert = driver.switchTo().alert();
        System.out.println( alert.getText());
        alert.accept();
        /*List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        System.out.println(frames.size());

        for (WebElement frame:frames) {
            System.out.println( frame.getAttribute("name"));
        }*/

    }
}
