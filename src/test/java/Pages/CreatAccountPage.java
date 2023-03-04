package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreatAccountPage extends BasePage{
    public CreatAccountPage(WebDriver driver) {
        super(driver);
    }


    private final static By FIRSTNAME_INPUT = By.id("customer_firstname");
    private final static By LASTNAME_INPUT = By.id("customer_lastname");
    private final static By PASSWORD_INPUT = By.id("passwd");
    private final static By EMAIL_INPUT = By.id("email");
    private final static By DAY_OF_BIRTH_LOCATOR = By.id("days");
    private final static By MONTHS_OF_BIRTH_LOCATOR = By.id("months");
    private final static By YEARS_OF_BIRTH_LOCATOR = By.id("cuselFrame-years");
    private final static By CLICK_NEW_ACCOUNT_BUTTON = By.id("submitAccount");


    public void setFirstnameInput(String firstname){
        driver.findElement(FIRSTNAME_INPUT).sendKeys(firstname);
    }
    public void setLastnameInput(String lastname){
        driver.findElement(LASTNAME_INPUT).sendKeys(lastname);
    }
    public void setPasswordInput(String password){
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }
    public void setEmailInput(String email){
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }
    public void clickNewAccountButton(){
        driver.findElement(CLICK_NEW_ACCOUNT_BUTTON).click();
    }



}
