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
    private static final By ITEM_ON_HEAD_PAGE = By.xpath("//div/ul[@id='homefeatured']");
    private static final String ITEM_ON_HEAD_LINK = "//div/ul[@id='homefeatured' and text()='%s']/ancestor:://div/ul[@id='homefeatured']";
    private static final By POPULAR_BUTTON= By.xpath("//*[@class='homefeatured']");
    private static final By HEADLINER_BUTTON = By.xpath("//*[@class='blockbestsellers']");
    private static final By POPULAR_OR_HEADLINER_BUTTON = By.cssSelector(".homefeatured");


    public void clickLoginButton(){
        driver.findElement(LOGIN_BUTTON).click();
    }
    public void clickPopularButton(){
        driver.findElement(POPULAR_BUTTON).click();
    }
    public void clickHeadLinerButton(){
        driver.findElement(HEADLINER_BUTTON).click();
    }

    public By getItemContainerByName(String itemName) {
        return By.xpath(String.format(ITEM_ON_HEAD_LINK, itemName));
    }
    public List<String> getSortingListItemName (){
        List<WebElement> listItemName = driver.findElements(ITEM_ON_HEAD_PAGE);
        List<String> allListItemName = listItemName.stream().map(WebElement::getText).collect(Collectors.toList());
        return allListItemName;
    }
    public void selectSortingOrderOption (String optionName) {
        Select select = new Select(driver.findElement(POPULAR_OR_HEADLINER_BUTTON));
        select.selectByVisibleText(optionName);
    }
    /*public void  selectSortingOrderOption2 (WebElement optionName) {
       List<WebElement> selectTmh= driver.findElements(POPULAR_OR_HEADLINER_BUTTON);
       selectTmh.size();
       if ()
    }*/



}
