package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;
@Log4j2
public class Input extends BaseElement{
    public Input(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValue(String value) {
        WebElement inputElement = driver.findElement(By.id(label));
        if (Objects.nonNull(value)) {
            scrollIntoView(inputElement);
            inputElement.sendKeys(value);
        }
    }
}
