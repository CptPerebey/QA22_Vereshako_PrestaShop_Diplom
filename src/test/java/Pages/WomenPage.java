package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;
@Log4j2
public class WomenPage extends BasePage{
    public WomenPage(WebDriver driver) {
        super(driver);
    }
    private final By PRODUCT_NAME_SELECTOR = By.cssSelector("#center_column .product-name");
    private final By PRODUCT_PRICE_SELECTOR = By.cssSelector("#center_column .right-block [itemprop='price']");
    private final By PRODUCT_LINK = By.cssSelector(".right-block .product-name");
    private final String PRODUCT_CONTAINER_LOCATOR = "//*[@class='product_img_link' and @title='%s']/ancestor::div[@class='product-container']";
    private final String PRODUCT_CONTAINER_LOCATOR_PRICE = "//span[@class='price product-price' and contains(text(),'%s ')] /ancestor::div[@class='product-container']";
    private final By ADD_TO_CARD_BUTTON = By.xpath("//*[@class='button ajax_add_to_cart_button btn btn-default']");
    private final By CLOSE_WINDOW_ADD_TO_CARD_BUTTON= By.xpath("//*[@class='cross']");
    private final By DROPDOWN_ON_WOMEN_PAGE = By.id("selectProductSort");
    private final static By CLOSE_BUTTON_IN_FILTER = By.cssSelector(".icon-remove");
    private final static By LOADING_ICON = By.xpath("//*[@class = 'product_list grid row']//img[@src='http://prestashop.qatestlab.com.ua/img/loader.gif' and contains(text(), '')]");


    public WebElement getProductContainerByName(String productsName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_CONTAINER_LOCATOR, productsName)));
    }

    public void openItemByName(String productsName) {
        WebElement productContainer = getProductContainerByName(productsName);
        productContainer.findElement(PRODUCT_LINK).click();
    }

    public boolean getProductName(String productsName) {
        WebElement productContainer = getProductContainerByName(productsName);
        return productContainer.findElement(PRODUCT_NAME_SELECTOR).isDisplayed();
    }

    public WebElement getProductContainerByPrice(String productsPrice) {
        return driver.findElement(By.xpath(String.format(PRODUCT_CONTAINER_LOCATOR_PRICE, productsPrice)));
    }

    public boolean getProductPrice(String productsPrice) {
        WebElement productContainer = getProductContainerByPrice(productsPrice);
        return productContainer.findElement(PRODUCT_PRICE_SELECTOR).isDisplayed();
    }

    public void clickCloseWindow(){
        log.info("Кликаю по кнопке Закрыть после добавления товара в корзину");
        driver.findElement(CLOSE_WINDOW_ADD_TO_CARD_BUTTON).click();
    }
    public List<String> getSortingListItemName (){
        List<WebElement> listItemName = driver.findElements(PRODUCT_NAME_SELECTOR);
        List<String> allListItemName = listItemName.stream().map(WebElement::getText).collect(Collectors.toList());
        return allListItemName;
    }
    public void selectSortingOrderOption (String optionName) {
        Select select = new Select(driver.findElement(DROPDOWN_ON_WOMEN_PAGE));
        select.selectByVisibleText(optionName);
    }
    public  void waitDownloadItem(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(LOADING_ICON));
    }
    public void clickItemByNameWithAction(String name){
        log.info("Кликаю по товару на странице с помощью Actions");
        Actions actions = new Actions(driver);
        actions
                .moveToElement(getProductContainerByName(name))
                .click()
                .build()
                .perform();
    }
    public void waitCloseButtonInFilter(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(CLOSE_BUTTON_IN_FILTER));
    }

}

