package dev.prithwish.petcare_monolithic_rest_api.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Set;

@Schema(
        title = "Owner output message",
        description = "A pet owner."
)
public class OwnerResDto {
    @Schema(
            title = "ID",
            description = "The ID of the pet owner.",
            accessMode = Schema.AccessMode.READ_ONLY,
            minimum = "1",
            example = "1"
    )
    private int id;
    @Schema(
            title = "Last name",
            description = "The last name of the pet owner.",
            accessMode = Schema.AccessMode.READ_ONLY,
            example = "Franklin"
    )
    private String lastName;
    @Schema(
            title = "First name",
            description = "The first name of the pet owner.",
            accessMode = Schema.AccessMode.READ_ONLY,
            example = "George"
    )
    private String firstName;
    @Schema(
            title = "Address",
            description = "The postal address of the pet owner.",
            accessMode = Schema.AccessMode.READ_ONLY,
            example = "110 W. Liberty St."
    )
    private String address;
    @Schema(
            title = "City",
            description = "The city of the pet owner.",
            accessMode = Schema.AccessMode.READ_ONLY,
            example = "Madison"
    )
    private String city;
    @Schema(
            title = "Telephone number",
            description = "The telephone number of the pet owner.",
            accessMode = Schema.AccessMode.READ_ONLY,
            example = "6085551023"
    )
    private String telephone;
    @Schema(
            title = "Pets",
            description = "The pets owned by this individual including any booked vet visits.",
            accessMode = Schema.AccessMode.READ_ONLY
    )
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
