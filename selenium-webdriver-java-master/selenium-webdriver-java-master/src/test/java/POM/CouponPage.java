package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CouponPage {
    WebDriver driver;
    By mobileButton = By.xpath("//a[normalize-space()='Mobile']");
    By addMobileToCartLocator = By.xpath("//li[1]//div[1]//div[3]//button[1]//span[1]//span[1]");
    By couponInputLocator = By.id("coupon_code");

    By applyButton = By.xpath("//span[contains(text(),'Apply')]");

    By originalPrice = By.xpath("//strong//span[@class='price'][normalize-space()='$500.00']");
    By discountedPrice = By.xpath("//strong//span[@class='price'][normalize-space()='$500.00']");
    By discountText = By.xpath("(//td)[15]");

    //Constructor with required parameter as a WedDriver
    public CouponPage(WebDriver driver) {
        this.driver = driver;
    }
//method
    public void clickMobileButton(){
    driver.findElement(mobileButton).click();
}
    public void clickAddMobile(){
        driver.findElement(addMobileToCartLocator).click();
    }
    public void enterCouponInput(String coupon){
        WebElement couponElement = driver.findElement(couponInputLocator);
        couponElement.clear();
        couponElement.sendKeys(coupon);
    }

    public void clickApplyButton(){driver.findElement(applyButton).click();}

    public String getOriginalPrice(){return driver.findElement(originalPrice).getText();}
    public String getDiscountedPrice(){return driver.findElement(discountedPrice).getText();}


    public String getDiscountText() {
        return driver.findElement(discountText).getText();
    }

    public boolean verifyDiscountedPrice(){
        String subTotal = getOriginalPrice();
        String discount = getDiscountText();
        String grandTotal = getDiscountedPrice();
        double subTotalValue = Double.parseDouble(subTotal.replaceAll("[^\\d.]+", ""));
        double discountValue = Double.parseDouble(discount.replaceAll("[^\\d.]+", ""));
        double grandTotalValue = Double.parseDouble(grandTotal.replaceAll("[^\\d.]+", ""));

        System.out.println("Original Price: " + subTotal);
        System.out.println("Discount: " +discount );
        System.out.println("Discounted Price: " + grandTotal);
//        assert !subTotal.equals(grandTotal) : "Total price is not discounted";

        if (subTotalValue - discountValue == grandTotalValue) {
            System.out.println("Price is discounted by 5%.");
            System.out.println(grandTotal);
            return true;
        } else {
            assert !subTotal.equals(grandTotal) : "GRAND TOTAL is not discounted";
            return false;
        }

    }




}
