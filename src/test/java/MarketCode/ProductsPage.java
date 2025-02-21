package MarketCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {



    private WebDriver driver;


    @FindBy(xpath = "//input[@type='search']")
    static WebElement searchbar;


    @FindBy(xpath = "//h4[@class='product-name']")
    static WebElement productname;

    @FindBy(xpath = "//button[contains(text(),'ADD TO CART')]")
    static WebElement addtocartbtn;


    @FindBy(xpath = "//td[3]")
    static WebElement ItemsinCart;

    @FindBy(xpath = "//a[@class='increment']")
    static WebElement increment;

    public ProductsPage(WebDriver driver){


        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void SearchForProduct(String Product){

        searchbar.click();
        searchbar.sendKeys(Product);

    }

    public String  ValidateProduct(){


        String[] Productnames=productname.getText().split("-");

        String Productname = Productnames[0].trim();

        System.out.println(Productname);

        return Productname;
    }

    public void AddproductToCart(){

        addtocartbtn.click();

    }

    public int NumberOfItemsInCart(){

        int ActualItems = Integer.parseInt(ItemsinCart.getText());

        return ActualItems;
    }

    public void AddItemstoCartasAsked(int NumberOfItems){

        for(int i = 1 ;i<NumberOfItems ;i++){



            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            WebElement increment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='increment']")));

            increment.click();

        }

    }
}
