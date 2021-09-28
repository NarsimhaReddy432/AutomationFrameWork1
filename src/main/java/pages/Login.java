package pages;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

public class Login {

    WebDriver driver;
    ExtentTest logger;

    public Login(WebDriver driver, ExtentTest logger) {
        System.out.println("inside login page constructor");
        this.driver = driver;
        this.logger = logger;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "pass-status")
    WebElement passwordStatus;

    @FindBy(id = "remember")
    WebElement rememberMe;

    @FindBy(xpath = "//button[@type='submit' and @class='btn btn-primary btn-lg']")
    WebElement loginBtn;

    @FindBy(xpath = "//div[@id='navbarCollapse']/ul/li/a[@class='nav-link']")
    WebElement myTimeMenu;

    @FindBy(xpath = "//*[@id='modal-19']/div/div/div[2]/div/div/div/div[1]/div[1]")
    WebElement projectName;

    /*
    Enter the value in user name field in login page
     */
    public void enterUsername(String user_name) {
        try {
            if (username.isDisplayed()) {
                if (username.isEnabled()) {
                    username.clear();
                    username.sendKeys(user_name);
                    logger.log(LogStatus.INFO, "User Name field is entered with value: " + user_name);
                } else {
                    logger.log(LogStatus.INFO, "User Name field is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "User Name field is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception while entering the user name in login page");
        }
    }

    /*
    Enter the value in password field in login page
     */
    public void enterPassword(String pwd) {
        try {
            if (password.isDisplayed()) {
                if (password.isEnabled()) {
                    password.clear();
                    password.sendKeys(pwd);
                    logger.log(LogStatus.INFO, "password field is entered with the value");
                } else {
                    logger.log(LogStatus.INFO, "password field is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "password field is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception while entering password in login page");
        }
    }

    /*
    Click on the password status field - eye icon on login page
     */
    public void changePasswordStatus() {
        try {
            if (passwordStatus.isDisplayed()) {
                if (passwordStatus.isEnabled()) {
                    passwordStatus.click();
                } else {
                    logger.log(LogStatus.INFO, "password status field is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "password status field is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception while changing the password status(eye icon) in login page");
        }
    }

    /*
    Enable Remember Me check box
     */
    public void enableRememberMe() {
        try {
            if (rememberMe.isDisplayed()) {
                if (rememberMe.isEnabled()) {
                    if (!rememberMe.isSelected()) {
                        rememberMe.click();
                    } else {
                        logger.log(LogStatus.INFO, "Remember Me checkbox is enabled already");
                    }
                } else {
                    logger.log(LogStatus.INFO, "Remember Me checkbox field is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Remember Me checkbox field is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception while enabling the 'Remember Me' check box in login page");
        }
    }

    /*
     Click on Login button
     */

    public boolean clickLoginBtn() {
        Boolean flag = false;
        try {
            if (loginBtn.isDisplayed()) {
                if (loginBtn.isEnabled()) {
                    flag = true;
                    loginBtn.click();
                    logger.log(LogStatus.INFO, "Login button is clicked on");
                } else {
                    logger.log(LogStatus.INFO, "Login button is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Login button is not displayed");
            }
            Thread.sleep(1000);
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception while clicking on Login button");
        }

        return flag;
    }

    /*
        Get the text of "My Time" menu at the left side of Home page
         */
    public String getTextMyTimeMenu() {
        String txt="";
        try {
            Thread.sleep(3000);
            System.out.println("inside my time");
            if (myTimeMenu.isDisplayed()) {
                System.out.println("my time menu is displayed");
                if (myTimeMenu.isEnabled()) {
                    System.out.println("my time menu is enabled");
                    txt= myTimeMenu.getText();
                    System.out.println("inside my time" + txt);
                } else {
                    logger.log(LogStatus.INFO, "My Time menu is not enabled");

                }
            } else {
                logger.log(LogStatus.INFO, "My Time menu is not displayed");

            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while selecting week from the dropdown");

        }
        return txt;
    }

    /*
        Click on My Time menu at the left side
         */
    public void clickMytimeMenu() {

        try {
            System.out.println("inside clickMytimeMenu");
            Thread.sleep(3000);
            if (myTimeMenu.isDisplayed()) {
                if (myTimeMenu.isEnabled()) {
                    myTimeMenu.click();
                    logger.log(LogStatus.INFO, "My Time menu is clicked on");
                    System.out.println("My Time menu is clicked on");
                } else {
                    logger.log(LogStatus.INFO, "My Time menu is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "My Time menu is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on My Time Menu");
        }
    }

    /*
      Click on project name for the submitted timesheet
       */
    public String getProjectNameforSavedTimeSheet() {

        String projectInfoText = "", timesheetStatus = "", projectNameText = "";
        int size = 0;
        try {
            Thread.sleep(3000);
            Select select=new Select(driver.findElement(By.name("table_time_length")));
            select.selectByVisibleText("100");
            List<WebElement> timeEntries = driver.findElements(By.xpath("//table[@id='table_time']/tbody/tr"));
            size = timeEntries.size();
            if (size > 0) {
                for (WebElement timeEntry : timeEntries) {
                    if (timeEntry.isDisplayed()) {
                        System.out.println("Time entry is displayed");
                        for (int i = 1; i <= size; i++) {
                            timesheetStatus = driver.findElement(By.xpath("//table[@id='table_time']/tbody/tr[" + i + "]/td[4]")).getText();
                            if (timesheetStatus.contains("Saved")) {
                                System.out.println("Time sheet status: " + timesheetStatus);
                                driver.findElement(By.xpath("//table[@id='table_time']/tbody/tr[" + i + "]/td[6]")).click();
                                Thread.sleep(1000);
                                Set<String> allWindows=driver.getWindowHandles();

                                if(allWindows.size()>0){
                                    System.out.println("list of windows" + allWindows.size());
                                    for(String curWindow : allWindows){
                                        driver.switchTo().window(curWindow);
                                    }
                                    System.out.println("more than one windows available" + driver.getWindowHandles().size());

                                }

                                System.out.println("Inside project name loop");
                                JavascriptExecutor js = (JavascriptExecutor) driver;
//                                 projectNameText = js.executeScript("return document.getElementByXpath('//*[@id='modal-19']/div/div/div[2]/div/div/div/div[1]/div[1]').value").toString();
                                projectNameText = js.executeScript("return document.getElementById('modal-19').value").toString();
//                                projectNameText=driver.findElement(By.xpath("//*[@id='modal-19']/div/div/div[2]/div/div/div/div[1]/div[1]")).getText();

                                System.out.println("Project name is:" + projectNameText);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            e.getStackTrace();
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on Project Info eye icon");
        }
        return projectNameText;
    }

    /*
    Click on project name for the submitted timesheet
     */
    public String getProjectNameforSubmittedTimeSheet() {

        String projectInfoText = "", timesheetStatus = "", projectNameText = "";
        int size = 0;
        try {
            Thread.sleep(3000);
            Select select=new Select(driver.findElement(By.name("table_time_length")));
            select.selectByVisibleText("100");
            List<WebElement> timeEntries = driver.findElements(By.xpath("//table[@id='table_time']/tbody/tr"));
            size = timeEntries.size();
            if (size > 0) {
                for (WebElement timeEntry : timeEntries) {
                    if (timeEntry.isDisplayed()) {
                        System.out.println("Time entry is displayed");
                            for (int i = 1; i <= size; i++) {
                            timesheetStatus = driver.findElement(By.xpath("//table[@id='table_time']/tbody/tr[" + i + "]/td[4]")).getText();
                            if (timesheetStatus.contains("Submitted")) {
                                System.out.println("Time sheet status: " + timesheetStatus);
                                driver.findElement(By.xpath("//table[@id='table_time']/tbody/tr[" + i + "]/td[6]")).click();
                                Thread.sleep(1000);
                               Set<String> allWindows=driver.getWindowHandles();

                                if(allWindows.size()>0){
                                    System.out.println("list of windows" + allWindows.size());
                                    for(String curWindow : allWindows){
                                        driver.switchTo().window(curWindow);
                                    }
                                    System.out.println("more than one windows available" + driver.getWindowHandles().size());

                                }

                                    System.out.println("Inside project name loop");
                                JavascriptExecutor js = (JavascriptExecutor) driver;
//                                 projectNameText = js.executeScript("return document.getElementByXpath('//*[@id='modal-19']/div/div/div[2]/div/div/div/div[1]/div[1]').value").toString();
                                projectNameText = js.executeScript("return document.getElementById('modal-19').value").toString();
//                                projectNameText=driver.findElement(By.xpath("//*[@id='modal-19']/div/div/div[2]/div/div/div/div[1]/div[1]")).getText();

                                    System.out.println("Project name is:" + projectNameText);
                                    break;
                                }
                            }
                        }
                    }
                }
            } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            e.getStackTrace();
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on Project Info eye icon");
        }
        return projectNameText;
    }

    /*
         Click on project Id for the Saved timesheet
          */
    public String getProjectIdforSavedTimeSheet() {

        String projectInfoText = "", timesheetStatus = "", projectIdText = "";
        int size = 0;
        try {
            Thread.sleep(3000);
            Select select=new Select(driver.findElement(By.name("table_time_length")));
            select.selectByVisibleText("100");
            List<WebElement> timeEntries = driver.findElements(By.xpath("//table[@id='table_time']/tbody/tr"));
            size = timeEntries.size();
            if (size > 0) {
                for (WebElement timeEntry : timeEntries) {
                    if (timeEntry.isDisplayed()) {
                        System.out.println("Time entry is displayed");
                        for (int i = 1; i <= size; i++) {
                            timesheetStatus = driver.findElement(By.xpath("//table[@id='table_time']/tbody/tr[" + i + "]/td[4]")).getText();
                            if (timesheetStatus.contains("Saved")) {
                                System.out.println("Time sheet status: " + timesheetStatus);
                                driver.findElement(By.xpath("//table[@id='table_time']/tbody/tr[" + i + "]/td[6]")).click();
                                Thread.sleep(1000);
                                Set<String> allWindows=driver.getWindowHandles();

                                if(allWindows.size()>0){
                                    System.out.println("list of windows" + allWindows.size());
                                    for(String curWindow : allWindows){
                                        driver.switchTo().window(curWindow);
                                    }
                                    System.out.println("more than one windows available" + driver.getWindowHandles().size());

                                }

                                System.out.println("Inside project name loop");
                                JavascriptExecutor js = (JavascriptExecutor) driver;
//                                 projectIdText = js.executeScript("return document.getElementByXpath('//*[@id='modal-19']/div/div/div[2]/div/div/div/div[1]/div[1]').value").toString();
                                projectIdText = js.executeScript("return document.getElementById('modal-19').value").toString();
//                                projectIdText=driver.findElement(By.xpath("//*[@id='modal-19']/div/div/div[2]/div/div/div/div[1]/div[1]")).getText();

                                System.out.println("Project Id is:" + projectIdText);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            e.getStackTrace();
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on Project Info eye icon");
        }
        return projectIdText;
    }


    /*
       Click on project Id for the Submitted timesheet
        */
    public String getProjectIdforSubmittedTimeSheet() {

        String projectInfoText = "", timesheetStatus = "", projectIdText = "";
        int size = 0;
        try {
            Thread.sleep(3000);
            Select select=new Select(driver.findElement(By.name("table_time_length")));
            select.selectByVisibleText("100");
            List<WebElement> timeEntries = driver.findElements(By.xpath("//table[@id='table_time']/tbody/tr"));
            size = timeEntries.size();
            if (size > 0) {
                for (WebElement timeEntry : timeEntries) {
                    if (timeEntry.isDisplayed()) {
                        System.out.println("Time entry is displayed");
                        for (int i = 1; i <= size; i++) {
                            timesheetStatus = driver.findElement(By.xpath("//table[@id='table_time']/tbody/tr[" + i + "]/td[4]")).getText();
                            if (timesheetStatus.contains("Submitted")) {
                                System.out.println("Time sheet status: " + timesheetStatus);
                                driver.findElement(By.xpath("//table[@id='table_time']/tbody/tr[" + i + "]/td[6]")).click();
                                Thread.sleep(1000);
                                Set<String> allWindows=driver.getWindowHandles();

                                if(allWindows.size()>0){
                                    System.out.println("list of windows" + allWindows.size());
                                    for(String curWindow : allWindows){
                                        driver.switchTo().window(curWindow);
                                    }
                                    System.out.println("more than one windows available" + driver.getWindowHandles().size());

                                }

                                System.out.println("Inside project name loop");
                                JavascriptExecutor js = (JavascriptExecutor) driver;
//                                 projectIdText = js.executeScript("return document.getElementByXpath('//*[@id='modal-19']/div/div/div[2]/div/div/div/div[1]/div[1]').value").toString();
                                projectIdText = js.executeScript("return document.getElementById('modal-19').value").toString();
//                                projectIdText=driver.findElement(By.xpath("//*[@id='modal-19']/div/div/div[2]/div/div/div/div[1]/div[1]")).getText();

                                System.out.println("Project Id is:" + projectIdText);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            e.getStackTrace();
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on Project Info eye icon");
        }
        return projectIdText;
    }

    /*
      Click on project status approved by RM
       */
    public String getTimeSheetStatusApprovedByRM() {

        String projectInfoText = "", timesheetStatus = "", projectIdText = "";
        int size = 0;
        try {
            Thread.sleep(3000);
            Select select=new Select(driver.findElement(By.name("table_time_length")));
            select.selectByVisibleText("100");
            List<WebElement> timeEntries = driver.findElements(By.xpath("//table[@id='table_time']/tbody/tr"));
            size = timeEntries.size();
            if (size > 0) {
                for (WebElement timeEntry : timeEntries) {
                    if (timeEntry.isDisplayed()) {
                        System.out.println("Time entry is displayed");
                        for (int i = 1; i <= size; i++) {
                            timesheetStatus = driver.findElement(By.xpath("//table[@id='table_time']/tbody/tr[" + i + "]/td[4]")).getText();
                            if (timesheetStatus.contains("Approved")) {
                                System.out.println("Time sheet status: " + timesheetStatus);
                                driver.findElement(By.xpath("//table[@id='table_time']/tbody/tr[" + i + "]/td[6]")).click();
                                Thread.sleep(1000);
                                Set<String> allWindows=driver.getWindowHandles();

                                if(allWindows.size()>0){
                                    System.out.println("list of windows" + allWindows.size());
                                    for(String curWindow : allWindows){
                                        driver.switchTo().window(curWindow);
                                    }
                                    System.out.println("more than one windows available" + driver.getWindowHandles().size());

                                }

                                System.out.println("Inside project name loop");

                               projectIdText=driver.findElement(By.xpath("//*[@id='modal-3717']/div/div/div[1]/div[1]/div/div[2]/h4/small")).getText();

                                System.out.println("Project Id is:" + projectIdText);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            e.getStackTrace();
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on Project Info eye icon");
        }
        return projectIdText;
    }

    /*
     Click on project status approved by RM
      */
    public String getTimeSheetStatusDeniedByRM() {

        String projectInfoText = "", timesheetStatus = "", projectIdText = "";
        int size = 0;
        try {
            Thread.sleep(3000);
            Select select=new Select(driver.findElement(By.name("table_time_length")));
            select.selectByVisibleText("100");
            List<WebElement> timeEntries = driver.findElements(By.xpath("//table[@id='table_time']/tbody/tr"));
            size = timeEntries.size();
            if (size > 0) {
                for (WebElement timeEntry : timeEntries) {
                    if (timeEntry.isDisplayed()) {
                        System.out.println("Time entry is displayed");
                        for (int i = 1; i <= size; i++) {
                            timesheetStatus = driver.findElement(By.xpath("//table[@id='table_time']/tbody/tr[" + i + "]/td[4]")).getText();
                            if (timesheetStatus.contains("Denied")) {
                                System.out.println("Time sheet status: " + timesheetStatus);
                                driver.findElement(By.xpath("//table[@id='table_time']/tbody/tr[" + i + "]/td[6]")).click();
                                Thread.sleep(1000);
                                Set<String> allWindows=driver.getWindowHandles();

                                if(allWindows.size()>0){
                                    System.out.println("list of windows" + allWindows.size());
                                    for(String curWindow : allWindows){
                                        driver.switchTo().window(curWindow);
                                    }
                                    System.out.println("more than one windows available" + driver.getWindowHandles().size());

                                }

                                System.out.println("Inside project name loop");

                                projectIdText=driver.findElement(By.xpath("//*[@id='modal-3717']/div/div/div[1]/div[1]/div/div[2]/h4/small")).getText();

                                System.out.println("Project Status is:" + projectIdText);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            e.getStackTrace();
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on Project Info eye icon");
        }
        return projectIdText;
    }

    /*
     Click on project status approved by RM
      */
    public Boolean employeeEditTimeSheetStatusDeniedByRM() {

        String projectInfoText = "", timesheetStatus = "", projectIdText = "";
        int size = 0;
        Boolean flag=false;
        try {
            Thread.sleep(3000);
            Select select=new Select(driver.findElement(By.name("table_time_length")));
            select.selectByVisibleText("100");
            List<WebElement> timeEntries = driver.findElements(By.xpath("//table[@id='table_time']/tbody/tr"));
            size = timeEntries.size();
            if (size > 0) {
                for (WebElement timeEntry : timeEntries) {
                    if (timeEntry.isDisplayed()) {
                        System.out.println("Time entry is displayed");
                        for (int i = 1; i <= size; i++) {
                            timesheetStatus = driver.findElement(By.xpath("//table[@id='table_time']/tbody/tr[" + i + "]/td[4]")).getText();
                            if (timesheetStatus.contains("Denied")) {
                                System.out.println("Time sheet status: " + timesheetStatus);
                                driver.findElement(By.xpath("//*[@id='table_time']/tbody/tr[25]/td[6]/a[2]/i")).click();
                                Thread.sleep(1000);
                                flag=true;
                                break;
                            }
                        }
                    }
                }
            }
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            e.getStackTrace();
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on Project Info eye icon");
        }
       return flag;
    }

}