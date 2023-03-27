package tests;

import dataModels.User;
import modal.NewUserModal;
import org.testng.annotations.*;
import pages.MyAccountPage;
import org.testng.Assert;

public class LoginTest extends BaseTest {


    @Test(dataProvider = "negativeLoginTestData", groups = "Regression", description = "Негативный тест на авторизацию")
    public void negativeLoginTest(String email, String password, String errorMassage) {
        headPage.clickLoginButton();
        authenticationPage.setLoginEmailInput(email);
        authenticationPage.setLoginPasswordInput(password);
        authenticationPage.clickSignInButton();
        Assert.assertEquals(authenticationPage.getErrorMassage(), errorMassage);

    }

    @DataProvider
    public Object[][] negativeLoginTestData() {
        return new Object[][]{
                {"   ", "  ", "An email address required."},
                {"22222", " ", "Invalid email address."},
                {"qweqweqw@mail.ru", "222222", "Authentication failed."},
        };
    }

    @Test(groups = {"SmokeTests", "loginTest"}, description = "Тест на авторизацию")
    public void loginTestWithRandomData() {
        headPage.clickLogOutButton();
        headPage.clickLoginButton();
        authenticationPage.setLoginEmailInput(BASE_EMAIL);
        authenticationPage.setLoginPasswordInput(BASE_PASSWORD);
        authenticationPage.clickSignInButton();
        Assert.assertEquals(myAccountPage.getAccountMassage(), POSITIVE_REGISTER_MASSAGE);

    }
}

