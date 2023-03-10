package tests;

import dataModels.Address;
import dataModels.User;
import enums.State;
import modal.NewUserModal;
import io.qameta.allure.Attachment;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class CardTests extends BaseTest {
    @Test(groups = {"SmokeTests"},description = "Тест на добавление товара в корзину")
    public void addToCardTest() {
        String name = "Faded Short Sleeve T-shirts";
        headPage.waitLastElementOnHeadPage();
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
        headPage.clickWomenButton();
        womenPage.clickItemByNameWithAction(name);
        productDetailsPage.waitAddToCardButtonIsPresent();
        productDetailsPage.clickAddToCardItem();
        productDetailsPage.waitAddToCardMassageIsPresent();
        Assert.assertTrue(productDetailsPage.checkAddToCard());
    }
    @Test(groups = {"Negative"},description = "Тест падает из-за бага в корзине")
    public void deleteItemFromCard() {
        String name = "Faded Short Sleeve T-shirts";
        headPage.clickWomenButton();
        womenPage.clickItemByNameWithAction(name);
        productDetailsPage.clickAddToCardItem();
        womenPage.clickCloseWindow();
        headPage.clickCardButton();
        cardPage.clickDeleteItemButton();
        Assert.assertEquals(cardPage.getItemPrice(), 0);

    }

    @Test(groups = {"SmokeTests"},retryAnalyzer = RetryAnalyzer.class, description = "Тест на покупку товара")
    public void buyItem()  {
        String itemName = "Blouse";
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
        headPage.clickWomenButton();
        womenPage.clickItemByNameWithAction(itemName);
        productDetailsPage.waitAddToCardButtonIsPresent();
        productDetailsPage.clickAddToCardItem();
        womenPage.clickCloseWindow();
        headPage.clickCardButton();
        cardPage.clickProcessedToCheckoutButton();
        cardPage.clickProcessedToCheckoutButtonOnAddressStep();
        cardPage.clickAgreeWithDeliveryButton();
        cardPage.clickProcessedToCheckoutButton();
        Assert.assertEquals(cardPage.getEndMassage(),"No payment modules have been installed.");

    }
    @Test(groups = {"Regression"},retryAnalyzer = RetryAnalyzer.class,description = "Тест на добавление товара в список желаемого")
    public void addItemToWishList() throws InterruptedException {
        String firstItemNameTest = "Blouse";
        String secondItemNameTest = "Faded Short Sleeve T-shirts";
        headPage.clickLoginButton();
        authenticationPage.setEmailForRegister(faker.internet().emailAddress());
        Thread.sleep(2000);
        authenticationPage.clickCreateButtonAccount();
        Thread.sleep(2000);
        User testUser = User.builder()
                .lastName(faker.name().lastName())
                .firstName(faker.name().firstName())
                .password(faker.internet().password())
                .build();
        NewUserModal.fillFormUser(testUser);
        Thread.sleep(2000);
        creatAccountPage.clickNewAccountButton();
        Thread.sleep(2000);
        myAccountPage.clickMyAddressButton();
        Thread.sleep(2000);
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
        Thread.sleep(2000);
        myAddressesPage.clickSaveButton();
        Thread.sleep(2000);
        Assert.assertTrue(myAddressesPage.successfulCreatedAddressMessage());
        headPage.clickWomenButton();
        Thread.sleep(2000);
        womenPage.clickItemByNameWithAction(firstItemNameTest);
        Thread.sleep(2000);
        productDetailsPage.clickAddToWishListButton();
        Thread.sleep(2000);
        productDetailsPage.clickCloseButtonAfterAddToWishL();
        Thread.sleep(2000);
        headPage.clickWomenButton();
        Thread.sleep(2000);
        womenPage.clickItemByNameWithAction(secondItemNameTest);
        Thread.sleep(2000);
        productDetailsPage.clickAddToWishListButton();
        Thread.sleep(2000);
        productDetailsPage.clickCloseButtonAfterAddToWishL();
        Thread.sleep(2000);
        headPage.clickMyAccountButton();
        Thread.sleep(2000);
        myAccountPage.clickMyWishListButton();
        Thread.sleep(2000);
        wishListPage.clickMyWishListButton();
        Thread.sleep(2000);
        Assert.assertEquals(wishListPage.getSortingListItemName(), Arrays.asList("Faded Short Sleeve T-shirts","Blouse"));

    }
}
