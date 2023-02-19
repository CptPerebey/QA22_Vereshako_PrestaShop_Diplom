package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class WomenPage extends BasePage{
    public WomenPage(WebDriver driver) {
        super(driver);
    }
    private static final By LIST_ITEM_LINK_WOMENPAGE= By.xpath("//div[@class='right-block']");



    public List<String> getItemList(){

        List<WebElement> listItemName = driver.findElements(LIST_ITEM_LINK_WOMENPAGE);
        List<String> allListItemName = listItemName.stream().map(WebElement::getText).collect(Collectors.toList());
        return allListItemName;
    }



}
