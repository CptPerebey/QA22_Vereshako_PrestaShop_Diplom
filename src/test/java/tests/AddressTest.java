package tests;

import dataModels.Address;
import dataModels.User;
import enums.State;
import modal.NewUserModal;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddressTest extends BaseTest{
    @Test(groups = {"SmokeTests"},retryAnalyzer = RetryAnalyzer.class, description = "Тест на добавление адреса для аккаунта")
    public void addNewAddress() {
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
        myAccountPage.clickMyAddressButton();
        Address testAddress = Address.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().firstName())
                .address(faker.address().streetAddress())
                .zipCode(String.valueOf(faker.number().numberBetween(10000, 99999)))
                .city(faker.address().city())
                .homePhone(faker.phoneNumber().phoneNumber())
                .state(State.ALASKA)
                .addressTitle(faker.name().firstName())
                .build();
        newAddressModal.fillFormAddress(testAddress);
        myAddressesPage.clickSaveButton();
        Assert.assertTrue(myAddressesPage.successfulCreatedAddressMessage());

    }
}
