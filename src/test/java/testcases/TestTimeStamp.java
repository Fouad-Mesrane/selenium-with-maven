package testcases;

import org.openqa.selenium.WebDriver;

import java.util.Date;

public class TestTimeStamp {
        public static WebDriver driver;
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d.toString().replace(":","_").replace(" ","_") + ".jpg");
    }
}
