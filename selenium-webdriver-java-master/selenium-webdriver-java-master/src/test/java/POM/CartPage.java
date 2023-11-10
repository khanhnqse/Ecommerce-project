package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CartPage {
    WebDriver driver;


    By regionInputLocator = By.id("region");
    By postcodeInputLocator = By.id("postcode");
    By reOderButton = By.xpath("//tr[@class='last even']//a[@class='link-reorder'][normalize-space()='Reorder']");
    By qtyText = By.cssSelector("input[title='Qty']");

    By updateqtyButton = By.cssSelector("button[title='Update']");


    //Constructor with required parameter as a WedDriver

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
//method

    public void clickUpdateQty(){driver.findElement(updateqtyButton).click();};
    public void clickReOrder(){driver.findElement(reOderButton).click();}
    public void enterQty(String qty) {
        WebElement qtyElement = driver.findElement(qtyText);
        qtyElement.clear();
        qtyElement.sendKeys(qty);
    }


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
