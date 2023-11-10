package BAITAP;
/*
* 1. Go to http://live.techpanda.org/

2. Click on My Account link

3. Login in application using previously created credential

4. Click on 'My Orders'

5. Click on 'View Order'

6. Click on 'Print Order' link*/

import POM.LoginPage;
import POM.RegisterPage;
import driver.driverFactory;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

import static org.openqa.selenium.OutputType.FILE;

@Test
public class TestCase07 {
    public static void testTC07() {

        //login
        String email = "khanh3003@gmail.com";
        String pass = "khanh123";



        StringBuffer verificationError = new StringBuffer();
        //init web driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");
            RegisterPage registerPage = new RegisterPage(driver);
            LoginPage loginPage = new LoginPage(driver);
            //Step 2. Click on my account link
            registerPage.clickMyAccountLink();
            //debug
            Thread.sleep(2000);
            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            //debug
            Thread.sleep(2000);

            //Step 3. Login in application using previously created credential
            loginPage.enterEmail(email);
            loginPage.enterPassword(pass);
            loginPage.clickLoginButton();

            //debug
            Thread.sleep(2000);
            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }


            // Step 4. Click on 'My Orders'
            driver.findElement(By.linkText("MY ORDERS")).click();
            //debug
            Thread.sleep(2000);

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // 5. Click on 'View Order'
            driver.findElement(By.linkText("VIEW ORDER")).click();
            //debug
            Thread.sleep(2000);

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }


            // 6. Click on 'Print Order' link now covers 3
            driver.findElement(By.linkText("Print Order")).click();


            //debug
            Thread.sleep(2000);

            //Screenshot
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            String png = ("D:\\STUDY\\Semester 5\\SWT301\\Ecommerce-project-TC01-TC02-\\selenium-webdriver-java-master\\selenium-webdriver-java-master\\src\\test\\resources\\testcase07" + ".png");
            FileUtils.copyFile(scrFile, new File(png));


        }catch (Exception e){
            e.printStackTrace();
        }

        // Quit
        driver.quit();

    }
}
