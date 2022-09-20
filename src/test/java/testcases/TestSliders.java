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

public class TestSliders {
   public static WebDriver driver;

    public static boolean isElementPresent(By by){

        try {
            driver.findElement(by);
            return true;
        }catch (Throwable t){
            return false;
        }

    }


    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://jqueryui.com/slider/");

        //System.out.println(isElementPresent(By.cssSelector("#slider > span")));

        WebElement frame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
        driver.switchTo().frame(frame);
        WebElement mainSlider = driver.findElement(By.xpath("//*[@id=\"slider\"]"));
        int width = mainSlider.getSize().width/2;
        WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));

        new Actions(driver).dragAndDropBy(slider,width ,0).perform();

        System.out.println("executed");
    }

}
