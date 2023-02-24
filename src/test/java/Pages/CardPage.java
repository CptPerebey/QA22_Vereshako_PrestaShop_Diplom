package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CardPage extends BasePage{
    public CardPage(WebDriver driver) {
        super(driver);
    }
    private static final By DELETE_ITEM_BUTTON = By.cssSelector(".icon-trash");
    private static final By ITEM_IN_CARD_LINK = By.id("cart_summary");
    private static final By ITEMS_PRISE = By.xpath("//*[@id='total_price']");

    public void clickDeleteItemButton(){
        driver.findElement(DELETE_ITEM_BUTTON).click();
    }

    public String getItemPrice() {
        return driver.findElement(ITEMS_PRISE).getText();
    }

}
