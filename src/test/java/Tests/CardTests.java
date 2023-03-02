package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class CardTests extends BaseTest {
    @Test
    public void addToCardTest() {
        String name = "Faded Short Sleeve T-shirts";
        headPage.clickWomenButton();
        womenPage.clickItemByNameWithAction(name);
        productDetailsPage.addToCardItem();
        productDetailsPage.waitAddToCardMassageIsPresent();
        Assert.assertTrue(productDetailsPage.checkAddToCard());
    }

    @Test(description = "Тест падает из-за бага в корзине")
    public void deleteItemFromCard() {
        String name = "Faded Short Sleeve T-shirts";
        headPage.clickWomenButton();
        womenPage.clickItemByNameWithAction(name);
        productDetailsPage.addToCardItem();
        womenPage.clickCloseWindow();
        headPage.clickCardButton();
        cardPage.clickDeleteItemButton();
        Assert.assertEquals(cardPage.getItemPrice(), 0);

    }

    @Test
    public void buyItem() throws InterruptedException {
        String itemName = "Blouse";
        headPage.clickLoginButton();
        authenticationPage.setLoginEmailInput("Sobaka212@mail.ru");
        authenticationPage.setLoginPasswordInput("qwe123qwe123");
        authenticationPage.clickSignInButton();
        headPage.clickWomenButton();
        womenPage.getProductContainerByName(itemName).click();
        productDetailsPage.addToCardItem();
        womenPage.clickCloseWindow();
        headPage.clickCardButton();
        cardPage.clickProcessedToCheckoutButton();
        Thread.sleep(2000);
        cardPage.clickProcessedToCheckoutButtonOnAddressStep();
        cardPage.clickAgreeWithDeliveryButton();
        Thread.sleep(2000);
        cardPage.clickProcessedToCheckoutButton();
        Assert.assertEquals(cardPage.getEndMassage(),"No payment modules have been installed.");

    }
    @Test
    public void addItemToWishList() {
        String firstItemNameTest = "Blouse";
        String secondItemNameTest = "Faded Short Sleeve T-shirts";
        headPage.clickLoginButton();
        authenticationPage.setLoginEmailInput("Sobaka212@mail.ru");
        authenticationPage.setLoginPasswordInput("qwe123qwe123");
        authenticationPage.clickSignInButton();
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
