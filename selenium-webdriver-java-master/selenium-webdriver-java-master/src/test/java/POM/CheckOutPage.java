package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage {
    WebDriver driver;
    //Billing
    By continueBillingButton = By.xpath(".//*[@id='billing-buttons-container']/button");
    By differentAddressButton = By.id("billing:use_for_shipping_no");
    By checkOutButton = By.xpath("//button[@title='Proceed to Checkout']");
    By firstNameInputLocator = By.id("billing:firstname");
    By lastnameInputLocator = By.id("billing:lastname");
    By addressInputLocator = By.id("billing:street1");
    By cityInputLocator = By.id("billing:city");
    By postcodeInputLocator = By.id("billing:postcode");
    By telephoneInputLocator = By.id("billing:telephone");

    //Shipping
    By shippingFirstName = By.id("shipping:firstname");
    By shippingLastName = By.id("shipping:lastname");
    By shippingAddress = By.id("shipping:street1");
    By shippingCity = By.id("shipping:city");
    By shippingTelephone = By.id("shipping:telephone");
    By continueShippingButton = By.xpath(".//*[@id='shipping-buttons-container']/button");
    By continueMethodButton = By.xpath(".//*[@id='shipping-method-buttons-container']/button");

    By checkMoneyOrder = By.xpath("//input[@title='Check / Money order']");
    By continuePayment = By.xpath(".//*[@id='payment-buttons-container']/button");
    By placeOrder = By.xpath(".//*[@id='review-buttons-container']/button");

   //verify
    By orderNumText = By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div/p[1]/a");
    By subTotalText = By.xpath(".//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span");
    By grandTotal = By.xpath(".//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span");







    //Constructor with required parameter as a WedDriver


    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    //methods billing
    public void clickPlaceOrder(){driver.findElement(placeOrder).click();}
    public void clickContinuePayment(){driver.findElement(continuePayment).click();}
    public void clickContinueBillingButton(){driver.findElement(continueBillingButton).click();}
    public void clickDifferentAddressButton(){driver.findElement(differentAddressButton).click();}
    public void clickCheckOutButton(){
        driver.findElement(checkOutButton).click();
    }
    public void clickCheckMoneyOrder(){driver.findElement(checkMoneyOrder).click();}




    public void enterFirstName(String firstName){
        WebElement firstNameElement = driver.findElement(firstNameInputLocator);
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);

    }
    public void enterLastName(String lastName){
        WebElement lastNameElement = driver.findElement(lastnameInputLocator);
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);

    }

    public void enterAddress(String address){
        WebElement addressElement = driver.findElement(addressInputLocator);
        addressElement.clear();
        addressElement.sendKeys(address);
    }

    public void enterCity(String city){
        WebElement cityElement = driver.findElement(cityInputLocator);
        cityElement.clear();
        cityElement.sendKeys(city);
    }

    public void enterPostcode(String postcode){
        WebElement postcodeElement = driver.findElement(postcodeInputLocator);
        postcodeElement.clear();
        postcodeElement.sendKeys(postcode);
    }

   public void enterTelephone(String telephone){
        WebElement telephoneElement = driver.findElement(telephoneInputLocator);
        telephoneElement.clear();
        telephoneElement.sendKeys(telephone);
   }

    //methods Shipping
    public void clickContinueMethodButton(){driver.findElement(continueMethodButton).click();}
    public void clickContinueShippingButton(){driver.findElement(continueShippingButton).click();}

    public void enterShippingFirstName(String firstname2){
        WebElement shippingFirstNameElement = driver.findElement(shippingFirstName);
        shippingFirstNameElement.clear();
        shippingFirstNameElement.sendKeys(firstname2);
    }

    public void enterShippingLastName(String lastname2){
        WebElement shippingLastNameElement = driver.findElement(shippingLastName);
        shippingLastNameElement.clear();
        shippingLastNameElement.sendKeys(lastname2);
    }
    public void enterShippingAddress(String address2){
        WebElement shippingAddressElement = driver.findElement(shippingAddress);
        shippingAddressElement.clear();
        shippingAddressElement.sendKeys(address2);
    }

    public void enterShippingCity(String city2){
        WebElement shippingCityElement = driver.findElement(shippingCity);
        shippingCityElement.clear();
        shippingCityElement.sendKeys(city2);
    }

    public void enterShippingTelephone(String telephone2){
        WebElement shippingTelephoneElement = driver.findElement(shippingTelephone);
        shippingTelephoneElement.clear();
        shippingTelephoneElement.sendKeys(telephone2);
    }

    //verify
    public String  getOrderNum(){return driver.findElement(orderNumText).getText();}
    public String getSubTotal(){return driver.findElement(subTotalText).getText();}
    public String getGrandTotal(){return driver.findElement(grandTotal).getText();}
    public void verifyOrder(){
        String orderNum = getOrderNum();
        System.out.println("*** Your order number for your record = " + orderNum);

    }

    public void verifyGrandOrder(){
        String subTotal = getSubTotal();
        String grandTotal = getGrandTotal();
        System.out.println("*** Cart Updated ***");
        System.out.println("GRAND TOTAL: "+grandTotal);

        if (subTotal == grandTotal){
            System.out.println("*** Grand Total price has not changed. ***");
        }else{
            System.out.println("*** Grand Total price has changed. ***");
        }
    }


}
