package dev.prithwish.petcare_monolithic_rest_api.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Schema(
        title = "Pet input message",
        description = "Editable fields of a pet."
)
public class PetReqDto {
    @Schema(
            title = "Name",
            description = "The name of the pet.",
            maxLength = 30,
            example = "Leo"
    )
    @NotEmpty(message = "{name.notempty}")
    private String name;
    @Schema(
            title = "Birth date",
            description = "The date of birth of the pet.",
            format = "date",
            example = "2010-09-07"
    )
    @PastOrPresent(message = "{date.present.or.past.mismatch}")
    private LocalDate birthDate;
    @Schema(
            title = "Pet type",
            description = "Type of the pet.",
            example = "dog"
    )
    @NotEmpty(message = "{pettype.notempty}")
    private String petType;

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

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }
}
