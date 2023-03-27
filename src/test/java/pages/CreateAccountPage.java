package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class CreateAccountPage extends BasePage {
    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    private final static By LASTNAME_INPUT = By.id("customer_lastname");
    private final static By CLICK_NEW_ACCOUNT_BUTTON = By.id("submitAccount");


    @Step

    public void clickNewAccountButton() {
        log.info(String.format("Кликаю по кнопке Создать аккаун"));
        driver.findElement(CLICK_NEW_ACCOUNT_BUTTON).click();
    }

    @Step
    public void waitLastNameInputIsPresent() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LASTNAME_INPUT));
    }

}
