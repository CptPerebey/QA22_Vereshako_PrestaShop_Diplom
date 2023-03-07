package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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


    public void setFirstnameInput(String firstname){
        log.info(String.format("Ввожу имя %s", firstname));
        driver.findElement(FIRSTNAME_INPUT).sendKeys(firstname);
    }
    public void setLastnameInput(String lastname){
        log.info(String.format("Ввожу фамилию %s", lastname));
        driver.findElement(LASTNAME_INPUT).sendKeys(lastname);
    }
    public void setPasswordInput(String password){
        log.info(String.format("Ввожу пароль %s", password));
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }
    public void clickNewAccountButton(){
        driver.findElement(CLICK_NEW_ACCOUNT_BUTTON).click();
    }



}
