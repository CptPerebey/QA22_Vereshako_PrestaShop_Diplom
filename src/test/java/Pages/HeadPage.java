package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import java.util.Arrays;
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
    private final By PRODUCT_PRICE_LOKATOR = By.cssSelector("#our_price_display");
    protected By WOMEN_BUTTON = By.cssSelector(".sf-with-ul[title='Women']");


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
    public void  selectSortingOrderOption2 (String optionName) {
        if (optionName == "Popular") {
            clickPopularButton();
        }
        if (optionName == "HeadLiner") {
            clickHeadLinerButton();
        }
    }
    public void clickWomenButton() {
        driver.findElement(WOMEN_BUTTON).click();
    }



}
