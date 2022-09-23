package testng_learning;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase2 {
    @Test
    public void validateTitle() {

        String actual_title = "Gmail.com";
        String expected_title = "Gmails.com";
        // SoftAssert asrt = new SoftAssert();

        Assert.assertEquals(actual_title, expected_title);

        Assert.assertTrue(true);


        System.out.println("ending");

        //asrt.assertAll();


    }
}
