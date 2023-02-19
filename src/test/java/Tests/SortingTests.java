package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SortingTests extends BaseTest{
    @Test(groups = {"Smoke"}, description = "Test to check the sorting of products on the main page",
            dataProvider = "productsSortingTestData")
    public void sortingTestOnHeadPage(String optionName, List<String> expectedItemList) {
        headPage.selectSortingOrderOption2(optionName);
        Assert.assertEquals(headPage.getSortingListItemName(), expectedItemList);
    }
    @DataProvider()
    public Object[][] productsSortingTestData() {
        return new Object[][]{
                {"Popular", Arrays.asList("Faded Short Sleeve T-shirts", "Blouse", "Printed Dress",
                        "Dress", "Printed Summer Dress", "Printed Summer Dress","Printed Chiffon Dress","Black blouse with flowers")},
                {"HeadLiner", Arrays.asList("Blouse","Faded Short Sleeve T-shirts",
                        "Printed Dress","Printed Summer Dress","Printed Chiffon Dress","Printed Summer Dress")},

        };
    }
}
