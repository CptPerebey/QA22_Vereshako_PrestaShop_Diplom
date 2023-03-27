package modal;

import pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseModal extends BasePage {
    public BaseModal(WebDriver driver) {
        super(driver);
    }

    private static final By FILTER_BAGS_BUTTON = By.xpath("//a[@rel ='nofollow' and contains(text(),'Bags')]/ancestor::li//input[@class ='checkbox']");

    public void clickBagsButton() {
        driver.findElement(FILTER_BAGS_BUTTON).click();
    }


}
