package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class MyAccountPage extends BasePage{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }


    private final static By MY_ACCOUNT_MASSAGE = By.xpath("//*[@class='info-account']");
    private final static By MY_WISHLIST_BUTTON = By.xpath("//*[@class= 'icon-heart']");
    private static final By ADDRESS_BUTTON = By.cssSelector(".icon-building");

    public static String getAccountMassage(){
      return driver.findElement(MY_ACCOUNT_MASSAGE).getText();
    }
    public void clickMyWishListButton(){
        log.info("Кликаю по кнопке мой список желаемого");
        driver.findElement(MY_WISHLIST_BUTTON).click();
    }
    public void clickMyAddressButton(){
        log.info("Кликаю по кнопке мой адрес");
        driver.findElement(ADDRESS_BUTTON).click();
    }

}
