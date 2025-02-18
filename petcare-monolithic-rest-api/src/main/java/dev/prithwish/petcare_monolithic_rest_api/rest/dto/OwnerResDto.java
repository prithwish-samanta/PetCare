package dev.prithwish.petcare_monolithic_rest_api.rest.dto;

import java.util.Set;

public class OwnerResDto {
    private int id;
    private String lastName;
    private String firstName;
    private String address;
    private String city;
    private String telephone;
    private Set<PetResDto> pets;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Set<PetResDto> getPets() {
        return pets;
    }

    public void setPets(Set<PetResDto> pets) {
        this.pets = pets;
    }
}
