package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestWebElemens {

    public static boolean isElementPresent(By by){

       try {
            driver.findElement(by);
           return true;
       }catch (Throwable t){
           return false;
       }

    }


     public static WebDriver  driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.navigate().to("http://gmail.com");
        WebElement username = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
        username.sendKeys("fouadmesrane@gmail.com");

        WebElement nextButton = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));
        nextButton.click();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/div[2]/div/c-wiz/div/div[2]/div/div[1]/div/form/span/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input"))).sendKeys("hahaha");

        //driver.findElement(By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")).sendKeys("Mdergh");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/div[2]/div/c-wiz/div/div[2]/div/div[2]/div/div[1]/div/div/button/span"))).click();

        System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div[1]/div/form/span/div[1]/div[2]/div[2]/span"))).getText());
        //System.out.println(driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div[1]/div/form/span/div[1]/div[2]/div[2]/span")).getText());
        //driver.quit();


    }
}
