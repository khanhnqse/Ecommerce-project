package BAITAP;


import POM.CouponPage;
import POM.LoginPage;
import POM.RegisterPage;
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
public class TestCase09 {
    public static void testTC09() {
        String coupon = "GURU50";
        WebDriver driver = driverFactory.getChromeDriver();
        try {

            CouponPage couponPage = new CouponPage(driver);
            //Step 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            //Step 2. Go to Mobile
            couponPage.clickMobileButton();
            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            Thread.sleep(2000);

            // add IPHONE to cart
            couponPage.clickAddMobile();

            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            Thread.sleep(2000);

            couponPage.enterCouponInput(coupon);
            couponPage.clickApplyButton();

            // //4. 4. Verify the discount generated
            couponPage.getOriginalPrice();
            couponPage.getDiscountedPrice();
            couponPage.verifyDiscountedPrice();

            //Screenshot
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            String png = ("D:\\STUDY\\Semester 5\\SWT301\\Ecommerce-project-TC01-TC02-\\selenium-webdriver-java-master\\selenium-webdriver-java-master\\src\\test\\resources\\testcase09" + ".png");
            FileUtils.copyFile(scrFile, new File(png));


        } catch (Exception e) {
            e.printStackTrace();
        }


        // Quit
        driver.quit();
    }
}
