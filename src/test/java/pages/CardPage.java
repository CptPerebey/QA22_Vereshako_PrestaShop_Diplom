package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
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

    @Step
    public void clickDeleteItemButton(){
        log.info("Кликаю по кнопке удалить товар из корзины");
        driver.findElement(DELETE_ITEM_BUTTON).click();
    }
    @Step
    public String getItemPrice() {
        return driver.findElement(ITEMS_PRISE).getText();
    }
    @Step
    public void clickProcessedToCheckoutButton(){
        log.info("Кликаю по кнопке ProcessedToCheckout для перехода к следующему шагу покупки");
        driver.findElement(PROCESSED_TO_CHECKOUT_BUTTON).click();
    }
    @Step
    public void clickAgreeWithDeliveryButton(){
        log.info("Кликаю по кнопке AgreeWithDelivery для того что бы была возможность продолжить покупку");
        driver.findElement(AGREE_WITH_DELIVERY_CHECKBOX).click();
    }
    @Step
    public void clickProcessedToCheckoutButtonOnAddressStep(){
        log.info("Кликаю ProcessedToCheckout на шаге выбора ардреса, т.к. там нужен отдельный локатор");
        driver.findElement(PROCESSED_TO_CHECKOUT_BUTTON_ON_ADDRESS_STEP).click();
    }
    @Step
    public static  String getEndMassage(){
        return driver.findElement(END_MASSAGE).getText();
    }



}
