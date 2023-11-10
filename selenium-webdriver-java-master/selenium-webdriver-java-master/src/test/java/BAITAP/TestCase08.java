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

        String vPrice, sPrice;


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


            // Step 4.Click on 'REORDER' link , change QTY & click Update

            driver.findElement(By.linkText("REORDER")).click();

            // *  Get the Grand Total Price
            vPrice = driver.findElement(By.xpath(".//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")).getText();

            // this will change the QTY
            driver.findElement(By.xpath("//input[@title='Qty']")).clear();
            driver.findElement(By.xpath("//input[@title='Qty']")).sendKeys("10");

            //debug
            Thread.sleep(2000);
            //click the Update button
            driver.findElement(By.cssSelector("td.product-cart-actions > button[name=update_cart_action]")).click();
            System.out.println("*** Cart Updated ***");

            //Step 5. Verify Grand Total is changed
            sPrice = driver.findElement(By.xpath(".//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")).getText();
            System.out.println("sPrice ="+sPrice);

            if (vPrice== sPrice){
                System.out.println("*** Grand Total price has not changed. ***");
            }else{
                System.out.println("*** Grand Total price has changed. ***");
            }

            // Proceed to Checkout button
            driver.findElement(By.xpath("//button[@type='button']")).click();

//debug
            Thread.sleep(2000);
            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //Step 6. Complete Billing & Shipping Information
            // check radio button to "Ship to different address"
            driver.findElement(By.id("billing:use_for_shipping_no")).click();

            // click the CONTINUE button

            driver.findElement(By.xpath(".//*[@id='billing-buttons-container']/button")).click();
            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            Thread.sleep(2000);
            driver.findElement(By.xpath(".//*[@id='shipping-buttons-container']/button")).click();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            Thread.sleep(3000);
            // In Shipping Method, Click Continue
            driver.findElement(By.xpath(".//*[@id='shipping-method-buttons-container']/button")).click();

            Thread.sleep(2000);

            //Step 7. Verify order is generated and note the order number

            //  select 'Check/Money Order' radio button.
            driver.findElement(By.xpath("//input[@title='Check / Money order']")).click();
            Thread.sleep(2000);
            //Click Continue
            driver.findElement(By.xpath(".//*[@id='payment-buttons-container']/button")).click();
            Thread.sleep(2000);

            // Click 'PLACE ORDER' button
            driver.findElement(By.xpath(".//*[@id='review-buttons-container']/button")).click();

            Thread.sleep(2000);

            // Verify Order is generated. Note the order number
            String orderNum = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div/p[1]/a")).getText();
            System.out.println("*** Your order number for your record = " + orderNum);
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
