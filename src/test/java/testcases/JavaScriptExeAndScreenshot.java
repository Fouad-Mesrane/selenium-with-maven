package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class JavaScriptExeAndScreenshot {
    public static WebDriver driver;
    public static void main(String[] args) throws IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://w3.p2hp.com/w3js/tryit.asp?filename=tryw3js");
        WebElement frame = driver.findElement(By.xpath("//*[@id=\"iframeResult\"]"));
        driver.switchTo().frame(frame);
        //driver.findElement(By.xpath("/html/body/p/button")).click();


        //((JavascriptExecutor)driver).executeScript("w3.toggleShow('#London')");
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.color='red' ",driver.findElement(By.xpath("/html/body/p/button")));
        captureScreenshot();


    }


    public static void captureScreenshot()  {

        Date d = new Date();
        String fileName =  d.toString().replace(":","_").replace(" ","_") + ".jpg";
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot,new File(System.getProperty("user.dir")+ "\\screenshot\\"+ fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
