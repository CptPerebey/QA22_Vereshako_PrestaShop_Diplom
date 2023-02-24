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
}
