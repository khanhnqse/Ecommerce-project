package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CartPage {
    WebDriver driver;


    By regionInputLocator = By.id("region");
    By postcodeInputLocator = By.id("postcode");



    //Constructor with required parameter as a WedDriver

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
//method





    public void enterRegionInput(String region){
        WebElement regionElement = driver.findElement(regionInputLocator);
        regionElement.clear();
        regionElement.sendKeys(region);

    }
    public void enterPostcodeInput(String postcode){
        WebElement postcodeElement = driver.findElement(postcodeInputLocator);
        postcodeElement.clear();
        postcodeElement.sendKeys(postcode);
    }


}
