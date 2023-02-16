package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }


    private final static By MY_ACCOUNT_MASSAGE = By.xpath("//*[@class='info-account']");


    public static String getAccountMassage(){
      return driver.findElement(MY_ACCOUNT_MASSAGE).getText();
    }
}
