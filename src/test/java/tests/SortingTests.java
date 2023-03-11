package tests;

import io.qameta.allure.Attachment;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SortingTests extends BaseTest{
    @Test(groups = {"Regression"}, description = "Тест для проверки фильтрации на главной странице ",
            dataProvider = "productsSortingTestDataForHeadPage")
    public void sortingTestOnHeadPage(String optionName, List<String> expectedItemList) {
        headPage.selectSortingOrderOption(optionName);
        Assert.assertEquals(headPage.getSortingListItemName(), expectedItemList);
    }
    @DataProvider()
    public Object[][] productsSortingTestDataForHeadPage() {
        return new Object[][]{
                {"Popular", Arrays.asList("Faded Short Sleeve T-shirts", "Blouse", "Printed Dress",
                        "Dress", "Printed Summer Dress", "Printed Summer Dress","Printed Chiffon Dress","Black blouse with flowers")},
                {"HeadLiner", Arrays.asList("Blouse","Faded Short Sleeve T-shirts",
                        "Printed Dress","Printed Summer Dress","Printed Chiffon Dress","Printed Summer Dress")},

        };
    }
    @Test(groups = {"Regression"}, dataProvider = "inventoryItemsTestData",description = "Тест на проверку товаров в каталоге")
    public void checkingGoodsInTheCatalogTest(String nameItem, String priceItem) {
        headPage.clickWomenButton();
        Assert.assertTrue(womenPage.getProductName(nameItem));
        Assert.assertTrue(womenPage.getProductPrice(priceItem));
    }

    @DataProvider
    public Object[][] inventoryItemsTestData() {
        return new Object[][]{
                {"Faded Short Sleeve T-shirts", "19,81"},
                {"Blouse", "32,40"},
                {"Printed Dress", "31,20"},
                {"Dress", "61,19"},
                {"Printed Summer Dress", "36,61"},
                {"Printed Summer Dress", "36,60"},
                {"Blue Printed Maxi Dress", "432,00"},
                {"Printed Chiffon Dress", "24,60"},
                {"Black blouse with flowers", "660,00"},
                {"V Neckline  Top - White", "432,00"},
                {"V-back Dress", "420,00"},
                {"Floral Top  ", "624,00"},
        };
    }
    @Test(groups = {"SmokeTests","Negative"}, description = "Тест для проверки сортировки на WomanPage",
            dataProvider = "productsSortingTestDataForWomenPage")
    public void sortingTest(String optionName,List<String> expectedItemList) {
        headPage.clickWomenButton();
        womenPage.selectSortingOrderOption(optionName);
        womenPage.waitDownloadItem();
        Assert.assertEquals(womenPage.getSortingListItemName(), expectedItemList);
    }

    @DataProvider()
    public Object[][] productsSortingTestDataForWomenPage() {
        return new Object[][]{
                {"--", Arrays.asList("Faded Short Sleeve T-shirts", "Blouse", "Printed Dress",
                        "Dress", "Printed Summer Dress", "Printed Summer Dress","Blue Printed Maxi Dress",
                        "Printed Chiffon Dress","Black blouse with flowers","V Neckline Top - White",
                        "V-back Dress","Floral Top")},
                {"Price: Lowest first", Arrays.asList("Printed Chiffon Dress","Faded Short Sleeve T-shirts","Printed Dress", "Blouse",
                        "Printed Summer Dress","Printed Summer Dress", "Dress", "White Top",
                        "Black top","Red Dress", "White Lace Cami Romper","Blue blouse")},
                {"Price: Highest first", Arrays.asList("Red Maxi Dress", "Classic Black Suite",
                        "Classic Black Medium length Sleeve Suite", "Black Pantsuit", "Long Black Jacket","Elegant Beige Suite",
                        "Knitted Beige Jacket","Womanly Grey Suite","Light Grey Suite",
                        "Warm Red Jacket","Light White Sweater","Knitted Brown Jacket")},
                {"Product Name: A to Z", Arrays.asList("Abstract Print Summer Dress", "Air Red Dress", "Black and white striped top",
                        "Black And White Stripes T-shirt", "Black And White Stripes Top", "Black blouse with flowers","Black Bodycon Dress",
                        "Black Chiffon Dress","Black Pantsuit","Black top",
                        "Black Top","Blouse")},
                {"Product Name: Z to A", Arrays.asList("Crocodile bag", "Clutches  in stock", "Yellow Cotton T-Shirt",
                        "Wool Light Brown Jacket", "Womanly Grey Suite", "White Top","White Top",
                        "White Lace Cami Romper","White Jacket","White Crisscross Back Shift Dress",
                        "White Cotton Top","White Cotton Shirt")},


        };
    }
    @Test(groups = {"Regression"}, dataProvider = "inventoryItemsTestDataWithFilter",description = "Тест падает так как часть названий товаров написано кириллицой")
    public void checkingGoodsInTheCatalogWithFilterTest(List<String> nameItem, List <String> priceItem) {
        headPage.clickWomenButton();
        baseModal.clickBagsButton();
        womenPage.waitCloseButtonInFilter();

        Assert.assertEquals(womenPage.getSortingListItemName(), nameItem);
    }

    @DataProvider
    public Object[][] inventoryItemsTestDataWithFilter() {
        return new Object[][]{
                {Arrays.asList("Leatherette bags in stock","Stylish leather bags in stock","Leather bags in stock",
                        "Leather bags with wooden handle in stock","Braided leather bags in stock","Leather bags in stock",
                        "Leather light brown bag","Crocodile bag" ,"Clutches in stock"),
                        Arrays.asList("30.72","32.37","37.31", "37.86", "42.79", "43.07", "43.34", "65.84")},
        };
    }
}
