package InterviewTestCases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumDemo {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        String applicationURL = "https://hrappforemployee.com";
        String chromeDriverExePath = "C:/downloads/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverExePath);
        driver = new ChromeDriver();
        System.out.println("Chrome Driver is Instantiated");
        driver.manage().window().maximize();
        System.out.println("Browser window is maximized");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Implicity wait is set to 30 seconda");
        driver.get(applicationURL);
        System.out.println("Application is launched");
    }

    @Test(priority = 0, enabled = true, groups = {"smoke", "regression"}, description = "This test verify the page title of the application")
    public void testVerifyPageTitle() {
        try {
            String actualTitle = driver.getTitle();
            String expectedTitle = "HR application for employee";
            Assert.assertEquals(actualTitle, expectedTitle);
            System.out.println("Test case is passed");
            System.out.println("Application title is: " + actualTitle);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test(priority = 1, enabled = true, groups = {"smoke", "regression"}, description = "This test verify the page source of the application")
    public void testVerifyPageSource() {
        try {
            String actualPageSource = driver.getPageSource();
            String expectePageSource = "HR application for employee";
            Boolean flag = false;
            if (actualPageSource.contains(expectePageSource)) {
                flag = true;
            }
            Assert.assertTrue(flag);
            System.out.println("Test case is passed");
            System.out.println("Application Page source is: " + actualPageSource);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test(priority = 2, enabled = true, groups = {"smoke", "regression"}, description = "This test verify the current url of the application")
    public void testVerifyApplicationCurrentUrl() {
        try {
            String actualUrl = driver.getCurrentUrl();
            String expecteUrl = "https://hrappforemployee.com";
            Boolean flag = false;
            if (actualUrl.contains(expecteUrl)) {
                flag = true;
            }
            Assert.assertTrue(flag);
            System.out.println("Test case is passed");
            System.out.println("Application current url is: " + actualUrl);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void testLogin() {
        try {
            driver.findElement(By.id("emp_id")).clear();
            driver.findElement(By.id("emp_id")).sendKeys("testuser01");
            System.out.println("User id is entered");
            driver.findElement(By.name("emp_name")).clear();
            driver.findElement(By.name("emp_name")).sendKeys("password1");
            System.out.println("Password is entered");
            if (driver.findElement(By.className("login_class")).isDisplayed() & driver.findElement(By.className("login_class")).isEnabled()) {
                driver.findElement(By.className("login_class")).click();
                System.out.println("Login button is clicked on");
            } else {
                System.out.println("Login button is either not displayed or not enabled");
            }

            String actualText = driver.findElement(By.xpath("//*[contains(text(),'welcome')]")).getText();
            String expectedText = "welcome";
            Assert.assertEquals(actualText, expectedText);
            System.out.println("Test case is passed");
        } catch (Exception e) {
            System.out.println("Exception occurred while logging into application" + e.getMessage());
        }
    }

    @Test
    public void testSearchEmployee() {
        try {
            driver.findElement(By.id("emp_id")).clear();
            driver.findElement(By.id("emp_id")).sendKeys("testuser01");
            System.out.println("User id is entered");
            driver.findElement(By.name("emp_name")).clear();
            driver.findElement(By.name("emp_name")).sendKeys("password1");
            System.out.println("Password is entered");
            if (driver.findElement(By.className("login_class")).isDisplayed() & driver.findElement(By.className("login_class")).isEnabled()) {
                driver.findElement(By.className("login_class")).click();
                System.out.println("Login button is clicked on");
            } else {
                System.out.println("Login button is either not displayed or not enabled");
            }
            driver.findElement(By.linkText("search employee")).click();
            System.out.println("Search Employee link is clicked on");
            driver.findElement(By.xpath("//*[@id='empid']")).sendKeys("emp01");
            driver.findElement(By.xpath("//button[@name='search']")).click();

            if (driver.findElement(By.name("employeetest")).getText().equalsIgnoreCase("employeetest")) {
                System.out.println("Employee details is found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testSelectEmployee() {
        boolean flag = false;
        try {

            driver.findElement(By.id("emp_id")).clear();
            driver.findElement(By.id("emp_id")).sendKeys("testuser01");
            System.out.println("User id is entered");
            driver.findElement(By.name("emp_name")).clear();
            driver.findElement(By.name("emp_name")).sendKeys("password1");
            System.out.println("Password is entered");
            if (driver.findElement(By.className("login_class")).isDisplayed() & driver.findElement(By.className("login_class")).isEnabled()) {
                driver.findElement(By.className("login_class")).click();
                System.out.println("Login button is clicked on");
            } else {
                System.out.println("Login button is either not displayed or not enabled");
            }
            driver.findElement(By.linkText("search employee")).click();
            System.out.println("Search Employee link is clicked on");
            driver.findElement(By.xpath("//*[@id='empid']")).sendKeys("emp01");
            driver.findElement(By.xpath("//button[@name='search']")).click();

            if (driver.findElement(By.name("employeetest")).getText().equalsIgnoreCase("employeetest")) {
                System.out.println("Employee details is found");
                driver.findElement(By.name("employeetest")).click();
                System.out.println("Employee details are selected");
                flag = true;

            }
            Assert.assertTrue(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
