package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage{

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }
    protected final By ITEM_NAME = By.cssSelector("[itemprop='name']");
    private final By ITEM_PRICE = By.cssSelector("#our_price_display");
    private final By ADD_TO_CARD_ITEM_BUTTON = By.cssSelector(".buttons_bottom_block.no-print .exclusive");
    private final By CARD_MASSAGE = By.xpath("//i[@class='icon-ok']");



    public String getItemName() {
        return driver.findElement(ITEM_NAME).getText();
    }

    public String getItemPrice() {
        return driver.findElement(ITEM_PRICE).getText();
    }

    public void addToCardItem(){
        driver.findElement(ADD_TO_CARD_ITEM_BUTTON).click();
    }
    public boolean checkAddToCard(){
     return   driver.findElement(CARD_MASSAGE).isDisplayed();
    }

}
