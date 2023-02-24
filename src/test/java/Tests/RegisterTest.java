package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{
    @Test
    public void positiveRegisterTest() throws InterruptedException {
        headPage.clickLoginButton();
        authenticationPage.setEmailForRegister("Sobaka212@mail.ru");
        authenticationPage.clickCreateButtonAccount();
        creatAccountPage.setFirstnameInput("Alexxx");
        creatAccountPage.setLastnameInput("Sobaka");
        creatAccountPage.setPasswordInput("qwe123qwe123");
        creatAccountPage.setClickNewAccountButton();
        Assert.assertEquals(myAccountPage.getAccountMassage(),"Welcome to your account. Here you can manage all of your personal information and orders.");
    }

}
