package modal;

import pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseModal extends BasePage {
    public BaseModal(WebDriver driver) {
        super(driver);
    }
    private static final By FILTER_TOPS_BUTTON = By.xpath("//a[@rel ='nofollow' and contains(text(),'Tops')]/ancestor::li//input[@class ='checkbox']");
    private static final By FILTER_DRESSES_BUTTON = By.xpath("//a[@rel ='nofollow' and contains(text(),'Dresses')]/ancestor::li//input[@class ='checkbox']");
    private static final By FILTER_JACKETS_BUTTON = By.xpath("//a[@rel ='nofollow' and contains(text(),'Jackets')]/ancestor::li//input[@class ='checkbox']");
    private static final By FILTER_SHOES_BUTTON = By.xpath("//a[@rel ='nofollow' and contains(text(),'Shoes')]/ancestor::li//input[@class ='checkbox']");
    private static final By FILTER_BAGS_BUTTON = By.xpath("//a[@rel ='nofollow' and contains(text(),'Bags')]/ancestor::li//input[@class ='checkbox']");
    private static final By FILTER_SUIT_BUTTON = By.xpath("//a[@rel ='nofollow' and contains(text(),'Suit')]/ancestor::li//input[@class ='checkbox']");

    public void clickTopsButton(){
        driver.findElement(FILTER_TOPS_BUTTON).click();
    }
    public void clickDressesButton(){
        driver.findElement(FILTER_DRESSES_BUTTON).click();
    }
    public void clickJacketsButton(){
        driver.findElement(FILTER_JACKETS_BUTTON).click();
    }
    public void clickShoesButton(){
        driver.findElement(FILTER_SHOES_BUTTON).click();
    }
    public void clickBagsButton(){
        driver.findElement(FILTER_BAGS_BUTTON).click();
    }
    public void clickSuitButton(){
        driver.findElement(FILTER_SUIT_BUTTON).click();
    }




}
