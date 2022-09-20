package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class resizeBrowser {

    public static WebDriver driver;
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.navigate().to("https://jqueryui.com/resizable/");
        Dimension d = new Dimension(480,620);
        driver.manage().window().setSize(d);
    }
}
