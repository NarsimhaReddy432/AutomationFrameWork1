package factory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory3 {

    static WebDriver driver;
    static String url;
    ExtentTest logger;
    static String browserName;

    public BrowserFactory3(WebDriver driver, ExtentTest logger) {
        this.driver = driver;
        this.logger = logger;

    }

    public WebDriver getBrowser() {
        url = DataProviderFactory.getConfig().getApplicationUrl();
        browserName = DataProviderFactory.getConfig().getBrowserName();
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromePath());
            driver = new ChromeDriver();
           // logger.log(LogStatus.INFO, "Browser is launched");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", DataProviderFactory.getConfig().getFirefoxPath());
            driver = new FirefoxDriver();
            //logger.log(LogStatus.INFO, "Browser is launched");
        } else if (browserName.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", DataProviderFactory.getConfig().getIEPath());
            driver = new InternetExplorerDriver();
           // logger.log(LogStatus.INFO, "Browser is launched");
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", DataProviderFactory.getConfig().getEdgePath());
            driver = new EdgeDriver();
            //logger.log(LogStatus.INFO, "Browser is launched");
        } else if (browserName.equalsIgnoreCase("opera")) {
            System.setProperty("webdriver.opera.driver", DataProviderFactory.getConfig().getOperaPath());
            driver = new OperaDriver();
          //  logger.log(LogStatus.INFO, "Browser is launched");
        } else if (browserName.equalsIgnoreCase("safari")) {
            System.setProperty("webdriver.safari.driver", DataProviderFactory.getConfig().getSafariPath());
            driver = new SafariDriver();
           // logger.log(LogStatus.INFO, "Browser is launched");
        } else if (browserName.equalsIgnoreCase("phanthomjs")) {
            System.setProperty("phantomjs.binary.path", DataProviderFactory.getConfig().getPanthonJSPath());
            WebDriver driver = new PhantomJSDriver();
           // logger.log(LogStatus.INFO, "Headless Browser is launched");
        } else {
            // System.setProperty("htmlunitdriver.binary.path", DataProviderFactory.getConfig().getHtmlUnitDriverPath());

            // Creating a new instance of the HTML unit driver
            driver = new HtmlUnitDriver();
           // logger.log(LogStatus.INFO, "Headless Browser is launched");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get(DataProviderFactory.getConfig().getApplicationUrl());
      //  logger.log(LogStatus.INFO, "Application is launched");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;

    }

    public static void closeBrowser(WebDriver driver) {

        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                // Driver maybe already closed. Ignore.
            }
        }
    }


}