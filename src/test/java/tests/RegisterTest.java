package tests;

import dataModels.User;
import modal.NewUserModal;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{
    @Test(description = "Тест на регистрацию для проверки логина")
    public void positiveRegisterTest()  {
        headPage.loginButtonIsPresent();
        headPage.clickLoginButton();
        authenticationPage.setEmailForRegister(BASE_EMAIL);
        authenticationPage.clickCreateButtonAccount();
        creatAccountPage.setFirstnameInput(BASE_USERNAME);
        creatAccountPage.setLastnameInput(BASE_USER_LAST_NAME);
        creatAccountPage.setPasswordInput(BASE_PASSWORD);
        creatAccountPage.clickNewAccountButton();
        Assert.assertEquals(myAccountPage.getAccountMassage(),POSITIVE_REGISTER_MASSAGE);
    }
    @Test(groups = {"SmokeTests"}, description = "Тест на регистрацию")
    public void positiveRegisterTestWithFaker() {
        headPage.loginButtonIsPresent();
        headPage.clickLoginButton();
        authenticationPage.setEmailForRegister(faker.internet().emailAddress());
        authenticationPage.clickCreateButtonAccount();
        User testUser = User.builder()
                .lastName(faker.name().lastName())
                .firstName(faker.name().firstName())
                .password(faker.internet().password())
                .build();
        NewUserModal.fillFormUser(testUser);
        creatAccountPage.clickNewAccountButton();
        Assert.assertEquals(myAccountPage.getAccountMassage(),POSITIVE_REGISTER_MASSAGE);
    }

}
