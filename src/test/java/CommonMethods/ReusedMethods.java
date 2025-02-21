package CommonMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReusedMethods {


    public static void EnterText(WebElement Element ,String str){

        Element.sendKeys(str);
    }
}
