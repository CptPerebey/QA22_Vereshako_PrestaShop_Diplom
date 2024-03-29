package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class SearchTest extends BaseTest {
    @Test(groups = {"SmokeTests"}, retryAnalyzer = RetryAnalyzer.class, description = "Тест на поиск товара с помощью поисковой строки")
    public void searchTest() {
        String itemName = "Blouse";
        headPage.loginButtonIsPresent();
        headPage.setSearchInput(itemName);
        headPage.clickSearchButton();
        Assert.assertEquals(womenPage.getSortingListItemName(), Arrays.asList("Blouse", "Fuchsia Silk Sleeveless Blouse",
                "Green Chiffon Sleeveless Blouse", "Red Cotton Blouse", "Blue blouse", "Black blouse with flowers",
                "White Cotton Shirt", "Vertical Striped Shirt", "Navy Cotton T-Shirt",
                "Fuchsia Silk Top", "V Neckline Top - White", "Foliage Printed Top"));
    }
}
