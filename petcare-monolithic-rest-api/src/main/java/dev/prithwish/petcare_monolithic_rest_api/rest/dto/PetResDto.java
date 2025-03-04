package dev.prithwish.petcare_monolithic_rest_api.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.Set;

@Schema(
        title = "Pet output message",
        description = "A pet."
)
public class PetResDto {
    @Schema(
            title = "ID",
            description = "The ID of the pet.",
            accessMode = Schema.AccessMode.READ_ONLY,
            minimum = "1",
            example = "1"
    )
    private int id;
    @Schema(
            title = "Name",
            description = "The name of the pet.",
            accessMode = Schema.AccessMode.READ_ONLY,
            example = "Leo"
    )
    private String name;
    @Schema(
            title = "Birth date",
            description = "The date of birth of the pet.",
            format = "date",
            example = "2010-09-07",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private LocalDate birthDate;
    @Schema(
            title = "Pet type",
            description = "Type of the pet",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private PetTypeDto petType;
    @Schema(
            title = "Visits",
            description = "Vet visit bookings for this pet.",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Set<VisitResDto> visits;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public PetTypeDto getPetType() {
        return petType;
    }

    public void setPetType(PetTypeDto petType) {
        this.petType = petType;
    }

    public Set<VisitResDto> getVisits() {
        return visits;
    }

    public void setVisits(Set<VisitResDto> visits) {
        this.visits = visits;
    }
}
