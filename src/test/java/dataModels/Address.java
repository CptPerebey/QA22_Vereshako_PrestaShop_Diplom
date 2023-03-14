package dataModels;
import enums.State;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String firstName;
    private String lastName;
    private String address;
    private String zipCode;
    private String city;
    private String homePhone;
    private State state;
    private String addressTitle;
}
