package Pages;

import Pages.MyUtils.MyUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class WishListPage extends BasePage{
    protected static final By MY_WISHLIST = By.xpath("//a[@href= 'javascript:;']/../following-sibling::td/a[@onclick]");
    private static final By ITEM_ON_WISHLIST_LINK = By.xpath("//*[@class='product-name']/small/ancestor::p");


    public WishListPage(WebDriver driver) {
        super(driver);
    }

    public void clickMyWishListButton(){
        jsClick(driver.findElement(MY_WISHLIST));
    }
    public List<String> getSortingListItemName (){
        List<WebElement> listItemName = driver.findElements(ITEM_ON_WISHLIST_LINK);
        List<String> allListItemName = listItemName.stream().map(WebElement::getText).map(MyUtils::getItemName).collect(Collectors.toList());
        return allListItemName;
    }




}
