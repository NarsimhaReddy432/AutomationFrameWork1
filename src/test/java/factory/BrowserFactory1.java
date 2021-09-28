package factory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
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

public class BrowserFactory1 {

    static WebDriver driver;
    static String url;
    Logger logger;
    static String browserName;

    public BrowserFactory1(WebDriver driver, Logger logger) {
        this.driver = driver;
        this.logger = logger;

    }

    public WebDriver getBrowser() {
        try {
            url = DataProviderFactory.getConfig().getApplicationUrl();
            browserName = DataProviderFactory.getConfig().getBrowserName();
            if (browserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromePath());
                driver = new ChromeDriver();
                logger.info("Browser is launched");
            } else if (browserName.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", DataProviderFactory.getConfig().getFirefoxPath());
                driver = new FirefoxDriver();
                logger.info("Browser is launched");
            } else if (browserName.equalsIgnoreCase("IE")) {
                System.setProperty("webdriver.ie.driver", DataProviderFactory.getConfig().getIEPath());
                driver = new InternetExplorerDriver();
                logger.info("Browser is launched");
            } else if (browserName.equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.edge.driver", DataProviderFactory.getConfig().getEdgePath());
                driver = new EdgeDriver();
                logger.info("Browser is launched");
            } else if (browserName.equalsIgnoreCase("opera")) {
                System.setProperty("webdriver.opera.driver", DataProviderFactory.getConfig().getOperaPath());
                driver = new OperaDriver();
                logger.info("Browser is launched");
            } else if (browserName.equalsIgnoreCase("safari")) {
                System.setProperty("webdriver.safari.driver", DataProviderFactory.getConfig().getSafariPath());
                driver = new SafariDriver();
                logger.info("Browser is launched");
            } else if (browserName.equalsIgnoreCase("phanthomjs")) {
                System.setProperty("phantomjs.binary.path", DataProviderFactory.getConfig().getPanthonJSPath());
                WebDriver driver = new PhantomJSDriver();
                logger.info("Headless Browser is launched");
            } else {
                // System.setProperty("htmlunitdriver.binary.path", DataProviderFactory.getConfig().getHtmlUnitDriverPath());

                // Creating a new instance of the HTML unit driver
                driver = new HtmlUnitDriver();
                logger.info("Headless Browser is launched");
            }
            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get(DataProviderFactory.getConfig().getApplicationUrl());
            logger.info("Application is launched");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.error("Exception while instantiating the browser or launching the application");
        }
        return driver;
    }

    public static void closeBrowser(WebDriver driver) {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.out.println("Exception while closing the browser" + e.getMessage());
                System.out.println(e.getStackTrace());
            }
        }
    }


}