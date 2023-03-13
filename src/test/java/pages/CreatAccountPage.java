package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class CreatAccountPage extends BasePage{
    public CreatAccountPage(WebDriver driver) {
        super(driver);
    }


    private final static By FIRSTNAME_INPUT = By.id("customer_firstname");
    private final static By LASTNAME_INPUT = By.id("customer_lastname");
    private final static By PASSWORD_INPUT = By.id("passwd");
    private final static By EMAIL_INPUT = By.id("email");
    private final static By CLICK_NEW_ACCOUNT_BUTTON = By.id("submitAccount");
    private final static By CREATE_ACCOUNT_MASSAGE= By.xpath("page-subheading");

    @Step
    public void setFirstnameInput(String firstname){
        log.info(String.format("Ввожу имя %s", firstname));
        driver.findElement(FIRSTNAME_INPUT).sendKeys(firstname);
    }
    @Step
    public void setLastnameInput(String lastname){
        log.info(String.format("Ввожу фамилию %s", lastname));
        driver.findElement(LASTNAME_INPUT).sendKeys(lastname);
    }
    @Step
    public void setPasswordInput(String password){
        log.info(String.format("Ввожу пароль %s", password));
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }
    @Step
    public void clickNewAccountButton(){
        driver.findElement(CLICK_NEW_ACCOUNT_BUTTON).click();
    }

    @Step
    public void waitLastNameInputIsPresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(LASTNAME_INPUT));
    }
}
