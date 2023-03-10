package pages;

import enums.SelectOptionOnHeadPage;
import io.qameta.allure.Step;
import myUtils.MyUtils;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;
@Log4j2
public class HeadPage extends BasePage{
    public HeadPage(WebDriver driver) {
        super(driver);
    }

    private static final By LOGIN_BUTTON = By.cssSelector(".login");
    private static final By ITEM_ON_HEAD_LINK = By.cssSelector("ul.active li");
    private static final By POPULAR_BUTTON= By.xpath("//*[@class='homefeatured']");
    private static final By HEADLINER_BUTTON = By.xpath("//*[@class='blockbestsellers']");
    private static final By WOMEN_BUTTON = By.cssSelector(".sf-with-ul[title='Women']");
    private static final By CARD_BUTTON = By.xpath("//*[@class='shopping_cart']/a");
    private static final By SEARCH_INPUT = By.id("search_query_top");
    private static final By SEARCH_BUTTON = By.xpath("//*[@class='btn btn-default button-search']");
    private static final By MY_ACCOUNT_BUTTON = By.cssSelector(".account");
    private static final By LOGOUT_BUTTON = By.cssSelector(".logout");
    private static final By HOME_SLIDER = By.id("homepage-slider");

    @Step
    public void clickLoginButton(){
        log.info("Кликаю по кнопке Login на главной странице");
        driver.findElement(LOGIN_BUTTON).click();
    }
    @Step
    public void clickPopularButton(){
        log.info("Кликаю по кнопке Популярное на главной странице");
        driver.findElement(POPULAR_BUTTON).click();
    }
    @Step
    public void clickHeadLinerButton(){
        log.info("Кликаю по кнопке Лидеры продаж на главной странице");
        driver.findElement(HEADLINER_BUTTON).click();
    }
    @Step
    public List<String> getSortingListItemName (){
        List<WebElement> listItemName = driver.findElements(ITEM_ON_HEAD_LINK);
        List<String> allListItemName = listItemName.stream().map(WebElement::getText).map(MyUtils::getItemName).collect(Collectors.toList());
        return allListItemName;
    }
    @Step
    public void selectSortingOrderOption(String optionName) {
        log.info("Выбор кнопки Популярное или Лидеры продаж на главной странице");
        if (optionName == SelectOptionOnHeadPage.POPULAR.optional) {
            clickPopularButton();
        }else if (optionName == SelectOptionOnHeadPage.HEADLINER.optional) {
            clickHeadLinerButton();
        }
    }
    @Step
    public void clickWomenButton() {
        log.info("Кликаю по кнопке Women");
        driver.findElement(WOMEN_BUTTON).click();
    }
    @Step
    public void clickCardButton(){
        log.info("Кликаю по кнопке Корзина");
        driver.findElement(CARD_BUTTON).click();
    }
    @Step
    public void setSearchInput(String itemName){
        log.info(String.format("Ввожу имя товара %s ", itemName));
        driver.findElement(SEARCH_INPUT).sendKeys(itemName);
    }
    @Step
    public void clickSearchButton(){
        log.info("Кликаю по кнопке поиск с помощью Action");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(SEARCH_BUTTON))
                .click()
                .build()
                .perform();
    }
    @Step
    public void clickMyAccountButton(){
        log.info("Кликаю по кнопке мой аккаунт");
        driver.findElement(MY_ACCOUNT_BUTTON).click();
    }
    public boolean loginButtonIsPresent() {
        try {
            driver.findElement(LOGIN_BUTTON);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }
    public void clickLogOutButton(){
        driver.findElement(LOGOUT_BUTTON).click();
    }
    public void waitLastElementOnHeadPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(HOME_SLIDER));
    }


}
