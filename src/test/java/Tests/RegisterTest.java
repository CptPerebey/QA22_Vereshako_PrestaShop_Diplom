package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{
    @Test
    public void positiveRegisterTest() throws InterruptedException {
        headPage.clickLoginButton();
        authenticationPage.setEmailForRegister("Sobaka212@mail.ru");
        authenticationPage.clickCreateButtonAccount();
        Thread.sleep(5000);
        creatAccountPage.setFirstnameInput("Alexxx");
        creatAccountPage.setLastnameInput("Sobaka");
        creatAccountPage.setPasswordInput("qwe123qwe123");
        // creatAccountPage.selectDayOption("2");
        //creatAccountPage.selectMonthsOption("April");
        // creatAccountPage.selectYearsOption("1996");
        creatAccountPage.setClickNewAccountButton();
        Thread.sleep(5000);
        Assert.assertEquals(myAccountPage.getAccountMassage(),"Welcome to your account. Here you can manage all of your personal information and orders.");
    }

}
