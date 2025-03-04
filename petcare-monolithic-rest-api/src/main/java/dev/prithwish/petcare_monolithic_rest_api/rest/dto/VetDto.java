package dev.prithwish.petcare_monolithic_rest_api.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(
        title = "Vet",
        description = "A veterinarian."
)
public class VetDto {
    @Schema(
            title = "ID",
            description = "The ID of the vet.",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private int id;
    @Schema(
            title = "First name",
            description = "The first name of the vet.",
            example = "James",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private String firstName;
    @Schema(
            title = "Last name",
            description = "The last name of the vet.",
            example = "Carter",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private String lastName;
    @Schema(
            title = "Specialties",
            description = "The specialties of the vet.",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private List<SpecialtyDto> specialties;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<SpecialtyDto> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<SpecialtyDto> specialties) {
        this.specialties = specialties;
    }
}
