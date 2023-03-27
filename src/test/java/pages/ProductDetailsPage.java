package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    private final By ADD_TO_CARD_ITEM_BUTTON = By.xpath("//*[@name='Submit']");
    private final By CARD_MASSAGE = By.xpath("//i[@class='icon-ok']");
    protected final static By ADD_TO_WISHLIST_BUTTON = By.id("wishlist_button");
    protected final static By CLOSE_MASSAGE_ADD_TO_WISHLIST = By.xpath("//*[@title='Close']");


    @Step
    public void clickAddToCardItem() {
        log.info("Кликаю по кнопке добавить в корзину");
        driver.findElement(ADD_TO_CARD_ITEM_BUTTON).click();
    }

    @Step
    public boolean checkAddToCard() {
        log.info("Проверяю товар в корзине");
        return driver.findElement(CARD_MASSAGE).isDisplayed();
    }

    @Step
    public void waitAddToCardMassageIsPresent() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CARD_MASSAGE));
    }

    @Step
    public void clickAddToWishListButton() {
        log.info("Кликаю по кнопке Добавить в список желаемого");
        driver.findElement(ADD_TO_WISHLIST_BUTTON).click();
    }

    @Step
    public void clickCloseButtonAfterAddToWishL() {
        log.info("Кликаю по кнопке Кликаю по кнопке закрыть после добавления товара в список желаемого");
        driver.findElement(CLOSE_MASSAGE_ADD_TO_WISHLIST).click();
    }

}
