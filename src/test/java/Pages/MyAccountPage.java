package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }


    private final static By MY_ACCOUNT_MASSAGE = By.xpath("//*[@class='info-account']");
    private final static By MY_WISHLIST_BUTTON = By.xpath("//*[@class= 'icon-heart']");


    public static String getAccountMassage(){
      return driver.findElement(MY_ACCOUNT_MASSAGE).getText();
    }
    public void clickMyWishListButton(){
        driver.findElement(MY_WISHLIST_BUTTON).click();
    }

}
