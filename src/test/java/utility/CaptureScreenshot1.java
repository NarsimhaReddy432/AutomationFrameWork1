package utility;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class CaptureScreenshot1 {
    WebDriver driver;
    Logger logger;

    public CaptureScreenshot1(WebDriver driver, Logger logger) {
        this.driver = driver;
        this.logger = logger;
    }

    public String captureScreenshot(String screenshotName) throws IOException, InterruptedException {
        String dest = "";
        Thread.sleep(1000);
        try {
            logger.info("Inside try block for capturing screenshot");

            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            logger.info("get screehshot method");

            dest = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + "_" + System.currentTimeMillis() + ".png";
            logger.info("destination" + dest);
            File destination = new File(dest);
            logger.info("object is created for File class");
            FileUtils.copyFile(source, destination);

            logger.info("screenshot is captured");

            return dest;
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.error("Exception while capturing the screenshot");
            return dest;
        }
    }

}
