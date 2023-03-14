package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dropdown extends BaseElement{
    private final static String OPTION_DROPDOWN_LOCATOR = "//*[@id='id_state']/option[text()='%s']";

    public Dropdown(WebDriver driver, String label) {
        super(driver, label);
    }

    public void selectDropdownValue(String optionName)  {
        WebElement dropdownButton = driver.findElement(By.id(label));
        scrollIntoView(dropdownButton);
        dropdownButton.click();
        driver.findElement(By.xpath(String.format(OPTION_DROPDOWN_LOCATOR, optionName))).click();
    }
}
