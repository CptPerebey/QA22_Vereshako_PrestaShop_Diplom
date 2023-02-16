package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage extends BasePage{
    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }
    protected final static By EMAIL_INPUT = By.id("email_create");
    protected final static By CREATE_ACCOUNT_BUTTON = By.id("SubmitCreate");
    protected final static By LOGIN_EMAIL_INPUT = By.id("email");
    protected final static By LOGIN_PASSWORD_INPUT= By.id("passwd");
    protected final static By SIGN_IN_BUTTON = By.id("SubmitLogin");

    public void setLoginEmailInput(String email){
        driver.findElement(LOGIN_EMAIL_INPUT).sendKeys(email);
    }
    public void setLoginPasswordInput(String passwordInput){
        driver.findElement(LOGIN_PASSWORD_INPUT).sendKeys(passwordInput);
    }
    public void clickSignInButton(){
        driver.findElement(SIGN_IN_BUTTON).click();
    }


    public void setEmailForRegister(String email){
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }
    public void clickCreateButtonAccount(){
        driver.findElement(CREATE_ACCOUNT_BUTTON).click();
    }
}
