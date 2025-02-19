package dev.prithwish.petcare_monolithic_rest_api.rest.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class OwnerReqDto {
    @NotEmpty(message = "{lastname.notempty}")
    private String lastName;
    private String firstName;
    @NotEmpty(message = "{address.notempty}")
    private String address;
    @NotEmpty(message = "{city.notempty}")
    private String city;
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
