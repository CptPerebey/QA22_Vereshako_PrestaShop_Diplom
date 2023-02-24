package Modal;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseModal extends BasePage {
    public BaseModal(WebDriver driver) {
        super(driver);
    }
    private static final By FILTER_TOPS_BUTTON = By.id("layered_category_4");
    private static final By FILTER_DRESSES_BUTTON = By.id("uniform-layered_category_8");
    private static final By FILTER_JACKETS_BUTTON = By.id("uniform-layered_category_14");
    private static final By FILTER_SHOES_BUTTON = By.id("layered_category_15");
    private static final By FILTER_BAGS_BUTTON = By.id("layered_category_16");
    private static final By FILTER_SUIT_BUTTON = By.id("layered_category_17");

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
