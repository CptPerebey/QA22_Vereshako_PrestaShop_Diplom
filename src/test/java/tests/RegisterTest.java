package tests;

import dataModels.User;
import modal.NewUserModal;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{
    @Test(description = "Тест на регистрацию для проверки логина")
    public void positiveRegisterTest()  {
        headPage.clickLoginButton();
        authenticationPage.setEmailForRegister("Sobaka212@mail.ru");
        authenticationPage.clickCreateButtonAccount();
        creatAccountPage.setFirstnameInput("Alexxx");
        creatAccountPage.setLastnameInput("Sobaka");
        creatAccountPage.setPasswordInput("qwe123qwe123");
        creatAccountPage.clickNewAccountButton();
        Assert.assertEquals(myAccountPage.getAccountMassage(),"Welcome to your account. Here you can manage all of your personal information and orders.");
    }
    @Test(groups = {"SmokeTests"}, description = "Тест на регистрацию")
    public void positiveRegisterTestWithFaker()  {
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
        Assert.assertEquals(myAccountPage.getAccountMassage(),"Welcome to your account. Here you can manage all of your personal information and orders.");
    }

}
