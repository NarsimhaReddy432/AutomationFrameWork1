package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
    Properties prop;


    public ConfigDataProvider() {

        File src = new File("./Configuration/config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);

            prop = new Properties();

            prop.load(fis);

        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
        }

    }

    public String getIEPath() {
        return prop.getProperty("IEPath");

    }


    public String getChromePath() {
        return prop.getProperty("chromePath");

    }

    public String getFirefoxPath() {
        return prop.getProperty("firefoxPath");

    }

    public String getEdgePath() {
        return prop.getProperty("edge");

    }

    public String getOperaPath() {
        return prop.getProperty("opera");

    }

    public String getSafariPath() {
        return prop.getProperty("safari");

    }

    public String getPanthonJSPath() {
        return prop.getProperty("phanthomjsheadlessbrowser");

    }

    public String getHtmlUnitDriverPath() {
        return prop.getProperty("htmlunitdriverheadlessbrowser");

    }

    /*
    Get Application url from config file
     */
    public String getApplicationUrl() {
        String url = prop.getProperty("ApplicationURL");
        return url;
    }

    /*
    Get Employee user name from config file
     */
    public String getEmployeeUserName() {
        return prop.getProperty("employeeUserName");
    }

    /*
    Get Employee password from config file
     */
    public String getEmployeePassword() {
        return prop.getProperty("employeePassword");
    }

    /*
    Get Brower Name from config file
     */
    public String getBrowserName() {
        return prop.getProperty("browser");
    }

    public String getProjectManagerUserName() {
        return prop.getProperty("projectManagerUserName");
    }

    public String getProjectManagerPwd() {
        return prop.getProperty("projectManagerPassword");
    }

    public String getReportingManagerUserName() {
        return prop.getProperty("ReportingManagerUserName");
    }

    public String getReportingManagerPwd() {
        return prop.getProperty("ReportingManagerPassword");
    }


    public String getFileUploadPath() {
        return prop.getProperty("fileuploadAutoItExePath");
    }
}