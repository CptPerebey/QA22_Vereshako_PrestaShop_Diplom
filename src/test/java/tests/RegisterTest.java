package tests;

import dataModels.User;
import modal.NewUserModal;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
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
        newUserModal.fillFormUser(testUser);
        creatAccountPage.clickNewAccountButton();
        Assert.assertEquals(myAccountPage.getAccountMassage(), POSITIVE_REGISTER_MASSAGE);
    }

}
