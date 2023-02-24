package Tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CardTests extends BaseTest {
    @Test
    public void addToCardTest() {
        String name = "Faded Short Sleeve T-shirts";
        Actions actions = new Actions(driver);
        headPage.clickWomenButton();
        actions
                .moveToElement(womenPage.getProductContainerByName(name))
                .click()
                .build()
                .perform();
        productDetailsPage.addToCardItem();
        Assert.assertTrue(productDetailsPage.checkAddToCard());
    }

    @Test
    public void deleteItemFromCard() {
        String name = "Faded Short Sleeve T-shirts";
        Actions actions = new Actions(driver);
        headPage.clickWomenButton();
        actions
                .moveToElement(womenPage.getProductContainerByName(name))
                .click()
                .build()
                .perform();
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
}
