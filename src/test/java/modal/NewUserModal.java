package modal;

import dataModels.User;
import elements.Input;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
@Log4j2
public class NewUserModal extends BaseModal {
    public NewUserModal(WebDriver driver) {
        super(driver);
    }
    public void fillFormUser(User user) {
        log.info(String.format("Заполняю поля для создания аккаунта %s",user));
        new Input(driver, "customer_firstname").setValue(user.getFirstName());
        new Input(driver, "customer_lastname").setValue(user.getLastName());
        new Input(driver, "passwd").setValue(user.getPassword());
    }
}
