package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class TestBrowser {

    public static String browser = "chrome";
    public static WebDriver driver;
    public static void main(String[] args) {

        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
             driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
             driver = new FirefoxDriver();
        }

        driver.get("https://gmail.com");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println(title);
        System.out.println(title.length()+ " is the title length");
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
       // driver.close();


    }
}
