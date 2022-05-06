import static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class mainTest {

    int counter = 0;

    @BeforeMethod
    public void setup() {
        counter += 1;
        System.out.println("Commence test no. " + counter + ".");

    }


    @Test (priority = 0, retryAnalyzer = myRetryAnalyzer.class)
    public void first () {
        System.out.println("First");
        Assert.assertEquals(false, true);
    }

    @Test (priority = 1, dependsOnMethods = {"first"})
    public void second () {
        System.out.println("Second");

    }


    @Test (priority = 2, dataProvider = "getData")
    public void third (String input, String expected) {
        System.out.println("Third: " + input);
        String actual = "Success";
        Assert.assertEquals(actual, expected, "Output did not match.");
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data = new Object [2][2];
        data[0][0] = "Input 1";
        data[0][1] = "Error";
        data[1][0] = "Input 2";
        data[1][1] = "Success";
        return data;
    }

}