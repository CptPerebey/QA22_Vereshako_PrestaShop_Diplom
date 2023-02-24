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
    private static final By PROCESSED_TO_CHECKOUT_BUTTON= By.xpath("//*[@class='button btn btn-default standard-checkout button-medium']");
    private static final By PROCESSED_TO_CHECKOUT_BUTTON_ON_ADDRESS_STEP = By.xpath("//*[@class='button btn btn-default button-medium']");
    private static final By AGREE_WITH_DELIVERY_CHECKBOX = By.id("cgv");
    private static final By END_MASSAGE = By.xpath("//*[@class='alert alert-warning']");

    public void clickDeleteItemButton(){
        driver.findElement(DELETE_ITEM_BUTTON).click();
    }

    public String getItemPrice() {
        return driver.findElement(ITEMS_PRISE).getText();
    }
    public void clickProcessedToCheckoutButton(){
        driver.findElement(PROCESSED_TO_CHECKOUT_BUTTON).click();
    }
    public void clickAgreeWithDeliveryButton(){
        driver.findElement(AGREE_WITH_DELIVERY_CHECKBOX).click();
    }
    public void clickProcessedToCheckoutButtonOnAddressStep(){
        driver.findElement(PROCESSED_TO_CHECKOUT_BUTTON_ON_ADDRESS_STEP).click();
    }

    public static  String getEndMassage(){
        return driver.findElement(END_MASSAGE).getText();
    }

}
