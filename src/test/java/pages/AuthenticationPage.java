package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class AuthenticationPage extends BasePage {
    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    protected final static By EMAIL_INPUT = By.id("email_create");
    protected final static By CREATE_ACCOUNT_BUTTON = By.id("SubmitCreate");
    protected final static By LOGIN_EMAIL_INPUT = By.id("email");
    protected final static By LOGIN_PASSWORD_INPUT = By.id("passwd");
    protected final static By SIGN_IN_BUTTON = By.id("SubmitLogin");
    protected final static By ERROR_MASSAGE = By.xpath("//*[@class='alert alert-danger']/ol/li ");

    @Step
    public void setLoginEmailInput(String email) {
        log.info(String.format("Ввожу email для авторизации %s ", email));
        driver.findElement(LOGIN_EMAIL_INPUT).sendKeys(email);
    }

    @Step
    public void setLoginPasswordInput(String passwordInput) {
        log.info(String.format("Ввожу пароль для авторизации %s", passwordInput));
        driver.findElement(LOGIN_PASSWORD_INPUT).sendKeys(passwordInput);
    }

    @Step
    public void clickSignInButton() {
        log.info("Кликаю по кнопке SignIn");
        driver.findElement(SIGN_IN_BUTTON).click();
    }

    @Step
    public void setEmailForRegister(String email) {
        log.info(String.format("Ввожу email для регистрации %s", email));
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    @Step
    public void clickCreateButtonAccount() {
        log.info("Кликаю по кнопке Создать аккаун");
        driver.findElement(CREATE_ACCOUNT_BUTTON).click();
    }

    @Step
    public String getErrorMassage() {
        return driver.findElement(ERROR_MASSAGE).getText();
    }


}
