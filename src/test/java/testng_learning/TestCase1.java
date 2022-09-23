package testng_learning;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase1 {

    @BeforeMethod
    public void launchBrowser() {

        System.out.println("launching a browser");
    }

    @Test(priority = 2, groups = "med")
    public void doLogin() {

        System.out.println("Executing login test");
        Assert.fail("failed the doLogin");


    }

    @Test(priority = 1, groups = "high")
    public void doUserRegistration() {
        System.out.println("Executing user registration test");
    }

    @AfterMethod
    public void closingBrowser() {

        System.out.println("closing a browser");
    }

}
