package utility;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class CaptureScreenshot {
    WebDriver driver;
    ExtentTest logger;

    public CaptureScreenshot(WebDriver driver, ExtentTest logger) {
        this.driver = driver;
        this.logger = logger;
    }

    public String captureScreenshot(String screenshotName) throws IOException, InterruptedException {
        String dest = "";
        Thread.sleep(1000);
        try {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            dest = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + "_" + System.currentTimeMillis() + ".png";
            File destination = new File(dest);
            FileUtils.copyFile(source, destination);
            logger.log(LogStatus.INFO, "screenshot is captured");
            return dest;
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception while capturing the screenshot");
            return dest;
        }
    }

}
