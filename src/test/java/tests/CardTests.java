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
        headPage.clickWomenButton();
        womenPage.clickItemByNameWithAction(name);
        productDetailsPage.waitAddToCardButtonIsPresent();
        productDetailsPage.clickAddToCardItem();
        productDetailsPage.waitAddToCardMassageIsPresent();
        Assert.assertTrue(productDetailsPage.checkAddToCard());
    }
    @Attachment(value = "screenshot", type = "image/png")
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
        headPage.implicitlyWaitForTest();
        authenticationPage.setEmailForRegister(faker.internet().emailAddress());
        authenticationPage.clickCreateButtonAccount();
        headPage.implicitlyWaitForTest();
        User testUser = User.builder()
                .lastName(faker.name().lastName())
                .firstName(faker.name().firstName())
                .password(faker.internet().password())
                .build();
        NewUserModal.fillFormUser(testUser);
        creatAccountPage.clickNewAccountButton();
        headPage.implicitlyWaitForTest();
        myAccountPage.clickMyAddressButton();
        headPage.implicitlyWaitForTest();
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
        headPage.implicitlyWaitForTest();
        headPage.clickWomenButton();
        headPage.implicitlyWaitForTest();
        womenPage.getProductContainerByName(itemName).click();
        productDetailsPage.waitAddToCardButtonIsPresent();
        productDetailsPage.clickAddToCardItem();
        womenPage.clickCloseWindow();
        headPage.clickCardButton();
        cardPage.clickProcessedToCheckoutButton();
        cardPage.waitForProcessedToCheckoutButtonToBeClickable();
        cardPage.clickProcessedToCheckoutButtonOnAddressStep();
        cardPage.clickAgreeWithDeliveryButton();
        cardPage.waitForAgreeWithDeliveryButtonIsSelected();
        cardPage.clickProcessedToCheckoutButton();
        Assert.assertEquals(cardPage.getEndMassage(),"No payment modules have been installed.");

    }
    @Test(groups = {"Regression"},retryAnalyzer = RetryAnalyzer.class,description = "Тест на добавление товара в список желаемого")
    public void addItemToWishList() {
        String firstItemNameTest = "Blouse";
        String secondItemNameTest = "Faded Short Sleeve T-shirts";
        headPage.clickLoginButton();
        headPage.implicitlyWaitForTest();
        authenticationPage.setEmailForRegister(faker.internet().emailAddress());
        authenticationPage.waitToCreateButtonIsPresent();
        authenticationPage.clickCreateButtonAccount();
        headPage.implicitlyWaitForTest();
        User testUser = User.builder()
                .lastName(faker.name().lastName())
                .firstName(faker.name().firstName())
                .password(faker.internet().password())
                .build();
        NewUserModal.fillFormUser(testUser);
        creatAccountPage.clickNewAccountButton();
        headPage.implicitlyWaitForTest();
        myAccountPage.clickMyAddressButton();
        headPage.implicitlyWaitForTest();
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
        headPage.implicitlyWaitForTest();
        Assert.assertTrue(myAddressesPage.successfulCreatedAddressMessage());
        headPage.clickWomenButton();
        womenPage.clickItemByNameWithAction(firstItemNameTest);
        productDetailsPage.clickAddToWishListButton();
        productDetailsPage.clickCloseButtonAfterAddToWishL();
        headPage.clickWomenButton();
        womenPage.clickItemByNameWithAction(secondItemNameTest);
        productDetailsPage.clickAddToWishListButton();
        productDetailsPage.clickCloseButtonAfterAddToWishL();
        headPage.clickMyAccountButton();
        myAccountPage.clickMyWishListButton();
        wishListPage.clickMyWishListButton();
        Assert.assertEquals(wishListPage.getSortingListItemName(), Arrays.asList("Faded Short Sleeve T-shirts","Blouse"));

    }
}
