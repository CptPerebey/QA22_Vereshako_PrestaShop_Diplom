package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.stream.Collectors;

public class HeadPage extends BasePage{
    public HeadPage(WebDriver driver) {
        super(driver);
    }

    private static final By LOGIN_BUTTON = By.cssSelector("a.login");

    private static final By ITEM_ON_HEAD_PAGE = By.xpath("//div/ul[@id='homefeatured']/li");

    private static final By ITEM_ON_HEAD_LINK = By.xpath("//ul[@id='homefeatured']//a[@class='product-name']");
    private static final By POPULAR_BUTTON= By.xpath("//*[@class='homefeatured']");
    private static final By HEADLINER_BUTTON = By.xpath("//*[@class='blockbestsellers']");
    private static final By PRODUCT_PRICE_LOKATOR = By.cssSelector("#our_price_display");
    private static final By WOMEN_BUTTON = By.cssSelector(".sf-with-ul[title='Women']");
    private static final By CARD_BUTTON = By.xpath("//*[@class='shopping_cart']/a");
    private static final By SEARCH_INPUT = By.id("search_query_top");
    private static final By SEARCH_BUTTON = By.xpath("//*[@class='btn btn-default button-search']");
    private static final By MY_ACCOUNT_BUTTON = By.cssSelector(".account");


    public void clickLoginButton(){
        driver.findElement(LOGIN_BUTTON).click();
    }
    public void clickPopularButton(){
        driver.findElement(POPULAR_BUTTON).click();
    }
    public void clickHeadLinerButton(){
        driver.findElement(HEADLINER_BUTTON).click();
    }

    public List<String> getSortingListItemName (){
        List<WebElement> listItemName = driver.findElements(ITEM_ON_HEAD_LINK);
        List<String> allListItemName = listItemName.stream().map(WebElement::getText).collect(Collectors.toList());
        return allListItemName;
    }
    public void selectSortingOrderOption(String optionName) {
        if (optionName == "Popular") {
            clickPopularButton();
        }else if (optionName == "HeadLiner") {
            clickHeadLinerButton();
        }
    }
    public void clickWomenButton() {
        driver.findElement(WOMEN_BUTTON).click();
    }

    public void clickCardButton(){
        driver.findElement(CARD_BUTTON).click();
    }
    public void setSearchInput(String itemName){
        driver.findElement(SEARCH_INPUT).sendKeys(itemName);
    }
    public void clickSearchButton(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(SEARCH_BUTTON))
                .click()
                .build()
                .perform();
    }
    public void clickMyAccountButton(){
        driver.findElement(MY_ACCOUNT_BUTTON).click();
    }




}
