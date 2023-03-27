package pages;

import io.qameta.allure.Step;
import myUtils.MyUtils;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class WishListPage extends BasePage {
    protected static final By MY_WISHLIST = By.xpath("//a[@href='javascript:;' and contains(@onclick, 'javascript:WishlistManage')]");
    private static final By ITEM_ON_WISHLIST_LINK = By.xpath("//*[@class='product-name']/small/ancestor::p");


    public WishListPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void clickMyWishListButton() {
        log.info("Кликаю по кнопке Мой список с помощью JS что бы открылся список с добавлеными товарами");
        jsClick(driver.findElement(MY_WISHLIST));
    }

    @Step
    public List<String> getSortingListItemName() {
        List<WebElement> listItemName = driver.findElements(ITEM_ON_WISHLIST_LINK);
        List<String> allListItemName = listItemName.stream().map(WebElement::getText).map(MyUtils::getItemName).collect(Collectors.toList());
        return allListItemName;
    }


}
