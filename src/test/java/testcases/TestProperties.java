package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class TestProperties {

    // Assign Logger and get Logger
    public static Logger log = Logger.getLogger(TestProperties.class.getName());
    //Declaring static variables
    public static WebDriver driver;
    public static Properties OR = new Properties();
    public static Properties Config = new Properties();

    //Defining Clicking method
    public static void click(String key) {

        if (key.endsWith("_XPATH")) {
            driver.findElement(By.xpath(OR.getProperty(key))).click();

        } else if (key.endsWith("_ID")) {
            driver.findElement(By.id(OR.getProperty(key))).click();
        } else if (key.endsWith("_CSS")) {
            driver.findElement(By.cssSelector(OR.getProperty(key))).click();
        }
        log.info("Clicking on an Element: " + key);

    }

    // a Deifining typing method or sendkeys
    public static void type(String key, String value) {

        if (key.endsWith("_XPATH")) {
            driver.findElement(By.xpath(OR.getProperty(key))).sendKeys(value);

        } else if (key.endsWith("_ID")) {
            driver.findElement(By.id(OR.getProperty(key))).sendKeys(value);
        } else if (key.endsWith("_CSS")) {
            driver.findElement(By.cssSelector(OR.getProperty(key))).sendKeys(value);
        }
        log.info("keys sent : " + key + " = " + value);

    }


    public static void main(String[] args) throws IOException {

        //Configure log4j.properties file
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/resources/properties/log4j.properties");
        //Read and Load OR.properties file
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/OR.properties");
        OR.load(fis);
        log.info("OR Properties loaded");

        // Read and Load config.propertirs file
        fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/Config.properties");
        Config.load(fis);
        log.info("Config Properties loaded");
        System.out.println(OR.getProperty("username_ID"));
        System.out.println(Config.getProperty("browser"));

        if (Config.getProperty("browser").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            log.info("Chrome Browser Launched");

        } else if (Config.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            log.info("Firefox browser launched!!!");
        }

        driver.get(Config.getProperty("testsiteurl"));
        log.info("Navigated to : " + Config.getProperty("testsiteurl"));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(Config.getProperty("explicit.wait"))));
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")), TimeUnit.SECONDS);
        type("username_ID", "fouad");

        click("nextBtn_XPATH");
        driver.quit();
        log.info("Execution Completed");

    }
}
