package StepDefinitions;


import CommonMethods.Log4jLogger;
import MarketCode.ProductsPage;
import StepDefinitions.DriverInitialization;
import com.beust.ah.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class PoductPageSteps {


    static {
        System.setProperty("log4j2.configurationFile", "src/test/resources/log4j2.xml");
    }

    ProductsPage productsPage = new ProductsPage(DriverInitialization.getDriver());

    private static final Logger log = Log4jLogger.getLogger(PoductPageSteps.class);

    @When("User searches for {string} in the search bar")
    public void userSearchesForInTheSearchBar(String product) {

        productsPage.SearchForProduct(product);
        log.info("Clicking Searchbar from step defs");


    }

    @Then("User should see {string} in the product list")
    public void userShouldSeeInTheProductList(String ExpectedProduct) {

       String ActualProductname=  productsPage.ValidateProduct();

       System.out.println(ActualProductname+ "+" +ExpectedProduct);

        Assert.assertEquals(ExpectedProduct,ActualProductname);

    }

    @When("User adds the product to the cart")
    public void userAddsTheProductToTheCart() {

        productsPage.AddproductToCart();
    }

    @Then("The cart should display {int} item")
    public void theCartShouldDisplayItem(int ExpectedNumberOfItems) {

        int ActualNumberOfItems =productsPage.NumberOfItemsInCart();

        System.out.println(ActualNumberOfItems+ "+" +ExpectedNumberOfItems);



    }

    @And("User increases the quantity to {int}")
    public void userIncreasesTheQuantityTo(int ExpectedNumberofItems) {
        productsPage.AddItemstoCartasAsked(ExpectedNumberofItems);

    }
}
