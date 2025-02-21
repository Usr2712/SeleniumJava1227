package StepDefinitions;

import Pagescode.AddToCartPage;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AddToCartSteps {

    WebDriver driver = DriverInitialization.getDriver();
    AddToCartPage addToCartPage = new AddToCartPage(driver);


    //   DriverInitialization driverInitialization = new DriverInitialization();
 //   AddToCartPage addToCartPage = new AddToCartPage(driverInitialization.getDriver());

    @Test(description = "Verify User is able to place order")
    @And("user orders {string}")
    public void userOrders(String Product) {

        addToCartPage.addProductAndDoPayment(Product);
    }



}
