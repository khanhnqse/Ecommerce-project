package BAITAP;

/*
* *  Verify you are able to change or reorder previously added product

 *  Test Data = QTY = 10

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on my account link

3. Login in application using previously created credential

4. Click on 'REORDER' link , change QTY & click Update

5. Verify Grand Total is changed

6. Complete Billing & Shipping Information

7. Verify order is generated and note the order number

Expected outcomes:

1) Grand Total is Changed

2) Order number is generated*/

import POM.CartPage;
import POM.CheckOutPage;
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
public class TestCase08 {
    public static void testTC08() {

        //login
        String email = "khanh3003@gmail.com";
        String pass = "khanh123";
        String qty = "10";

        String vPrice, sPrice;


        StringBuffer verificationError = new StringBuffer();
        //init web driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");
            CartPage cartPage = new CartPage(driver);
            RegisterPage registerPage = new RegisterPage(driver);
            LoginPage loginPage = new LoginPage(driver);
            CheckOutPage checkOutPage = new CheckOutPage(driver);
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


            // Step 4.Click on 'REORDER' link , change QTY & click Update
            cartPage.clickReOrder();
            Thread.sleep(2000);
            cartPage.enterQty(qty);
            Thread.sleep(2000);
            cartPage.clickUpdateQty();
            Thread.sleep(2000);

            //Step 5. Verify Grand Total is changed
            // *  Get the Grand Total Price
            checkOutPage.verifyGrandOrder();
            // Proceed to Checkout button
           checkOutPage.clickCheckOutButton();
            Thread.sleep(2000);
            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //Step 6. Complete Billing & Shipping Information
            // check radio button to "Ship to different address"
            checkOutPage.clickDifferentAddressButton();

            // click the CONTINUE button
            checkOutPage.clickContinueBillingButton();
            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            Thread.sleep(2000);
            checkOutPage.clickContinueShippingButton();
            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            Thread.sleep(3000);
            // In Shipping Method, Click Continue
            checkOutPage.clickContinueMethodButton();
            Thread.sleep(2000);

            //Step 7. Verify order is generated and note the order number
            //  select 'Check/Money Order' radio button.
            checkOutPage.clickCheckMoneyOrder();
            Thread.sleep(2000);
            //Click Continue
            checkOutPage.clickContinuePayment();
            Thread.sleep(2000);
            // Click 'PLACE ORDER' button
            checkOutPage.clickPlaceOrder();

            Thread.sleep(2000);

            // Verify Order is generated. Note the order number
           checkOutPage.verifyOrder();
            //Screenshot
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            String png = ("D:\\STUDY\\Semester 5\\SWT301\\Ecommerce-project-TC01-TC02-\\selenium-webdriver-java-master\\selenium-webdriver-java-master\\src\\test\\resources\\testcase08" + ".png");
            FileUtils.copyFile(scrFile, new File(png));



    } catch (Exception e) {
            e.printStackTrace();
        }


        // Quit
        driver.quit();
    }
}
