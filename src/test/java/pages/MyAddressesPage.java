package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class MyAddressesPage extends BasePage{
    private static final By SAVE_BUTTON_LOCATOR = By.cssSelector("#submitAddress");
    private static final By SUCCESS_ADD_ADDRESSES_LOCATOR = By.cssSelector("[title='Update']");
    public MyAddressesPage(WebDriver driver) {
        super(driver);
    }
    @Step
    public void clickSaveButton(){
        log.info("Кликаю по кнопке сохранить на странице добавления адреса");
        driver.findElement(SAVE_BUTTON_LOCATOR).click();
    }
    @Step
    public boolean successfulCreatedAddressMessage(){
        log.info("Проверяю добавлен ли новый адрес");
        return driver.findElement(SUCCESS_ADD_ADDRESSES_LOCATOR).isDisplayed();
    }
    @Step
    public void waitSaveButtonIsPresent(){
        wait.until(ExpectedConditions.presenceOfElementLocated(SAVE_BUTTON_LOCATOR));
    }

}
