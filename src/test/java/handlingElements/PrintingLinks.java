package handlingElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PrintingLinks {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.wikipedia.org/");
        WebElement block = driver.findElement(By.xpath("//body/div[7]/div[3]"));
        List<WebElement> links = block.findElements(By.tagName("a"));
        System.out.println(links.size());
        for (WebElement link: links
             ) {
            System.out.println("links within the block are : " + link.getAttribute("href") + " With Respective titles :" + link.getText() );
        }


        /*List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        for (WebElement link: links){
            System.out.println(link.getText()+ "----URL IS ----" + link.getAttribute("href"));
        }*/
    }
}
