package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseTest;
import utility.TestLogger;

public class SuccessTestClass extends BaseTest {
    @Test
    public void successMethod() {
        // Assertion will be always true.
        TestLogger.log("Log line looks good!");
        Assert.assertTrue(true);
    }
}
