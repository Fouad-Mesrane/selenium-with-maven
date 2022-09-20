package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DummyRegistrationForm {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://way2automation.com/way2auto_jquery/index.php");
        driver.findElement(By.xpath("//input[@type=\"text\"][@name=\"name\"]")).sendKeys("Fouad M");
        driver.findElement(By.xpath("//input[@type=\"tel\"]")).sendKeys("7207575814");
        driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[3]/input")).sendKeys("fm@gmail.com");

        WebElement dropDown = driver.findElement(By.xpath("//select[@name='country']"));
        Select select = new Select(dropDown);
        select.selectByValue("Algeria");

        List <WebElement> values = driver.findElements(By.tagName("option"));
        System.out.println("Number of option values is: " + values.size());
        System.out.println();
        /*WebElement value = values.get(8);
        System.out.println(value.getText());
        System.out.println(value.getAttribute("value"));*/

        for (int i =0; i<values.size();i++){
            System.out.println(values.get(i).getAttribute("value"));
        }

        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Denver");
        driver.findElement(By.xpath("//div[@id='load_box']//input[@name='username']")).sendKeys("hunterfxh");

        driver.findElement(By.xpath("//div[@id='load_box']//input[@name='password']")).sendKeys("allo");
       // driver.findElement(By.xpath("(//*[@id=\"load_form\"]/div[1]/div[2]/input)[2]")).click();
        System.out.println("Submit Button clicked");
       // driver.close();


    }
}
