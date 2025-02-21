package StepDefinitions;

import Pagescode.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginSteps {

    WebDriver driver = DriverInitialization.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    //DriverInitialization driverInitialization = new DriverInitialization();
  //  LoginPage loginPage = new LoginPage(driverInitialization.getDriver());

   // LoginPage loginPage = new LoginPage(driverInitialization.getDriver());

   @Given("user launched website")
    public void userlaunchedwebsite() {

        loginPage.openBrowser();

    }

    @And("User Login with usrname and password and click login")
    public void userLoginWithUsrnameAndPasswordAndClickLogin() throws IOException {

       loginPage.loginwebsite();
       loginPage.getLastproducttext();
       //loginPage.GetallProductsandputitInExcel();
    }


}


