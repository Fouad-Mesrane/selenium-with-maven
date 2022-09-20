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

public class DragAndDrop {


    public static WebDriver driver;
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://jqueryui.com/droppable/");

        WebElement frame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
        driver.switchTo().frame(frame);

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        Actions action = new Actions(driver);
        action.dragAndDropBy(draggable,471,296).perform();

    }
}
