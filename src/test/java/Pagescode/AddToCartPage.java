package Pagescode;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddToCartPage  {

    public WebDriver driver;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    static WebElement SauceLabsBackPackAddtocart;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    static WebElement cart;

    @FindBy(xpath = "//button[@id='checkout']")
    static WebElement chekout;


    @FindBy(xpath = "//input[@id='first-name']")
    static WebElement firstname;


    @FindBy(xpath = "//input[@id='last-name']")
    static WebElement lastname;
    @FindBy(xpath = "//input[@id='postal-code']")
    static WebElement postalcode;


    @FindBy(xpath = "//input[@id='continue']")
    static WebElement continuebtn;

    @FindBy(xpath = "//button[@id='finish']")
    static WebElement finish;
    @FindBy(xpath = "//h2[text()='Thank you for your order!']")
    static WebElement Thankyou;


    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addProductAndDoPayment( String Product){

        if(Product.equals("Sauce Labs Backpack")){


            SauceLabsBackPackAddtocart.click();
            cart.click();
           JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(false);",chekout);
            chekout.click();
            firstname.sendKeys("Testfirstname");
            lastname.sendKeys("Testlastname");
            postalcode.sendKeys("12345678");
            js.executeScript("arguments[0].scrollIntoView(false);",continuebtn);

            continuebtn.click();
            finish.click();

            Assert.assertEquals(Thankyou.getText(),"Thank u for your order!");




        }


    }
}

