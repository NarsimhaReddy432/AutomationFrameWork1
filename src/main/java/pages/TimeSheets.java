package pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

public class TimeSheets {

    WebDriver driver;
    ExtentTest logger;

    @FindBy(xpath = "//a[@class='eyeball-anchor']")
    WebElement actionsEyeIcon;

    @FindBy(xpath = "//a[@id='manager-approve-timesheet']")
    WebElement approveBtn;

    @FindBy(xpath = "//a[@class='eyeball-anchor-emp']")
    WebElement actionByReportingManager;

    @FindBy(xpath = "//a[@id='employee-manager-approve-timesheet']")
    WebElement approveByReportingManager;

    @FindAll(@FindBy(xpath = "//a[@id='employee-manager-approve-timesheet']"))
    List<WebElement> approveBtn_ReportingManager;

    @FindBy(xpath = "//a[@class='btn btn-outline-danger manager-decline-timesheet txt' and @title='Deny']")
    WebElement deny;

    @FindAll(@FindBy(xpath = "//a[@class='btn btn-outline-danger manager-decline-timesheet txt' and @title='Deny']"))
    List<WebElement> denyBtn;

    @FindBy(xpath = "//div[@id='swal2-content']")
    WebElement denyHeader;

    @FindBy(xpath = "//input[@class='swal2-input']")
    WebElement decliningTimesheetReason;

    @FindBy(xpath = "//button[contains(text(),'Deny')]")
    WebElement confirmDeny;

    /*
    Constructor
     */
    public TimeSheets(WebDriver driver, ExtentTest logger) {
        this.driver = driver;
        this.logger = logger;
        PageFactory.initElements(driver, this);
    }


    /*
    Click on Actions eye icon By project Manager
     */
    public void clickActionByProjectManager() throws InterruptedException {
        Thread.sleep(3000);
        try {
            if (actionsEyeIcon.isDisplayed()) {
                if (actionsEyeIcon.isEnabled()) {
                    actionsEyeIcon.click();
                    Thread.sleep(500);
                    logger.log(LogStatus.INFO, "Action is clicked on by Project Manager");
                } else {
                    logger.log(LogStatus.INFO, "Action eye icon is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Action eye icon is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on Action by Project Manager");
        }
    }

    /*
    Click on Approve Button
     */
    public void approveByProjectManager() throws InterruptedException {
        Thread.sleep(3000);
        try {
            if (approveBtn.isDisplayed()) {
                if (approveBtn.isEnabled()) {
                    approveBtn.click();
                    Thread.sleep(500);
                    logger.log(LogStatus.INFO, "Approve button is clicked on");
                } else {
                    logger.log(LogStatus.INFO, "Approve button is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Approve button is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on Approve button");
        }
    }


    /*
    Click on Actions eye icon by Reporting Manager
     */
    public void clickActionByReportingManager() throws InterruptedException {
        Thread.sleep(3000);
        try {
            if (actionByReportingManager.isDisplayed()) {
                if (actionByReportingManager.isEnabled()) {
                    actionByReportingManager.click();
                    Thread.sleep(500);
                    logger.log(LogStatus.INFO, "Action is clicked on by Reporting Manager");
                } else {
                    logger.log(LogStatus.INFO, "Action eye icon is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Action eye icon is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on Action by Reporting Manager");
        }
    }

    /*
    Click on Approve button by Reporting Manager
     */
    public void approveByReportingManager() throws InterruptedException {
        Thread.sleep(3000);
        try {
            if (approveByReportingManager.isDisplayed()) {
                if (approveByReportingManager.isEnabled()) {
                    approveByReportingManager.click();
                    Thread.sleep(500);
                    logger.log(LogStatus.INFO, "Approve is clicked on by Reporting Manager");
                } else {
                    logger.log(LogStatus.INFO, "Approve button is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Approve button is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on Approve by Reporting Manager");
        }
    }

    /*
    Click on Approve button by Reporting Manager
     */
    public boolean checkIfApproveOrDenyButtonEnabledForReportingManagerForDeniedTimesheet() throws InterruptedException {
        Thread.sleep(3000);
        boolean flag=false;
        try {
            if(!(approveBtn_ReportingManager.size()>0 & denyBtn.size()>0))
            if (!approveByReportingManager.isDisplayed() & !deny.isDisplayed()) {
                flag=true;
                 logger.log(LogStatus.INFO, "Approve and Deny buttons are not displayed for Reporting Manager for the timesheet denied by project manager already");
                }
            }
         catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while checking Approve and Deny button for Reporting Manager for the timesheet denied by project manager already");
        }
        return flag;
    }
    /*
    Click on Deny button by Reporting/Project Manager
     */
    public void denyTimesheet() throws InterruptedException {
        Thread.sleep(3000);
        try {
            if (deny.isDisplayed()) {
                if (deny.isEnabled()) {
                    deny.click();
                    Thread.sleep(500);
                    logger.log(LogStatus.INFO, "Deny is clicked on by Reporting Manager");
                } else {
                    logger.log(LogStatus.INFO, "Deny button is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Deny button is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on Deny by Reporting Manager/Project Manager");
        }
    }


    /*
    Get the text of denied header
     */
    public void getTextDeniedHeader() throws InterruptedException {
        Thread.sleep(200);
        try {
            if (denyHeader.isDisplayed()) {
                logger.log(LogStatus.INFO, "Header for Time sheet denied : " + denyHeader.getText());

            } else {
                logger.log(LogStatus.INFO, "Header for Time sheet denied is not displayed");

            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while retrieving header for Time sheet denied");

        }
    }


    /*
    Enter reason for declining the timesheet
     */
    public void reasonToDeclineTimesheet() {
        try {
            getTextDeniedHeader();
            if (decliningTimesheetReason.isDisplayed()) {
                if (decliningTimesheetReason.isEnabled()) {
                    decliningTimesheetReason.clear();
                    decliningTimesheetReason.sendKeys("automation test declining reason");
                    logger.log(LogStatus.INFO, "Reason is entered for declining the timesheet");
                } else {
                    logger.log(LogStatus.INFO, "Text box for entering the reason to decline the timesheet is not enabled");
                }
            } else {
                logger.log(LogStatus.INFO, "Text box for entering the reason to decline the timesheet is not displayed");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while entering the reason to decline the timesheet");
        }
    }

    /*
    Click on Deny Button on the confirmation popup  of declining timesheet
     */
    public void confirmDeclineTimesheetByProjectManager() throws InterruptedException {
        Thread.sleep(3000);
        try {
            if (confirmDeny.isDisplayed()) {
                if (confirmDeny.isEnabled()) {
                    confirmDeny.click();
                    Thread.sleep(500);
                    logger.log(LogStatus.INFO, "Timesheet decline is confirmed by the Project Manager");
                } else {
                    logger.log(LogStatus.INFO, "Deny button is not enabled on the confirmation popup  of declining timesheet");
                }
            } else {
                logger.log(LogStatus.INFO, "Deny button is not displayed on the confirmation popup  of declining timesheet");
            }
        } catch (Exception e) {
            logger.log(LogStatus.ERROR, e.getMessage());
            logger.log(LogStatus.ERROR, "Exception occurred while clicking on Deny button on the confirmation popup  of declining timesheet");
        }
    }
}