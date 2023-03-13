package tests;

import org.testng.annotations.DataProvider;
import pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test(groups = {"Regression"},description = "Тест на проверку авторизации")
    public void loginTest(){
        headPage.clickLoginButton();
        authenticationPage.setLoginEmailInput(BASE_USERNAME);
        authenticationPage.setLoginPasswordInput(BASE_PASSWORD);
        authenticationPage.clickSignInButton();
        Assert.assertEquals(MyAccountPage.getAccountMassage(),"Welcome to your account. Here you can manage all of your personal information and orders.");
    }
    @Test(dataProvider = "negativeLoginTestData", groups = "Smoke", description = "Негативный тест на авторизацию")
    public void negativeLoginTest(String email,String password, String errorMassage){
        headPage.clickLoginButton();
        authenticationPage.setLoginEmailInput(email);
        authenticationPage.setLoginPasswordInput(password);
        authenticationPage.clickSignInButton();
        Assert.assertEquals(authenticationPage.getErrorMassage(),errorMassage);

    }
    @DataProvider
    public Object[][] negativeLoginTestData() {
        return new Object[][]{
                {"   ", "  ", "An email address required."},
                {"22222", " ", "Invalid email address."},
                {"qweqweqw@mail.ru", "222222", "Authentication failed."},
        };
    }
}
