package BAITAP;

import POM.AdminPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;

import static org.openqa.selenium.OutputType.FILE;
@Test
public class TestCase10 {
    public static void testTC10() {

        String id = "user01";
        String pass = "guru99com";
        String orderID = "100021100";
        String fromDate = "11/1/2023";
        String toDate = "11/11/2023";
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to  http://live.techpanda.org/index.php/backendlogin
            driver.get(" http://live.techpanda.org/index.php/backendlogin");

            // Step 2. Login the credentials provided
            AdminPage adminPage = new AdminPage(driver);
            adminPage.enterUserName(id);
            adminPage.enterPassword(pass);
            adminPage.clickLogin();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            Thread.sleep(3000);

            //2a close incomming msg
            adminPage.clickCloseMessage();

            // 3. Go to Sales-> Orders menu
            adminPage.clickSalesMenu();
            adminPage.clickOrderMenu();
            Thread.sleep(2000);
            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //Step  4. Input OrderId and FromDate -> ToDate

            adminPage.enterOrderID(orderID);
            Thread.sleep(1000);
            adminPage.enterFromDate(fromDate);
            Thread.sleep(1000);
            adminPage.enterToDate(toDate);
            Thread.sleep(1000);

            //Step 5.Click Search button
//            driver.findElement(By.xpath("//span[contains(text(),'Search')]")).click();
            adminPage.clickSearchButton();
            Thread.sleep(2000);
            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //Screenshot
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            String png = ("D:\\STUDY\\Semester 5\\SWT301\\Ecommerce-project-TC01-TC02-\\selenium-webdriver-java-master\\selenium-webdriver-java-master\\src\\test\\resources\\testcase10" + ".png");
            FileUtils.copyFile(scrFile, new File(png));



        } catch (Exception e) {
            e.printStackTrace();
        }


        // Quit
        driver.quit();
    }}

