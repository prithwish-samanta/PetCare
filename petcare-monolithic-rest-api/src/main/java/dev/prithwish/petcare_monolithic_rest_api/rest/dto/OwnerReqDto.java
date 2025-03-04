package dev.prithwish.petcare_monolithic_rest_api.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Schema(
        title = "Owner input message",
        description = "Editable fields of a pet owner."
)
public class OwnerReqDto {
    @Schema(
            title = "Last name",
            description = "The last name of the pet owner.",
            minLength = 1,
            maxLength = 30,
            pattern = "^[a-zA-Z]*$",
            example = "Franklin"
    )
    @NotEmpty(message = "{lastname.notempty}")
    private String lastName;
    @Schema(
            title = "First name",
            description = "The first name of the pet owner.",
            minLength = 1,
            maxLength = 30,
            pattern = "^[a-zA-Z]*$",
            example = "George"
    )
    private String firstName;
    @Schema(
            title = "Address",
            description = "The postal address of the pet owner.",
            minLength = 1,
            maxLength = 225,
            example = "110 W. Liberty St."
    )
    @NotEmpty(message = "{address.notempty}")
    private String address;
    @Schema(
            title = "City",
            description = "The city of the pet owner.",
            minLength = 1,
            maxLength = 180,
            example = "Madison"
    )
    @NotEmpty(message = "{city.notempty}")
    private String city;
    @Schema(
            title = "Telephone number",
            description = "The telephone number of the pet owner.",
            pattern = "^$|[0-9]{10}",
            example = "6085551023"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "{telephone.pattern.mismatch}")
    private String telephone;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
