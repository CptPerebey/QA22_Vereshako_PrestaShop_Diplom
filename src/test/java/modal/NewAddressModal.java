package modal;

import dataModels.Address;
import elements.Dropdown;
import elements.Input;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
@Log4j2
public class NewAddressModal extends BaseModal{
    public NewAddressModal(WebDriver driver) {
        super(driver);
    }

    public void fillFormAddress(Address address) {
        log.info(String.format("Заполняю поля для создания адреса %s",address));
        new Input(driver, "firstname").setValue(address.getFirstName());
        new Input(driver, "lastname").setValue(address.getLastName());
        new Input(driver, "address1").setValue(address.getAddress());
        new Input(driver, "postcode").setValue(address.getZipCode());
        new Input(driver, "city").setValue(address.getCity());
        new Input(driver, "phone").setValue(address.getHomePhone());
        new Dropdown(driver, "id_state").selectDropdownValue(address.getState().getName());
        new Input(driver, "city").setValue(address.getCity());
        new Input(driver, "alias").setValue(address.getAddressTitle());
    }
}
