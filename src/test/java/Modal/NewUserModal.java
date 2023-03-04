package Modal;

import DataModels.User;
import elements.Input;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
@Log4j2
public class NewUserModal extends BaseModal {
    public NewUserModal(WebDriver driver) {
        super(driver);
    }
    public static void fillFormUser(User user) {
        log.info("Заполняю полять для создания аккаунта");
        new Input(driver, "customer_firstname").setValue(user.getFirstName());
        new Input(driver, "customer_lastname").setValue(user.getLastName());
        new Input(driver, "passwd").setValue(user.getPassword());
    }
}
