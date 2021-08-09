package TestNGSessions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DemoExtentReports {

ExtentReports extent;
ExtentSparkReporter sparkReporter;


    @BeforeSuite
    public void BeforeSuite() {
        extent = new ExtentReports();
        sparkReporter = new ExtentSparkReporter("report.html");
        extent.attachReporter(sparkReporter);
    }

    @AfterSuite
    public void AfterSuite() {
        extent.flush();
    }


    @Test
    public void DemoExtentReports(){

        ExtentTest test = extent.createTest("Test Case 1 - Arizona state website DISCOVER AZ button test");
        System.setProperty("webdriver.chrome.driver", "C://selenium jars and drivers/drivers/chrome/chromedriver.exe");
        test.log(Status.INFO, "Launching the Chrome browser!");
        WebDriver driver = new ChromeDriver();
       // driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        test.info("Opening the URL on the browser: " + "http://www.AZ.gov");
        driver.get("http://www.AZ.gov");
        test.info("Clicking on the DISCOVER AZ button!");
        driver.findElement(By.partialLinkText("DISCOVER AZ")).click();
        test.info("Clicking on the BUSINESS button!");
        driver.findElement(By.partialLinkText("BUSINESS")).click();
        test.info("Clicking on the RESIDENTS button!");
        driver.findElement(By.partialLinkText("RESIDENTS")).click();
        test.info("Clicking on the EXPLORE button!");
        driver.findElement(By.partialLinkText("EXPLORE")).click();
        test.info("Clicking on the GOVERNMENT button!");
        driver.findElement(By.partialLinkText("GOVERNMENT")).click();
        test.info("Clicking on the COVID-19 UPDATES button!");
        driver.findElement(By.partialLinkText("COVID-19 UPDATES")).click();
        test.pass("We have successfully clicked on the DISCOVER button");
        test.pass("We have successfully clicked on the BUSINESS button");
        test.pass("We have successfully clicked on the RESIDENTS button");
        test.pass("We have successfully clicked on the EXPLORE button");
        test.pass("We have successfully clicked on the GOVERNMENT button");
        test.pass("We have successfully clicked on the COVID-19 UPDATES button");
        test.pass("We have successfully executed all of the Positive Button Verification tests");
        test.info("Closing the browser!");
        test.info("Disposing Selenium Sessions.");
        driver.close();
        driver.quit();
    }

    @Test
    public void DemoExtentReportsNegative(){

        ExtentTest test = extent.createTest("Test Case 2 - Arizona State Website Negative Button Verification");
        System.setProperty("webdriver.chrome.driver", "C://selenium jars and drivers/drivers/chrome/chromedriver.exe");
        test.log(Status.INFO, "Launching the Chrome browser!");
        WebDriver driver = new ChromeDriver();
      //  driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
      //  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        test.info("Opening the URL on the browser: " + "http://www.AZ.GOV");
        driver.get("http://www.AZ.GOV");
        test.info("Attempting to Click on the fake named button!");
        try {
            driver.findElement(By.linkText("Batman")).click();
        }
        catch (NoSuchElementException e) {
            test.fail("Unable to find the fake named button");
        }
        test.pass("We have successfully executed all of the Negative Button Verification tests");
        test.info("Closing the browser!");
        test.info("Disposing Selenium Sessions.");
        driver.close();
        driver.quit();
    }
}

