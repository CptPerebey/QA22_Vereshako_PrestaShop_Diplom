package tests;

import dataModels.User;
import modal.NewUserModal;
import org.testng.annotations.*;
import pages.MyAccountPage;
import org.testng.Assert;

public class LoginTest extends BaseTest{


    @Test(groups = {"SmokeTests", "loginTest"},description = "Тест на проверку авторизации")
    public void loginTest(){
        headPage.clickLoginButton();
        authenticationPage.setLoginEmailInput(BASE_EMAIL);
        authenticationPage.setLoginPasswordInput(BASE_PASSWORD);
        authenticationPage.clickSignInButton();
        Assert.assertEquals(MyAccountPage.getAccountMassage(),POSITIVE_REGISTER_MASSAGE);
    }
    @Test(dataProvider = "negativeLoginTestData", groups = "SmokeTests", description = "Негативный тест на авторизацию")
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
    @Test(groups = {"SmokeTests"}, description = "Тест на регистрацию")
    public void loginTestWithRandomData() {
        String email= faker.internet().emailAddress();
        String password  = faker.internet().password();
        headPage.loginButtonIsPresent();
        headPage.clickLoginButton();
        authenticationPage.setEmailForRegister(email);
        authenticationPage.clickCreateButtonAccount();
        User testUser = User.builder()
                .lastName(faker.name().lastName())
                .firstName(faker.name().firstName())
                .password(password)
                .build();
        NewUserModal.fillFormUser(testUser);
        creatAccountPage.clickNewAccountButton();
        headPage.clickLogOutButton();
        headPage.clickLoginButton();
        authenticationPage.setLoginEmailInput(email);
        authenticationPage.setLoginPasswordInput(password);
        authenticationPage.clickSignInButton();
        Assert.assertEquals(MyAccountPage.getAccountMassage(),POSITIVE_REGISTER_MASSAGE);

    }
}

