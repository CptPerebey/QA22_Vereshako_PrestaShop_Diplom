package tests;

import pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test(groups = {"SmokeTests"},description = "Тест на проверку авторизации")
    public void loginTest(){
        headPage.clickLoginButton();
        authenticationPage.setLoginEmailInput(BASE_USERNAME);
        authenticationPage.setLoginPasswordInput(BASE_PASSWORD);
        authenticationPage.clickSignInButton();
        Assert.assertEquals(MyAccountPage.getAccountMassage(),"Welcome to your account. Here you can manage all of your personal information and orders.");
    }
}
